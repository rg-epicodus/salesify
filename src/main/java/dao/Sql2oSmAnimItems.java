package dao;

/**
 * Created by Guest on 8/23/17.
 */
public class Sql2oSmAnimItems implements SmAnimItemsDao{
    private final Sql2o sql2o;

    public Sql2oSmAnimItems(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
}
