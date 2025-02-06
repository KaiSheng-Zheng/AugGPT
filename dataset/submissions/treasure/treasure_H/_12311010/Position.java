public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        this.col = col;
        this.row =row;
    };

    public boolean equals(Object position){
    Position p = (Position) position;
        return p.row == this.row && p.col == this.col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }


}

