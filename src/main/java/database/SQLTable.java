package database;
import console.TableDisplay;
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
    private String[] columnNames;
    private ArrayList<Object[]> rows;

    public SQLTable(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        tableName = metaData.getTableName(1);
        columnIndex = new HashMap<>();
        rows = new ArrayList<>();
        //Fill the column names
        columnNames = new String[columnCount];
        for(int i = 0 ; i < columnCount ; i++){
            columnIndex.put(metaData.getColumnName(i+1), i);
            columnNames[i] = metaData.getColumnName(i+1);
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
        TableDisplay<SQLTable> tableDisplay = new TableDisplay<SQLTable>() {
            SQLTable sqlTable;
            @Override
            public SQLTable getBase() {
                return sqlTable;
            }

            @Override
            public void setBase(SQLTable base) {
                this.sqlTable = base;
            }

            @Override
            public String getValueAt(int row, int column) {
                Object object = sqlTable.rows.get(row)[column];
                return String.valueOf(object);
            }

            @Override
            public int getColumnCount() {
                return sqlTable.getColumnCount();
            }

            @Override
            public int getRowCount() {
                return sqlTable.getRowCount();
            }

            @Override
            public int getColumWidth(int column) {
                return TableDisplay.DEFAULT;
            }

            @Override
            public String getColumnName(int column) {
                return sqlTable.columnNames[column];
            }
        };
        tableDisplay.setBase(this);
        return tableDisplay.toString();
    }

    public Object getValueAt(int row, String column) throws NoSuchColumn, IndexOutOfBoundsException {
        if(row >= getRowCount() || row < 0){
            throw new IndexOutOfBoundsException();
        }
        return getRows().get(row)[getColumIndex(column)];
    }

    public HashMap<String, Object> getRowAsMap(int row) throws IndexOutOfBoundsException{
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

    public Object[] getRow(int row) {
        return rows.get(row);
    }
}