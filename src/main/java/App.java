import com.google.gson.Gson;
import dao.Slq2oCatItemsDao;
import dao.Slq2oDogItemsDao;
import dao.Slq2oItemsDao;
import dao.Slq2oSmAnimItemsDao;
import exceptions.ApiException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.after;
import static spark.Spark.exception;

public class App {
    public static void main(String[] args) {
        Slq2oCatItemsDao catItemsDao;
        Slq2oItemsDao itemsDao;
        Slq2oDogItemsDao dogItemsDao;
        Slq2oSmAnimItemsDao smAnimItemsDao;
        Connection conn;
        Gson gson = new Gson();


        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        catItemsDao = new Slq2oCatItemsDao(sql2o);
        itemsDao = new Slq2oItemsDao(sql2o);
        dogItemsDao = new Slq2oDogItemsDao(sql2o);
        smAnimItemsDao = new Slq2oSmAnimItemsDao(sql2o);
        conn = sql2o.open();

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        //FILTERS
        after((req, res) -> {
            res.type("application/json");
        });
    }
}

