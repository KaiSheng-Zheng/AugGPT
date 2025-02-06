public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object pos) {
        Position otherPos = (Position) pos;
        if (otherPos.getRow() == this.row && otherPos.getCol() == this.col) {
            return true;
        } else {
            return false;

        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}