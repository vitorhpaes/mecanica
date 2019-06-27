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
 * @author vitor
 */
public class pdoQuery {

    public static Conn connection = new Conn();
    public static java.sql.Statement stmt;

    public pdoQuery() {
        try {
            this.stmt = this.connection.getConexaoMySQL().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet fetchAll(String sql) {

        try {
            return this.stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
