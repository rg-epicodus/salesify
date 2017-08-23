package dao;

import models.CatItems;
import models.DogItems;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Sql2o;

import java.sql.Connection;

/**
 * Created by Guest on 8/23/17.
 */
public class Sql2oCatItemsDaoTest {

    private Slq2oItemsDao itemsDao;
    private Slq2oDogItemsDao dogItemsDao;
    private Slq2oCatItemsDao catItemsDao;
    private Slq2oSmAnimItemsDao smAnimItemsDao;
    private org.sql2o.Connection conn;

    public CatItems setupNewCatItem() {
        return new CatItems(true, 5.00,"catnip");
    }

    public CatItems setupNewCatItemTwo() {
        return new CatItems(false, 6.00,"shock collar");
    }


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        itemsDao = new Slq2oItemsDao(sql2o);
        catItemsDao = new Slq2oCatItemsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    // helpers




}