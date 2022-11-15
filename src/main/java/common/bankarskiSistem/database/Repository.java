package common.bankarskiSistem.database;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.data.Row;

import java.util.List;

public interface Repository {

    DBNode getSchema();

    List<Row> get(String from);
    public List<Row> getQueryWithInsert(String query);

    public List<Row> getQueryWithUpdate(String query);
}
