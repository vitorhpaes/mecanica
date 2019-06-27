package sistema;

import java.time.LocalDate;
import org.json.JSONArray;
import sistema.dao.clienteDAO;
import sistema.dao.pecaDAO;

public class Peca {

    private int id;
    private String nome;
    private String descricao;
    private double valor;

    private static pecaDAO dao;

    public Peca(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Peca() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static JSONArray methods(String method, pecaDAO p) {
        JSONArray jsRet = new JSONArray();
        Peca.dao = p;
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

}
