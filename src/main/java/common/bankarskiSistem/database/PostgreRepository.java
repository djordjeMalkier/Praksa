package common.bankarskiSistem.database;

import common.bankarskiSistem.database.settings.Settings;
import common.bankarskiSistem.resources.data.Row;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostgreRepository implements Repository{

    private Settings settings;
    private Connection connection;

    public PostgreRepository(Settings settings) {
        this.settings = settings;
    }

    private void initConnection() throws SQLException, ClassNotFoundException{
        String ip = (String) settings.getParameter("ip");
        String database = (String) settings.getParameter("database");
        String username = (String) settings.getParameter("username");
        String password = (String) settings.getParameter("password");
        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://" + ip+"/" + database,username,password);
        //jdbc:postgresql://localhost:5432/banka/password
    }

    private void closeConnection(){
        try{
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            connection = null;
        }
    }

    @Override
    public List<Row> get(String from) {

        List<Row> rows = new ArrayList<>();


        try{
            this.initConnection();

            String query = "SELECT * FROM "  + from;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            while (rs.next()){

                Row row = new Row();
                row.setName(from);

                for (int i = 1; i<=resultSetMetaData.getColumnCount(); i++){
                    row.addField(resultSetMetaData.getColumnName(i), rs.getString(i));
                }
                rows.add(row);


            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return rows;
    }

    public List<Row> getQuery(String query) {

        List<Row> rows = new ArrayList<>();


        try{
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            while (rs.next()){

                Row row = new Row();
                row.setName("Table");

                for (int i = 1; i<=resultSetMetaData.getColumnCount(); i++){
                    row.addField(resultSetMetaData.getColumnName(i), rs.getString(i));
                }
                rows.add(row);


            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        return rows;
    }

    public List<Row> getQueryWithInsert(String query) {

        try{
            this.initConnection();

            Statement preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

        String table = null;

        String[] splitted = query.split("\\s+");
        for (int i = 0; i< splitted.length; i++){
            if (splitted[i].equalsIgnoreCase("INTO")) {
                table = splitted[i+1];
                System.out.println(table);
                break;
            }
        }

        return get(table);
    }

    @Override
    public void getQueryWithDelete(String query) {
        try{
            this.initConnection();

            Statement preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }
    }

    @Override
    public List<Row> getQueryWithUpdate(String query) {
        try{
            this.initConnection();

            Statement preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.closeConnection();
        }

       String table = null;

        String[] splitted = query.split("\\s+");
        for (int i = 0; i< splitted.length; i++){
            if (splitted[i].equalsIgnoreCase("SET")) {
                table = splitted[i+1];
                System.out.println(table);
                break;
            }
        }

        return get(table);

    }
}
