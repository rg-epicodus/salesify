package dao;

import org.sql2o.Sql2o;

public class Slq2oItemsDao implements ItemsDao{
    private final Sql2o sql2o;

    public Slq2oItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }



}
