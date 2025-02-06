

public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        System.out.println(row);
        return row;

    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        System.out.println(col);
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean equals(Object position){
         Position position1=(Position)position;
        return this.col == position1.col && this.row == position1.row;
    }
}
