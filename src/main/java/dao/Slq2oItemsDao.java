package dao;

import models.Items;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Slq2oItemsDao implements ItemsDao{
    private final Sql2o sql2o;

    public Slq2oItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Items items) {
        String sql = "INSERT INTO items (name,address,zipcode,phone) VALUES (:name,:address,:zipcode,:phone)"; //raw sql
        try (Connection con = sql2o.open()) { //try to open a connection
            int id = (int) con.createQuery(sql) //make a new variable
                    .addParameter("name", items.getName())
                    .addParameter("address", items.getAddress())
                    .addParameter("zipcode", items.getZipcode())
                    .addParameter("phone", items.getPhone())

                    .addColumnMapping("NAME", "name")
                    .addColumnMapping("ADDRESS", "address")
                    .addColumnMapping("ZIPCODE", "zipcode")
                    .addColumnMapping("PHONE", "phone")
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            items.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Items findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM items WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Items.class);
        }
    }

    @Override
    public List<Items> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM items") //raw sql
                    .executeAndFetch(Items.class); //fetch a list
        }
    }
    @Override
    public void update(int id, String newName, String newAddress, String newZipcode, String newPhone) {
        String sql = "UPDATE items SET (name,address,zipcode,phone)=(:name,:address,:zipcode,:phone) WHERE id=:id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("address", newAddress)
                    .addParameter("zipcode", newZipcode)
                    .addParameter("phone", newPhone)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteItemsById(int id) {
        String sql = "DELETE from items WHERE id=:id";
        String deleteJoin = "DELETE from items_catitems WHERE itemsId = :itemsId";
//        String deleteJoin = "DELETE from items_dogitems WHERE itemsId = :itemsId";
//        String deleteJoin = "DELETE from items_smanimitems WHERE itemsId = :itemsId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("itemsId",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}
