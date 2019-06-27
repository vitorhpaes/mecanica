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
import sistema.Veiculo;

/**
 *
 * @author Yan
 */
public class veiculoDAO extends Veiculo {

    private String table = "veiculo";

    public veiculoDAO() {
    }

    public veiculoDAO(String modelo, String marca, int clienteId, String placa) {
        super(modelo, marca, clienteId, placa);
    }

    private String getColumns() {
        return "Modelo, Marca, ClienteId, Placa";
    }

    private String getValues() {
        String placaUpper = getPlaca().toUpperCase();
        return "'" + getModelo() + "', '" + getMarca() + "', '" + getClienteId() + "', '" + placaUpper + "'";
    }

    //insert de veiculos
    public JSONArray insert() {

        Long register;
        JSONArray json = new JSONArray();

        try {

            genericDM.crud = new pdoCrud();
            register = genericDM.crud.insert(this.table, this.getColumns(), this.getValues());
            json.put(register);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;

    }

    //query de veiculos
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

    public JSONArray getByClientId(int id) {
        String sql = "SELECT * FROM " + table + " WHERE ClienteId = " + id;

        try {

            genericDM.query = new pdoQuery();
            ResultSet rs = genericDM.query.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }
    }

//    public static void main(String[] args) {
//
//        veiculoDAO v = new veiculoDAO("MODELO", "Marquinha", 1, "PLA-0123");
//        System.out.println(v.insert());
//
//    }
}
