package sistema;

import org.json.JSONArray;
import sistema.dao.consumoDAO;

public class Consumo {

    private int id;
    private int servico;
    private int OSId;
    private float valor;

    private static consumoDAO dao;

    public Consumo(int servico, int OSId, float valor) {
        this.servico = servico;
        this.OSId = OSId;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Consumo() {
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public int getOSId() {
        return OSId;
    }

    public void setOSId(int OSId) {
        this.OSId = OSId;
    }

    public static JSONArray methods(String method, Consumo cs) {
        JSONArray jsRet = new JSONArray();
        Consumo.dao = new consumoDAO();
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
