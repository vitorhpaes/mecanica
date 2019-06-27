package sistema;

import dbConnection.pdoCrud;
import dbConnection.pdoQuery;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
//import javax.ws.rs.client.Client;
import dbConnection.jsonConstruct;
import org.json.JSONArray;
import sistema.dao.clienteDAO;

public class Cliente extends Pessoa {

    private Veiculo veiculo;
    private static clienteDAO dao;

    public Cliente(String nome, String cpf, String email, String cep, String numero, String telefone) {
        super(nome, cpf, email, cep, numero, telefone);
    }

    public Cliente() {
    }

    public static JSONArray methods(String method, clienteDAO c) {
        JSONArray jsRet = new JSONArray();
        Cliente.dao = c;
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

    @Override
    public String toString() {
        return "Nome:" + getNome() + ", CPF: " + getCpf() + ", CEP: " + getCep() + ", Email: " + getEmail() + ", Telefone: " + getTelefone();
    }

}
