package common.bankarskiSistem.database;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.data.Row;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DatabaseImplementation implements Database {

    private Repository repository;


    @Override
    public DBNode loadResource() {
        return repository.getSchema();
    }

    @Override
    public List<Row> readDataFromTable(String tableName) {
        return repository.get(tableName);
    }

    public List<Row> insertDataForQuery(String query){
        return repository.getQueryWithInsert(query);
    }
}
