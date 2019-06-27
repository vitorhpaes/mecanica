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
import sistema.Funcionario;

/**
 *
 * @author Yan
 */
public class funcionarioDAO extends Funcionario {

    private String table = "funcionario";

    public funcionarioDAO() {
    }

    public funcionarioDAO(String nome, String dataAdmissao, String setor, double salario) {
        super(nome, dataAdmissao, setor, salario);
    }

    private String getColumns() {
        return "Nome, DataAdmissao, Salario, Setor";
    }

    private String getValues() {
        return "'" + getNome() + "', '" + getDataAdmissao() + "', '" + getSalario() + "', '" + getSetor() + "'";

    }

    //insert de funcionarios
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

    //query de funcionarios
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
