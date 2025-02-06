public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void rowu() {
        row++;
    }

    public void rowd() {
        row--;
    }

    public void colu() {
        col++;
    }

    public void cold() {
        col--;
    }

    public boolean equals(Object position) {
        Position p = (Position) position;
        if (p.row == this.row && p.col == this.col) return true;
        return false;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
