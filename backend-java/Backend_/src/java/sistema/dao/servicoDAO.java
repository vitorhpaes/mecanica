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
import org.json.JSONArray;
import sistema.Servico;

/**
 *
 * @author Yan
 */
public class servicoDAO extends Servico {

    private String table = "servico";

    public servicoDAO() {
    }

    public servicoDAO(String nome, String descricao, double valor, int horas, int pecaId) {
        super(nome, descricao, valor, horas, pecaId);
    }

    private String getColumns() {
        return "Nome, Descricao, Valor, Horas, PecaId";
    }

    private String getValues() {
        return "'" + getNome() + "', '" + getDescricao() + "', '" + getValor() + "', '" + getHoras() + "', '" + getPecaId() + "'";
    }

    //insert de serviços no banco
    public JSONArray insert() {

        Long register;
        JSONArray json = new JSONArray();

        try {

            genericDM.crud = new pdoCrud();
            register = genericDM.crud.insert(this.table, this.getColumns(), this.getValues());
            System.out.println(register);
            json.put(register);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;

    }

    //query de serviços
    public JSONArray getAll() {
        String sql = "SELECT s.* FROM " + table + " s LEFT OUTER JOIN peca p on s.PecaId = p.Id";

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
