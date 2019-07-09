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

    /**
     * Método para setar lista de consumos ao objeto atual
     *
     */
    public void setConsumos(List<Consumo> consumos) {
        this.consumos = consumos;
    }

    /**
     * Método para construção do objeto OrdemServico
     *
     * @return Double - Valor do Salário
     */
    public OrdemServico(int clienteId, int veiculoId, int formaPagtoId, double valorTotal, int Status, Date dataPrevista) {
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
        this.formaPagtoId = formaPagtoId;
        this.valorTotal = valorTotal;
        this.Status = Status;
        this.dataPrevista = dataPrevista;
    }

    /**
     * Método para buscar o status da ordem de serviço (ver se está entregue ou
     * pendente)
     *
     * @return int (0, 1 ou 2)
     */
    public int getStatus() {
        return Status;
    }

    /**
     * Construtor para objeto sobrecarregado
     */
    public OrdemServico() {
    }

    /**
     * Método para setar o valor do status da ordem (se está entregue ou
     * pendente)
     *
     * @return void, @set(0, 1 ou 2)
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * Método para setar a data prevista de entrega da ordem
     *
     * @return void
     */
    public void setDataPrevista(String dataPrevista) throws ParseException {
        this.dataPrevista = new SimpleDateFormat("yyyy-MM-dd").parse(dataPrevista);
    }

    /**
     * Método para buscar a data que está prevista para a ordem de serviço ser
     * entregue
     *
     * @return String em forma de data
     */
    public String getDataPrevista() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataPrevista);
    }

    /**
     * Método para buscar o id do veículo que a ordem serviço está sendo
     * prestado
     *
     * @return String em forma de data
     */
    public int getVeiculoId() {
        return veiculoId;
    }

    /**
     * Método para setar o ID do veiculo que se trata, do banco de dados
     *
     * @return void
     */
    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    /**
     * Método para buscar forma de pagamento que a OS será feita
     *
     * @return String em forma de data
     */
    public int getFormaPagtoId() {
        return formaPagtoId;
    }

    /**
     * Método para setar a forma de pagamento
     *
     * @return void
     */
    public void setFormaPagtoId(int formaPagtoId) {
        this.formaPagtoId = formaPagtoId;
    }

    /**
     * Método para buscar o id do cliente vinculado à os.
     *
     * @return String em forma de data
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Método para setar o cliente da ordem de serviço
     *
     * @return void
     */
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

    /**
     * Método para setar o valor total da ordem de serviço (soma de todos os
     * itens que tem nela)
     *
     * @return void
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Método para buscar o valor total da ordem de serviço instanciada
     *
     * @return String em forma de data
     */
    public double getValorTotal() {
        return valorTotal;
    }

}
