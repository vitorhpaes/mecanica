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
import sistema.Cliente;

/**
 *
 * @author vitor
 */
public class clienteDAO extends Cliente {

    private String table = "cliente";

    public clienteDAO(String nome, String cpf, String email, String cep, String numero, String telefone) {
        super(nome, cpf, email, cep, numero, telefone);
    }

    public clienteDAO() {
    }

    private String getColumns() {
        return "Nome, CPF, CEP, Numero, Email, Telefone";
    }

    private String getValues() {
        return "'" + getNome() + "', '" + getCpf() + "', '" + getCep() + "', '" + getNumero() + "', '" + getEmail() + "', '" + getTelefone() + "'";
    }

    //insert de clientes no banco
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

    //query de clientes
    public JSONArray getClient(int Id) {
        String sql = "SELECT * FROM " + table + " WHERE Id = " + Id;

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
