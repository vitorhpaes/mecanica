/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vítor Paes
 *
 * Classe que faz a conexão e retorna o status da mesma com o banco de dados
 *
 */
public class Conn {

    public static String status = "Não conectado";

    /**
     *
     * Método que instancia a classe
     *
     * @return connection
     *
     */
    public Conn() {

    }

    /**
     *
     * Método para testar a conexão sem precisar rodar o sistema completo e ter
     * o retorno no console
     *
     * @return void
     *
     */
    public static void main(String[] args) {

        Conn con = new Conn();
        con.getConexaoMySQL();
        System.out.println(con.status);

    }

    /**
     *
     * Método para conectar com o banco de dados (todos os dados já estão
     * inseridos nestas linhas)
     *
     * @return sql.connection
     *
     */
    public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection

        try {

            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";

            String dbname = "mecanica";

            String url = "jdbc:mysql://" + serverName + "/" + dbname;

            String username = "root";        //nome de um usuário de seu BD

            String password = "";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//
            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

    }

    /**
     *
     * Método que retorna o status da conexão com o banco neste momento
     *
     * @return String
     *
     */
    public static String statusConection() {

        return status;

    }

    /**
     *
     * Método que fecha a conexão
     *
     * @return booelan
     *
     */
    public static boolean FecharConexao() {

        try {

            Conn.getConexaoMySQL().close();

            return true;

        } catch (SQLException e) {

            return false;

        }

    }

    /**
     *
     * Método que renicia a conexão com o banco de dados no sistema
     *
     * @return sql.connection
     *
     */
    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return Conn.getConexaoMySQL();

    }

}
