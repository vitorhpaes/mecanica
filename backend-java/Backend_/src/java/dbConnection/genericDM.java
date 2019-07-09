/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.ResultSet;
import org.json.JSONArray;

/**
 *
 * @author vitor
 * @version inicial 1.0
 *
 * Classe que faz instancia das duas, para que as outras subclasses tenham
 * acesso mais intuitivo com as classes pdoQuery e pdoCrud
 *
 * @see pdoQuery
 * @see pdoCrud
 *
 */
public class genericDM {

    public static pdoQuery query;
    public static pdoCrud crud;

}
