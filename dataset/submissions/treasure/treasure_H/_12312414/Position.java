public class Position {
    private int row;
    private int col;

    public boolean equals(Object position){
        Position position1 = (Position) position;
        if (position1.getRow() == this.row && position1.getCol() == this.col) {
            return true;
        }else {
            return false;
        }
    }
    public Position() {
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

}