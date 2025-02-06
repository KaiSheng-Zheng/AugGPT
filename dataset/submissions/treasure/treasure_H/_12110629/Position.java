public class Position {
    private int row;
    private int col;


    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object pos){
        Position pos1 = (Position) pos;
        if(pos1.col==this.col && pos1.row==this.col) {
            return true;
        }
        return  false;
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