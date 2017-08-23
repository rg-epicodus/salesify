package dao;


import org.sql2o.Sql2o;

public class Slq2oCatItemsDao implements CatItemsDao {
    private final Sql2o sql2o;

    public Slq2oCatItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
