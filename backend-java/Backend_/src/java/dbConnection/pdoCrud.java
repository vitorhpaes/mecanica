/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import dbConnection.Conn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vítor Paes
 *
 * Classe para manipulação de dados no banco de dados, busquei generalizar os
 * inserts, updates e removes Serve para tornar mais rápido o cadastro de
 * objetos no banco, sem precisar criar um SQL para cada um Assim como atualizar
 * e remover a partir de IDs
 *
 */
public class pdoCrud {

    public static Conn connection = new Conn();
    public static java.sql.Statement stmt;

    /**
     * Método de instanciação da conexão com o banco de dados
     *
     * @return pdoCrud, classe final
     * @throws SQLException
     */
    public pdoCrud() throws SQLException {
        this.stmt = this.connection.getConexaoMySQL().createStatement();
    }

    /**
     * Método de insert, insere dados quando se passa as colunas e valores, e
     * então a tabela a partir de um SQL padrão construído
     *
     * @params String table -> tabela em que será feita a inserção
     * @params String cols -> colunas da tabela em que será feita a inserção
     * @params String values -> valores da inserção que será feita no banco
     *
     *
     * @return Long, tipo de dado que vem do Id
     * @throws SQLException
     */
    public Long insert(String table, String cols, String values) throws SQLException {
        Boolean ret = false;
        String sql = "insert into " + table + "(" + cols + ") values (" + values + ")";

        try {

            ret = this.stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = this.stmt.getGeneratedKeys();
            Long id = null;
            if (rs.next()) {
                id = rs.getLong(1);
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            ret = false;
        }

        return null;

    }

    /**
     * Método de update, que será feito a partir do SQL genérico
     *
     * @params String table -> tabela em que será feita o update
     * @params String values -> colunas + valores da atualização
     * @params String conditions -> condição para atualizações que serão
     * realizadas
     *
     *
     * @return Boolean
     */
    public Boolean update(String table, String values, String condition) {
        Boolean ret = false;
        String sql = "update " + table + " set " + values + " " + condition;

        try {

            ret = this.stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    /**
     * Método de delete, que será feito a partir do SQL genérico
     *
     * @params String table -> tabela em que será feita o delete
     * @params String conds -> condições para deletar elementos no banco de
     * dados (WHERE ....)
     *
     * @return Boolean
     */
    public Boolean deleteCondition(String table, String cond) {

        Boolean ret = false;
        String sql = "DELETE FROM " + table + " WHERE " + cond;

        try {

            ret = this.stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            ret = false;
        }

        return ret;

    }

    /**
     * Método de delete, que será feito a partir do SQL genérico a partir do ID
     * de algum item
     *
     * @params String table -> tabela em que será feita o update
     * @params int id -> qual é o Id do objeto a ser excluído
     *
     *
     * @return Boolean
     */
    public Boolean deleteId(String table, int id) {

        Boolean ret = false;
        String sql = "DELETE FROM " + table + " WHERE Id = " + id;

        try {

            ret = this.stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            ret = false;
        }

        return ret;

    }

}
