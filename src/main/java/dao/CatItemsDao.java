package dao;

import models.CatItems;
import models.Items;

import java.util.List;

/**
 * Created by Guest on 8/23/17.
 */
public interface CatItemsDao {

    // create
    void add(CatItems catItems); // N
    void addCatItemsToItems(CatItems catItems, Items items);

    // read
    //  .getAllCatItems();
        List<CatItems> getAll();
//    List<Items>

    // update



    // destroy
    void deleteCatItemsById(int id);

}

//catitems
//        string cattype
//
//        dao
//        c
//        add (catitems catitems)
//        r
//        list<catitems> getall
//        Items findcatitembyid(int id)
//        u
//        updatecatitem
//        d
//        delete all catitems
//        delete catitem by id