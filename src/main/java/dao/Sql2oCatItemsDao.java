package dao;

/**
 * Created by Guest on 8/23/17.
 */
public class Sql2oCatItemsDao implements CatItemsDao {
    private final Sql2o sql2o;

    public Sql2oCatItemsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
