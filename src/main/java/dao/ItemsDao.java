package dao;

import models.Items;

import java.util.List;

/**
 * Created by Guest on 8/23/17.
 */
public interface ItemsDao {

    // create
        void add(Items items);

    // read
     List<Items> getAll();

        Items findById(int id);
    //  .getPrice();
    //  .getSalesStatus();
    //  .getTimeSold();

    // update
    void update(int id, String name, String address, String zipcode, String phone);
    // destroy
    //  deleteAllItems
      void deleteItemsById(int id);
}

//Items
//        str name
//        str description
//        double price
//        int id
//        localdatetime createdat
//        boolean onsale
//
//        u
//        update
//        d
//        delete all items
//        delete item by id



