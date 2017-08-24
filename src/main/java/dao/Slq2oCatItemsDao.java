package dao;


import models.CatItems;
import models.Items;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Slq2oCatItemsDao implements CatItemsDao {
    private final Sql2o sql2o;

    public Slq2oCatItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(CatItems catItems) {
        String sql = "INSERT INTO items (name, price, isOnSale) VALUES (:name,:price,:isOnSale)";

        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", catItems.getName())
                    .addParameter("price", catItems.getAddress())
                    .addParameter("isOnSale", catItems.getZipcode())
                    .bind(catItems)
                    .executeUpdate() //run it all
                    .getKey(); //int id is now the row number (row “key”) of db
            catItems.setId(id); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }


    }

    @Override
    public void addCatItemsToItems(CatItems catItems, Items items) {

    }

    @Override
    public List<CatItems> getAll(){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM catitems")
                    .executeAndFetch(CatItems.class);
        }
    }

    @Override
    public void deleteCatItemsById(int id) {
        String sql = "DELETE from catItems WHERE id=:id"; //raw sql
        String deleteJoin = "DELETE from items_catitems WHERE catitemsid=:catitemsid"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("catitemsid", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
