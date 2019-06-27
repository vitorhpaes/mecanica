package sistema;

import org.json.JSONArray;
import sistema.dao.servicoDAO;

public class Servico {

    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private int horas;
    private int pecaId;

    private static servicoDAO dao;

    public Servico() {

    }

    public Servico(String nome, String descricao, double valor, int horas, int pecaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.horas = horas;
        this.pecaId = pecaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getPecaId() {
        return pecaId;
    }

    public void setPecaId(int pecaId) {
        this.pecaId = pecaId;
    }

    public static JSONArray methods(String method, servicoDAO s) {
        JSONArray jsRet = new JSONArray();
        Servico.dao = s;
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
