package dbConnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;

import javax.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vitor
 */
public class jsonConstruct {

    /**
     * @param os the OutputStream to stream the JSON to
     */
    private static ResultSetMetaData md;

    public static JSONArray convertToJson(ResultSet rs) {

        JSONObject js = new JSONObject();
        JSONArray jArray = new JSONArray();
        List<String> cnames = new ArrayList<>();

        try {

            md = rs.getMetaData();

            for (int i = 1; i <= md.getColumnCount(); i++) {
                cnames.add(md.getColumnName(i));
            }

            while (rs.next()) {

                for (int i = 0; i < cnames.size(); i++) {

                    String key = cnames.get(i);
                    String value = rs.getString(cnames.get(i));
                    js.accumulate(key, value);

                }

                jArray.put(js);
                js = new JSONObject();

            }

            System.out.println(jArray);

        } catch (SQLException ex) {
            System.out.println("erro sqlMethod");
        } catch (JSONException ex) {
            System.out.println("erro jsonMethod");
        }

        return jArray;

    }
}
