/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vítor Paes
 *
 * Classe feita para buscar elementos e retornar os ResultSet das buscas feitas
 * a partir do código genérico criado Objetivo de reutilizar os codigos que são
 * padrões em busca
 *
 * @version 1.0
 *
 */
public class pdoQuery {

    public static Conn connection = new Conn();
    public static java.sql.Statement stmt;

    /**
     *
     * Método construtor sobrecarregado da classe pdoquery Cria já a conexão e o
     * statement para realizar a busca
     *
     */
    public pdoQuery() {
        try {
            this.stmt = this.connection.getConexaoMySQL().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Método para buscar a partir do sql passado pelo sistema
     *
     * @param sql - Sql que será executada no banco de dados para retornar o
     * valor que desejamos
     * @return ResultSet
     */
    public ResultSet fetchAll(String sql) {

        try {
            return this.stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
