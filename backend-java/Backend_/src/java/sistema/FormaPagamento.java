package sistema;

import org.json.JSONArray;
import sistema.dao.formaPagamentoDAO;

public class FormaPagamento {

    private int id;
    private String tipo;
    private int vezes;
    public static formaPagamentoDAO dao;

    public FormaPagamento(String tipo, int vezes) {
        this.tipo = tipo;
        this.vezes = vezes;
    }

    public FormaPagamento() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVezes() {
        return vezes;
    }

    public void setVezes(int vezes) {
        this.vezes = vezes;
    }

    public static JSONArray methods(String method, formaPagamentoDAO fp) {
        JSONArray jsRet = new JSONArray();
        FormaPagamento.dao = fp;
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
