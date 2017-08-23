package dao;
import models.CatItems;
import models.DogItems;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Slq2oDogItemsDao implements DogItemsDao {
    private final Sql2o sql2o;


    public Slq2oDogItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
