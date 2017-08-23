package dao;

import org.sql2o.Sql2o;

/**
 * Created by Guest on 8/23/17.
 */
public class Slq2oSmAnimItemsDao implements SmAnimItemsDao{
    private final Sql2o sql2o;

    public Slq2oSmAnimItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
