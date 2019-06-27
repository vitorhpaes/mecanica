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
import java.util.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import sistema.Pagamento;

/**
 *
 * @author Yan
 */
public class pagamentoDAO extends Pagamento {

    private String table = "pagto";

    public pagamentoDAO() {
    }

    public pagamentoDAO(Date dataPagto, Date dataRegistro, int OSId) {
        super(dataPagto, dataRegistro, OSId);
    }

    private String getColumns() {
        return "DataPagto, DataRegistro, OSId";
    }

    private String getValues() {
        System.out.println(getDataPagto());
        System.out.println(getDataRegistro());

        return "'" + getDataPagto() + "', '" + getDataRegistro() + "'," + getOSId();
    }

    //insert da tabela pagto no banco
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

    //query da tabela pagto
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

}
