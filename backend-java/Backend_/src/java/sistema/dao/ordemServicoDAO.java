/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.dao;

import dbConnection.genericDM;
import dbConnection.jsonConstruct;
import dbConnection.pdoCrud;
import dbConnection.pdoQuery;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONArray;
import sistema.Consumo;
import sistema.OrdemServico;

/**
 *
 * @author Yan
 */
public class ordemServicoDAO extends OrdemServico {

    private String table = "ordemServico";

    public ordemServicoDAO() {
    }

    public ordemServicoDAO(int clienteId, int veiculoId, int formaPagtoId, double valorTotal, int Status, Date dataPrevista) {
        super(clienteId, veiculoId, formaPagtoId, valorTotal, Status, dataPrevista);
    }

    private String getColumns() {
        return "ClienteId, VeiculoId, ValorTotal, FormaPagtoId, DataPrevista, Status, DataRegistro";
    }

    private String getValues() {
        return "'" + getClienteId() + "', '" + getVeiculoId() + "', '" + getValorTotal() + "', '" + getFormaPagtoId() + "', '" + getDataPrevista() + "', '" + getStatus() + "', NOW()";
    }

    //insert de clientes no banco
    public JSONArray insert() {

        Long register;
        JSONArray json = new JSONArray();

        try {

            genericDM.crud = new pdoCrud();
            register = genericDM.crud.insert(this.table, this.getColumns(), this.getValues());
            for (Consumo consumo : consumos) {
                consumo.setOSId(register.intValue());
                consumoDAO cdao = new consumoDAO(consumo.getServico(), consumo.getOSId(), consumo.getValor());
                cdao.insert();
            }
            json.put(register);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;

    }

    public JSONArray confirmOs(int id) {

        JSONArray json = new JSONArray();
        Boolean update = false;

        try {

            genericDM.crud = new pdoCrud();
            update = genericDM.crud.update(this.table, "Status = 1", "WHERE Id = " + id);
            json.put(update);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

        return json;

    }

    //query de clientes
    public JSONArray getAll() {
        String sql = "SELECT * FROM " + table;

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

    public JSONArray getOpen() {
        String sql = "SELECT *, c.Nome, v.Modelo FROM " + table + ", cliente c, veiculo v WHERE Status = 0 AND c.Id = ordemservico.ClienteId AND v.Id = ordemservico.VeiculoId";

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

    public JSONArray getClosed() {
        String sql = "SELECT *, c.Nome, v.Modelo FROM " + table + ", cliente c, veiculo v WHERE Status = 1 AND c.Id = ordemservico.ClienteId AND v.Id = ordemservico.VeiculoId";

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

    public JSONArray getByClientId(int clientId) {
        String sql = "SELECT * FROM " + table + " WHERE ClienteId = " + clientId;

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

    public JSONArray getByCarId(int carId) {
        String sql = "SELECT * FROM " + table + " WHERE veiculoId = " + carId;

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

}
