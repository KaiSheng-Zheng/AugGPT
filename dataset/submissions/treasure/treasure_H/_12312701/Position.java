public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public Position(Position pos) {
        copyFrom(pos);
    }

    /*
    public boolean equals(Position position) {
        if (row != position.row) return false;
        return col == position.col;
    }

    public boolean equals(Object Unknown) {
        return false;
    }

     */
    public boolean equals(Object position) {
        //Position t = new Position((Position) position);
        if (getRow() != ((Position) position).getRow()) return false;
        return getCol() == ((Position) position).getCol();
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

    public void directMove(Direction direction, int steps) {
        switch (direction) {
            case UP -> row -= steps;
            case DOWN -> row += steps;
            case LEFT -> col -= steps;
            case RIGHT -> col += steps;
        }
    }

    public void copyFrom(Position position) {
        row = position.row;
        col = position.col;
    }

    public static boolean isBigger(Position position1, Position position2) {
        if (position1.getRow() > position2.getRow()) return true;
        if (position1.getRow() < position2.getRow()) return false;
        return position1.getCol() > position2.getCol();
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", row, col);
    }
}
