import dao.Sql2oCatItemsDao;
import dao.Sql2oDogItemsDao;
import dao.Sql2oItemsDao;
import dao.Sql2oSmAnimItems;

import java.sql.Connection;

/**
 * Created by Guest on 8/23/17.
 */
public class App {
    public static void main(String[] args) {
        Sql2oCatItemsDao catItemsDao;
        Sql2oItemsDao itemsDao;
        Sql2oDogItemsDao dogItemsDao;
        Sql2oSmAnimItems smAnimItemsDao;
        Connection conn;
        Gson gson = new Gson();
    }
}
