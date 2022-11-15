package common.bankarskiSistem.database;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.data.Row;

import java.util.List;

public interface Database{

    DBNode loadResource();

    List<Row> readDataFromTable(String tableName);

    List<Row> readDataFromQuery(String query);

    public List<Row> insertDataForQuery(String query);
    public List<Row> updateDataForQuery(String query);
    public void deleteDataForQuery(String query);

}
