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
import sistema.Peca;

/**
 *
 * @author Yan
 */
public class pecaDAO extends Peca {

    private String table = "peca";

    public pecaDAO(String nome, String descricao, double valor) {
        super(nome, descricao, valor);
    }

    public pecaDAO() {

    }

    private String getColumns() {
        return "Nome, Descricao, Valor";
    }

    private String getValues() {
        return "'" + getNome() + "', '" + getDescricao() + "', '" + getValor() + "'";
    }

    //insert de peças no banco
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

    //query de peças
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
