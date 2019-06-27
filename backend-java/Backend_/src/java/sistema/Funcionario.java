package sistema;

import dbConnection.jsonConstruct;
import dbConnection.pdoCrud;
import dbConnection.pdoQuery;
import java.sql.ResultSet;
import java.time.LocalDate;
import org.json.JSONArray;
import sistema.dao.funcionarioDAO;

public class Funcionario {

    private int id;
    private String nome;
    private String dataAdmissao;
    private String setor;
    private double salario;
    private static funcionarioDAO dao;

    public Funcionario(String nome, String dataAdmissao, String setor, double salario) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.setor = setor;
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Funcionario() {
    }

    public static JSONArray methods(String method, funcionarioDAO f) {
        JSONArray jsRet = new JSONArray();
        Funcionario.dao = f;
        switch (method) {
            case "getAll":
                jsRet = dao.getAll();
                break;
            case "insert":
                jsRet = dao.insert();
                break;
        }

        return jsRet;
    }

    /* public Boolean insertFuncionario() {

        try {
            this.pdoCrud = new pdoCrud();
            return pdoCrud.insert(this.table, this.getColumns(), this.getValues());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //query de clientes
    public JSONArray getAll() {
        String sql = "SELECT * FROM " + table;

        try {

            this.pdoQuery = new pdoQuery();
            ResultSet rs = pdoQuery.fetchAll(sql);
            return jsonConstruct.convertToJson(rs);

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }*/
}
