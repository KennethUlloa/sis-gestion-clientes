package database;
import database.exceptions.NoSuchColumn;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SQLTable {
    //as
    private HashMap<String, Integer> columnIndex;
    private String tableName;
    private ArrayList<Object[]> rows;

    public SQLTable(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        columnIndex = new HashMap<>();
        rows = new ArrayList<>();
        //Fill the column names

        for(int i = 0 ; i < columnCount ; i++){
            columnIndex.put(metaData.getColumnName(i+1), i);
        }

        //Fill the rows with the data
        while(resultSet.next()){
            Object[] row = new Object[columnCount];
            for(int i = 0 ; i < columnCount ; i++){
                row[i] = resultSet.getObject(i+1);
            }
            rows.add(row);
        }
    }

    public HashMap<String, Integer> getColumnIndexMap() {
        return columnIndex;
    }

    public String[] getColumnNames() {
        return columnIndex.keySet().toArray(new String[0]);
    }

    public String getTableName() {
        return tableName;
    }

    public int getColumIndex(String column) throws NoSuchColumn {
        if (columnIndex.containsKey(column)) return columnIndex.get(column);
        throw new NoSuchColumn(tableName + " doesn't have " + column + " as a column");
    }

    public int getColumnCount() {
        return columnIndex.size();
    }

    public int getRowCount() {
        return rows.size();
    }

    public ArrayList<Object[]> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        if(rows.size() == 0){
            return "No rows selected";
        }

        String format = "| %-30s";
        String output = "";
        String separador = "+";

        for(int i = 0 ; i < getColumnCount() ; i++){
            separador += "-------------------------------+";
        }
        output += separador +"\n";
        for(String name : columnIndex.keySet()){
            output += String.format(format, name);
        }
        output += "|\n"+separador+"\n";

        for(Object[] row : rows){
            for(String key : columnIndex.keySet()){
                output += String.format(format, row[columnIndex.get(key)]);
            }
            output += "|\n";
        }
        output += separador;

        return output;
    }

    public Object getValueAt(int row, String column) throws NoSuchColumn, IndexOutOfBoundsException {
        if(row >= getRowCount() || row < 0){
            throw new IndexOutOfBoundsException();
        }
        return getRows().get(row)[getColumIndex(column)];
    }

    public HashMap<String, Object> getRow(int row) throws IndexOutOfBoundsException{
        if(row >= getRowCount() || row < 0){
            throw new IndexOutOfBoundsException();
        }
        HashMap<String, Object> map = new HashMap<>();
        int index = 0;
        for(String key: columnIndex.keySet()){
            index = columnIndex.get(key);
            map.put(key, rows.get(row)[index]);
        }

        return map;
    }
}