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
//    List<CatItems> getAll();
//    List<Items>

    // update



    // destroy
}
