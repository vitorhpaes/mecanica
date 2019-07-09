/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import sistema.Consumo;
import sistema.OrdemServico;
import sistema.dao.clienteDAO;
import sistema.dao.formaPagamentoDAO;
import sistema.dao.funcionarioDAO;
import sistema.dao.ordemServicoDAO;
import sistema.dao.pecaDAO;
import sistema.dao.servicoDAO;
import sistema.dao.veiculoDAO;

/**
 * Classe para construir objetos necessários a partir dos parametros vindo do
 * request
 *
 * @author Vitor Paes
 * @version 1.0
 * @since 06/2019
 */
public class postMaping {

    Map<String, String[]> map;

    /**
     * Métodos para mapeamento e construção de objetos
     *
     * @author Vítor Paes
     * @param Maps(geral) mapas passados pelos requests para construção dos
     * objetos
     */
    public postMaping(Map<String, String[]> map) {
        this.map = map;
    }

    /**
     * Método para construção do objeto forma de pagamento
     *
     * @return formaPagamentoDAO
     */
    public formaPagamentoDAO fpagtoConstruct() {
        formaPagamentoDAO fp = new formaPagamentoDAO();

        fp.setTipo(map.get("tipo")[0]);
        fp.setVezes(Integer.parseInt(map.get("vezes")[0]));

        return fp;
    }

    /**
     * Método para construção do objeto funcionario
     *
     * @return funcionarioDAO
     */
    public funcionarioDAO funcConstruct() {
        funcionarioDAO fdao = new funcionarioDAO();

        fdao.setNome(map.get("nome")[0]);
        fdao.setSalario(Double.parseDouble(map.get("salario")[0]));
        fdao.setSetor(map.get("setor")[0]);
        fdao.setDataAdmissao(map.get("dataAdmissao")[0]);

        return fdao;
    }

    /**
     * Método para construção do objeto servicoDAO
     *
     * @return servicoDAO
     */
    public servicoDAO serviceConstruct() {
        servicoDAO sdao = new servicoDAO();

        sdao.setNome(map.get("nome")[0]);
        sdao.setDescricao(map.get("descricao")[0]);
        sdao.setHoras(Integer.parseInt(map.get("horas")[0]));
        sdao.setPecaId(Integer.parseInt(map.get("pecaId")[0]));
        sdao.setValor(Float.parseFloat(map.get("valor")[0]));

        return sdao;
    }

    /**
     * Método para construção do objeto pecaDAO
     *
     * @return pecaDAO
     */
    public pecaDAO pieceConstruct() {
        pecaDAO pdao = new pecaDAO();

        pdao.setNome(map.get("nome")[0]);
        pdao.setDescricao(map.get("descricao")[0]);
        pdao.setValor(Double.parseDouble(map.get("valor")[0]));

        return pdao;
    }

    /**
     * Método para construção do objeto clienteDAO
     *
     * @return clienteDAO
     */
    public clienteDAO clientConstruct() {

        clienteDAO cdao = new clienteDAO();
        cdao.setNome(map.get("nome")[0]);
        cdao.setEmail(map.get("email")[0]);
        cdao.setCpf(map.get("cpf")[0]);
        cdao.setCep(map.get("cep")[0]);
        cdao.setNumero(map.get("numero")[0]);
        cdao.setTelefone(map.get("telefone")[0]);

        return cdao;
    }

    /**
     * Método para construção do objeto veiculoDAO
     *
     * @return veiculoDAO
     */
    public veiculoDAO veiculoConstruct() {
        veiculoDAO v = new veiculoDAO();

        v.setClienteId(Integer.parseInt(map.get("clienteId")[0]));
        v.setModelo(map.get("modelo")[0]);
        v.setMarca(map.get("marca")[0]);
        v.setPlaca(map.get("placa")[0]);

        return v;
    }

    /**
     * Método para construção do objeto ordemServicoDAO
     *
     * @return ordemServicoDAO
     */
    public ordemServicoDAO osConstruct() throws ParseException {

        ordemServicoDAO os = new ordemServicoDAO();
        os.setClienteId(Integer.parseInt(map.get("ClienteId")[0]));
        os.setVeiculoId(Integer.parseInt(map.get("VeiculoId")[0]));
        os.setFormaPagtoId(Integer.parseInt(map.get("formapagtoId")[0]));
        os.setDataPrevista(map.get("DataPrevista")[0]);
        os.setStatus(0);
        os.setValorTotal(Double.parseDouble(map.get("ValorTotal")[0]));
        os.setConsumos(getConsumos());

        return os;
    }

    /**
     * Método para construção da lista de consumos da ordem de serviço a ser
     * cadastrada
     *
     * @return List<Consumo>
     */
    private List<Consumo> getConsumos() {
        List<Consumo> list = new ArrayList<Consumo>();

        String[] consumos = map.get("consumo");
        String[] valores = map.get("valor");

        for (int i = 0; i < consumos.length; i++) {

            Consumo c = new Consumo(Integer.parseInt(consumos[i]), 0, Float.parseFloat(valores[i]));
            list.add(c);

        }

        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }

    }

}
