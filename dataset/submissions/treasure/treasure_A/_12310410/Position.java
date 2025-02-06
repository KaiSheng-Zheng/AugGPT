public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public Position() {
    }

    public boolean equals(Object position){
        Position position1=(Position)position;
        return ((position1.getRow()==row) && (position1.getCol()==col));
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

    public String toString() {
        return "Position{row = " + row + ", col = " + col + "}";
    }
}