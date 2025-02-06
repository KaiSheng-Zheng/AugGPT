public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object position) {
        Position p = (Position) position;
        return (p.getCol() == this.col && p.getRow() == this.row);
    }

    public void UP() {
        this.row--;
    }

    public void DOWN() {
        this.row++;
    }

    public void LEFT() {
        this.col--;
    }

    public void RIGHT() {
        this.col++;
    }

    public Position() {
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String toString() {
        return "Position{row = " + row + ", col = " + col + "}";
    }
}