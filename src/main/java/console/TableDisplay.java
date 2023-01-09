package console;

public abstract class TableDisplay<T> {
    public abstract T getBase();
    public abstract void setBase(T base);
    public abstract String getValueAt(int row, int column);
    public abstract int getColumnCount();
    public abstract int getRowCount();
    public abstract String getColumnName(int column);
    public String ellipsis(String string) {
        if(string.length() >= 30) {
            return string.substring(0,25) + "...";
        }
        return string;
    }

    @Override
    public String toString() {
        if(getRowCount() == 0){
            return "Empty";
        }

        String format = "┃ %-30s";
        String output = "";
        String separador = "╋";

        for(int i = 0 ; i < getColumnCount() ; i++){
            separador +=   "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━╋";
            //separador += "-------------------------------+";
        }
        output += separador +"\n";
        /*
        for(String name : columnIndex.keySet()){
            output += String.format(format, ellipsis(name));
        }*/

        for(int i = 0; i < getColumnCount(); i++){
            output += String.format(format, ellipsis(getColumnName(i)));
        }
        output += "┃\n"+separador+"\n";

        for(int i = 0; i < getRowCount(); i++){
            for(int j = 0; j < getColumnCount(); j ++) {
                output += String.format(format, getValueAt(i, j));
            }
            output += "┃\n";
        }
        /*
        for(Object[] row : rows){
            for(String key : columnIndex.keySet()){
                output += String.format(format, ellipsis( String.valueOf(row[columnIndex.get(key)])));
            }
            output += "┃\n";
        }*/
        output += separador;

        return output;
    }
}
