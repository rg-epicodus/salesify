package dao;

import models.CatItems;
import models.DogItems;

import models.Items;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import models.Items;
import java.sql.Connection;

import static org.junit.Assert.assertEquals;

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


    public CatItems getTestCatItems_property() {
        boolean isOnSale = true;
        String name = "Cat Item2";
        double price = 5.00;
        return new CatItems(isOnSale, price, name);
    }


//    public Items getTestItems() throws Exception {
//        String name= "Cat Item2";
//        String address = "Portland";
//        String zipcode = "97204";
//        String phone = "503-000-9870";
//        return new Items(name,address, zipcode, phone);
//    }

    @Test
    public void getTestCatItems() throws Exception {
        CatItems catItems = getTestCatItems_property();
        catItemsDao.add(catItems);
        assertEquals(1,catItems.getId() );
    }

    @Test
    public void deleteCatItemsById_deletesVeryWell() {
        CatItems catItems = setupNewCatItem();
        catItemsDao.add(catItems);
        catItemsDao.deleteCatItemsById(catItems.getId());
        assertEquals(0, catItemsDao.getAll().size());
    }

    // helpers




}