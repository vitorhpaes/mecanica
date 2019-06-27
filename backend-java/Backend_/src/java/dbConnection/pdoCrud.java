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
 * @author vitor
 */
public class pdoCrud {

    public static Conn connection = new Conn();
    public static java.sql.Statement stmt;

    public pdoCrud() throws SQLException {
        this.stmt = this.connection.getConexaoMySQL().createStatement();
    }

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
