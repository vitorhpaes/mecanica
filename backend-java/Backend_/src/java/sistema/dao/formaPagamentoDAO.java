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
import sistema.FormaPagamento;

/**
 *
 * @author Yan
 */
public class formaPagamentoDAO extends FormaPagamento {

    private String table = "formaPagto";

    public formaPagamentoDAO() {
    }

    public formaPagamentoDAO(String tipo, int vezes) {
        super(tipo, vezes);
    }

    private String getColumns() {
        return "Tipo, Vezes";
    }

    private String getValues() {
        return "'" + getTipo() + "', '" + getVezes() + "'";
    }

    //insert da table formaPagto
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

    //query tabela formaPagto
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
