public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.col=col;
        this.row=row;
    }
    public boolean equals(Object position) {
        Object posit = "(" + row + "," + col + ")";
        boolean t = true;
        if (position.equals(posit)) {
            t = true;
        } else {
            t = false;
        }
        return t;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
