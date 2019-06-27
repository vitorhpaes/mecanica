package sistema;

import org.json.JSONArray;
import sistema.dao.funcionarioDAO;
import sistema.dao.veiculoDAO;

public class Veiculo {

    private int Id;
    private String modelo;
    private String marca;
    private String placa;
    private int clienteId;

    public Veiculo(String modelo, String marca, int clienteId, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.clienteId = clienteId;
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    private static veiculoDAO dao;

    public Veiculo() {
    }

    public static JSONArray methods(String method, veiculoDAO v, String params) {
        JSONArray jsRet = new JSONArray();
        Veiculo.dao = v;
        switch (method) {
            case "getAll":
                jsRet = dao.getAll();
                break;
            case "getByClientId":
                jsRet = dao.getByClientId(Integer.parseInt(params));
                break;
            case "insert":
                jsRet = dao.insert();
                break;
        }

        return jsRet;
    }

}
