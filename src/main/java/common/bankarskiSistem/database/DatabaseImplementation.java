package common.bankarskiSistem.database;

import common.bankarskiSistem.resources.data.Row;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DatabaseImplementation implements Database {

    private Repository repository;


    @Override
    public List<Row> readDataFromTable(String tableName) {
        return repository.get(tableName);
    }

    public List<Row> readDataFromQuery(String query) {
        return repository.getQuery(query);
    }

    public List<Row> insertDataForQuery(String query){
        return repository.getQueryWithInsert(query);
    }

    @Override
    public List<Row> updateDataForQuery(String query) {
        return repository.getQueryWithUpdate(query);
    }

    @Override
    public void deleteDataForQuery(String query) {
         repository.getQueryWithDelete(query);
    }
}
