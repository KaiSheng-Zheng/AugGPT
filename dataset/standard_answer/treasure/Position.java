public class Position {
    private int row;
    private int col;

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

    public Position(int row, int col) {
        //todo
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object pos) {
        if(pos == this) return true;
        if(pos instanceof Position) {
            return this.row == ((Position)pos).row &&this.col == ((Position)pos).col;
        }
        return false;
    }
}
