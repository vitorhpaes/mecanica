package webApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dbConnection.postMaping;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import sistema.Cliente;
import sistema.FormaPagamento;
import sistema.Funcionario;
import sistema.OrdemServico;
import sistema.Peca;
import sistema.Servico;
import sistema.Veiculo;
import sistema.dao.clienteDAO;
import sistema.dao.formaPagamentoDAO;
import sistema.dao.funcionarioDAO;
import sistema.dao.ordemServicoDAO;
import sistema.dao.pecaDAO;
import sistema.dao.servicoDAO;
import sistema.dao.veiculoDAO;

/**
 * Classe para requests e responses na aplicação desenvolvida orientada a
 * objetos BACKEND Solicita os dados ou inseração e é retornado o que foi
 * operado.
 *
 * @author Vitor Paes
 * @version 1.0
 * @since Começo da aplicação, 05/2019
 */
@WebServlet(urlPatterns = {"/webApp"})
public class webApp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Método para realizar os posts requeridos pelo frontend em jquery
     *
     *
     * @return JSON - através do parametro response.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            PrintWriter out = response.getWriter();
            setCors(response);
            response.setContentType("text/html;");
            response.setCharacterEncoding("iso-8859-1");

            try {
                out.print(redirectRoutePOST(request.getParameterMap()));
            } catch (Exception e) {
                out.print("erro");
            }

        } catch (NumberFormatException ex) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

    /**
     * Método para realizar os gets requeridos pelo frontend em jquery
     *
     *
     * @return JSON - através do parametro response.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String type = request.getParameter("type");
            String method = request.getParameter("method");
            String params = request.getParameter("params");
            setCors(response);
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;");
            response.setCharacterEncoding("iso-8859-1");

            try {
                out.print(redirectRouteGET(type, method, params));
            } catch (Exception e) {
                out.print("erro");
            }

        } catch (NumberFormatException ex) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }

    }

    /**
     * Método para redirecionar a rota passada pelo doGet
     *
     * @return JSONArray - json com o que foi buscado no banco de dados.
     */
    private JSONArray redirectRouteGET(String type, String method, String params) {

        JSONArray ret = null;

        switch (type) {
            case "cliente":
                clienteDAO cdao = new clienteDAO();
                ret = Cliente.methods(method, cdao);
                break;
            case "servico":
                servicoDAO sdao = new servicoDAO();
                ret = Servico.methods(method, sdao);
                break;
            case "fpagto":
                formaPagamentoDAO fpgto = new formaPagamentoDAO();
                ret = FormaPagamento.methods(method, fpgto);
                break;
            case "OS":
                ordemServicoDAO os = new ordemServicoDAO();
                ret = OrdemServico.methods(method, os, params);
                break;
            case "funcionario":
                funcionarioDAO f = new funcionarioDAO();
                ret = Funcionario.methods(method, f);
                break;
            case "veiculo":
                veiculoDAO v = new veiculoDAO();
                ret = Veiculo.methods(method, v, params);
                break;
            case "pecas":
                pecaDAO pdao = new pecaDAO();
                ret = Peca.methods(method, pdao);
                break;
            case "tal":
                //class tal(method)
                break;
        }

        return ret;

    }

    /**
     * Método para redirecionar a rota passada pelo doPost
     *
     * @return JSONArray - json com o que foi buscado/inserido no banco de
     * dados.
     */
    private JSONArray redirectRoutePOST(Map<String, String[]> map) throws ParseException {

        postMaping pm = new postMaping(map);
        String type = map.get("type")[0];
        String method = map.get("method")[0];
        String params = "false";
        if (map.containsKey("params")) {
            params = map.get("params")[0];
        }

        JSONArray ret = null;
        //POST
        switch (type) {
            case "cliente":
                clienteDAO cdao = pm.clientConstruct();
                ret = Cliente.methods(method, cdao);
                break;
            case "servico":
                servicoDAO sdao = pm.serviceConstruct();
                ret = Servico.methods(method, sdao);
                break;
            case "veiculo":
                veiculoDAO v = pm.veiculoConstruct();
                ret = Veiculo.methods(method, v, params);
                break;
            case "os":
                ordemServicoDAO os = pm.osConstruct();
                ret = OrdemServico.methods(method, os, params);
                break;
            case "funcionario":
                funcionarioDAO f = pm.funcConstruct();
                ret = Funcionario.methods(method, f);
                break;
            case "pecas":
                pecaDAO pdao = pm.pieceConstruct();
                ret = Peca.methods(method, pdao);
                break;
            case "fpagto":
                formaPagamentoDAO fpdao = pm.fpagtoConstruct();
                ret = FormaPagamento.methods(method, fpdao);
                break;
        }
        //POST

        return ret;

    }

    /**
     * Método setar os cabeçalhos para que a aplicação seja acessível pelo
     * frontEnd
     *
     * @return void - apenas para setar os cabeçalhos do response, que é
     * retornado depois.
     */
    private void setCors(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Authorization");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
