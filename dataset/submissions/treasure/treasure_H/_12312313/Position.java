public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        this.col=col;
        this.row=row;
    }


    public boolean equals(Object position){
        Position p= (Position) position;
        if(p.col == this.col && p.row == this.row){
            return true;
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
