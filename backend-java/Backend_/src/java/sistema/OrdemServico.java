/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import sistema.dao.ordemServicoDAO;

/**
 *
 * @author vitor
 */
public class OrdemServico {

    int id;
    private int clienteId;
    private int veiculoId;
    private int formaPagtoId;
    private double valorTotal;
    private int Status;
    private static ordemServicoDAO dao;
    private Date dataPrevista;
    public List<Consumo> consumos;

    public List<Consumo> getConsumos() {
        return consumos;
    }

    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    public OrdemServico(int clienteId, int veiculoId, int formaPagtoId, double valorTotal, int Status, Date dataPrevista) {
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.formaPagtoId = formaPagtoId;
        this.valorTotal = valorTotal;
        this.Status = Status;
        this.dataPrevista = dataPrevista;
    }

    public int getStatus() {
        return Status;
    }

    public OrdemServico() {
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public void setDataPrevista(String dataPrevista) throws ParseException {
        this.dataPrevista = new SimpleDateFormat("yyyy-MM-dd").parse(dataPrevista);
    }

    public String getDataPrevista() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataPrevista);
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public int getFormaPagtoId() {
        return formaPagtoId;
    }

    public void setFormaPagtoId(int formaPagtoId) {
        this.formaPagtoId = formaPagtoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public static JSONArray methods(String method, ordemServicoDAO os, String params) {
        JSONArray jsRet = new JSONArray();
        OrdemServico.dao = os;
        switch (method) {
            case "getAll":
                jsRet = dao.getAll();
                break;
            case "insert":
                jsRet = dao.insert();
                break;
            case "confirmOs":
                jsRet = dao.confirmOs(Integer.parseInt(params));
                break;
            case "getOpen":
                jsRet = dao.getOpen();
                break;
            case "getClosed":
                jsRet = dao.getClosed();
                break;
            case "getByClientId":
                jsRet = dao.getByClientId(Integer.parseInt(params));
                break;
            case "getByCarId":
                jsRet = dao.getByCarId(Integer.parseInt(params));
                break;
        }

        return jsRet;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
