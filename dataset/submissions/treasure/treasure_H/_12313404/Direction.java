public enum Direction {

    UP(-1, 0), DOWN(1, 0), RIGHT(0, 1), LEFT(0, -1);

    public final int row;
    public final int column;

    Direction(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
