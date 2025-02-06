public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

   

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row, Map map) {
        if (row < 0 || row >= map.getRows()) {
            throw new IllegalArgumentException("Row value is out of bounds");
        }
        this.row = row;
    }

    public void setCol(int col, Map map) {
        if (col < 0 || col >= map.getColumns()) {
            throw new IllegalArgumentException("Column value is out of bounds");
        }
        this.col = col;
    }

    public Position calculateNewPosition(Direction direction, int steps, Map map) {
        int newRow = this.row;
        int newCol = this.col;

        if (direction == Direction.UP) {
            newRow -= steps;
        } else if (direction == Direction.DOWN) {
            newRow += steps;
        } else if (direction == Direction.LEFT) {
            newCol -= steps;
        } else if (direction == Direction.RIGHT) {
            newCol += steps;
        }

        if (map.isValidPosition(newRow, newCol)) {
            return new Position(newRow, newCol);
        } else {
            return new Position(this.row, this.col);
        }
    }


    @Override
    public boolean equals(Object position) {
        if (this == position) {
            return true;
        }
        if (position == null || getClass() != position.getClass()) {
            return false;
        }
        Position p = (Position) position;
        return row == p.row && col == p.col;
    }


}
