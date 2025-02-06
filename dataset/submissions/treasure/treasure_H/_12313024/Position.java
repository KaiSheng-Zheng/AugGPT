public class Position {
    private int row;
    private int col;
    public Position (int r, int c) {
        row = r;
        col = c;
    }
    public boolean equals (Object position) {
        Position pos = (Position) position;
        return pos.getRow() == row && pos.getCol() == col;
    }
    public int getRow () {
        return row;
    }
    public int getCol () {
        return col;
    }
    public void setRow (int r) {
        row = r;
    }
    public void setCol (int c) {
        col = c;
    }
}
