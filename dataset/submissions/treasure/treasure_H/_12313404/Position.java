public class Position implements Comparable<Position> {

    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof Position pos) {
            return (this.row == pos.row && this.col == pos.col);
        }
        return false;
    }

    @Override
    public int compareTo(Position o) {
        return col == o.col
                ? Integer.compare(row, o.row)
                : Integer.compare(col, o.col);
    }

    public Position updatePos(Direction direction, Map map) {
        var tmp = new Position(this.row + direction.row, this.col + direction.column);
        if (tmp.col >= 0 && tmp.col < map.getColumns() && tmp.row >= 0 && tmp.row < map.getRows()) {
            return tmp;
        }
        return null;
    }

}
