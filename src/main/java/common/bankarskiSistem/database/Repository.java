package common.bankarskiSistem.database;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.data.Row;

import java.util.List;

public interface Repository {

    DBNode getSchema();

    List<Row> get(String from);

    List<Row> getQuery(String query);
    public List<Row> getQueryWithInsert(String query);

    void getQueryWithDelete(String query);

    List<Row> getQueryWithUpdate(String query);
}
