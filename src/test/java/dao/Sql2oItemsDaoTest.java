package dao;

import models.Items;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.net.ConnectException;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/23/17.
 */
public class Sql2oItemsDaoTest {

    private Slq2oItemsDao itemsDao;
    private Slq2oDogItemsDao dogItemsDao;
    private Slq2oCatItemsDao catItemsDao;
    private Slq2oSmAnimItemsDao smAnimItemsDao;
    private org.sql2o.Connection conn;


    public Items getTestItems(){
         String name = "leash";
         String address = "Beaverton";
         String zipcode = "97006";
         String phone = "897-098-9090";

        return new Items(name, address, zipcode, phone);

    }

    public Items getTestItemsTwo(){
        String name = "leashTwo";
        String address = "Hillsboro";
        String zipcode = "97245";
        String phone = "894-098-9090";

        return new Items(name, address, zipcode, phone);

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

    @Test
    public void addingItemsSetId() throws Exception {
        Items items = getTestItems();
        itemsDao.add(items);
    }

    @Test
    public void findById() throws Exception {
        Items items = getTestItems();
        itemsDao.add(items);
        Items foundItems = itemsDao.findById(items.getId());
        assertEquals(items, foundItems);

    }

    @Test
    public void getAll_allItemsAreFound() throws Exception {
        Items items = getTestItems();
        Items anotherItems = getTestItemsTwo();
        itemsDao.add(items);
        itemsDao.add(anotherItems);
        int number = itemsDao.getAll().size();
        assertEquals(2, number);
    }

    @Test
    public void update_correctlyUpdates() {
        Items items = getTestItems();
        itemsDao.add(items);
        itemsDao.update(items.getId(), "newName", "newAddress", "newZipcode", "newPhone");
        Items updatedItems = itemsDao.findById(items.getId());
        assertEquals("newZipcode", updatedItems.getZipcode());
        assertEquals("newName", updatedItems.getName());
        assertEquals("newAddress", updatedItems.getAddress());
        assertEquals("newPhone", updatedItems.getPhone());
    }

    @Test
    public void deleteItemsById_deletesVeryWell() {
        Items item = getTestItems();
        itemsDao.add(item);
        itemsDao.deleteItemsById(item.getId());
        assertEquals(0,itemsDao.getAll().size());
    }



    // helpers

}