package dao;


import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oDogItemsDao implements DogItemsDao {
    private final Sql2o sql2o;


    public Sql2oDogItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
