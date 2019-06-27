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
import sistema.Consumo;

/**
 *
 * @author Yan
 */
public class consumoDAO extends Consumo {

    private String table = "consumo";

    public consumoDAO() {
    }

    public consumoDAO(int servico, int OSId, float valor) {
        super(servico, OSId, valor);
    }

    private String getColumns() {
        return "Servico, OSId, Valor";
    }

    private String getValues() {
        return "'" + getServico() + "', '" + getOSId() + "', '" + getValor() + "'";
    }

    //insert da tabela consumo
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

    //query da tabela consumo
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
