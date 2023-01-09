package console;

public abstract class TableDisplay<T> {
    private String middle = "╋";
    private final String leftTop = "┏";
    private String rightTop = "┓";
    private String middleTop = "┳";
    private String leftSide = "┣";
    private String rightSide = "┫";
    private String leftBottom = "┗";
    private String rightBottom = "┛";
    private String middleBottom = "┻";

    public static final int LITTLE = 1;
    public static final int MIDDLE = 2;
    public static final int DEFAULT = -1;

    public abstract T getBase();
    public abstract void setBase(T base);
    public abstract String getValueAt(int row, int column);
    public abstract int getColumnCount();
    public abstract int getRowCount();
    public abstract int getColumWidth(int column);
    public abstract String getColumnName(int column);
    public String ellipsis(String string, int column) {
        int length = getLengthForColumn(column);
        if(string.length() >= length) {
            return string.substring(0, length - 5) + "...";
        }
        return string;
    }

    private String getFormatForColumn(int column) {
        switch (getColumWidth(column)) {
            case LITTLE: return "┃ %-15s";
            case MIDDLE: return "┃ %-20s";
            default: return "┃ %-30s";
        }
    }

    private String getLineForColumn(int column) {
        switch (getColumWidth(column)) {
            case LITTLE: return "━━━━━━━━━━━━━━━━";
            case MIDDLE: return "━━━━━━━━━━━━━━━━━━━━━";
            default: return "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
        }
    }

    private int getLengthForColumn(int column) {
        switch (getColumWidth(column)) {
            case LITTLE: return 15;
            case MIDDLE: return 20;
            default: return 30;
        }
    }

    @Override
    public String toString() {
        if(getRowCount() == 0){
            return "Empty";
        }

        String format = "┃ %-30s";
        //String output = "";
        StringBuilder topLine = new StringBuilder(leftTop);
        StringBuilder middleLine = new StringBuilder(leftSide);
        StringBuilder bottomLine = new StringBuilder(leftBottom);
        StringBuilder output = new StringBuilder();
        for(int i = 0 ; i < getColumnCount() ; i++){
            topLine.append(getLineForColumn(i));
            middleLine.append(getLineForColumn(i));
            bottomLine.append(getLineForColumn(i));
            if(i == getColumnCount() - 1){
                topLine.append(rightTop);
                middleLine.append(rightSide);
                bottomLine.append(rightBottom);
            }else{
                topLine.append(middleTop);
                middleLine.append(middle);
                bottomLine.append(middleBottom);
            }
        }
        output.append(topLine).append('\n');

        //Top line
        for(int i = 0; i < getColumnCount(); i++){
            output.append(String.format(getFormatForColumn(i), ellipsis(getColumnName(i), i)));
        }
        output.append("┃\n").append(middleLine).append('\n');

        for(int i = 0; i < getRowCount(); i++){
            for(int j = 0; j < getColumnCount(); j ++) {
                output.append(String.format(getFormatForColumn(j), ellipsis(getValueAt(i, j), j)));
            }
            output.append("┃\n");
        }
        output.append(bottomLine);
        return output.toString();
    }
}
