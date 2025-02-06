

public class Position {
    private int row;

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

    private int col;

    public Position(int a, int b) {
        row = a;
        col = b;
    }

    public boolean equals(Object position) {
        Position p = (Position) position;
        if (p.row == row && p.col == col) {
            return true;
        } else {
            return false;
        }
    }
}
