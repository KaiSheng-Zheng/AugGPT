public class Position {
    private int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public void go(Direction direction){
        switch (direction){
            case UP:
                row--;
                break;
            case DOWN:
                row++;
                break;
            case LEFT:
                col--;
                break;
            case RIGHT:
                col++;
                break;
        }
    }
    public boolean equals(Object position) {
        if (position.getClass()!=Position.class) return false;
        Position position1 = (Position) position;
        return this.row == position1.row && this.col == position1.col;
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
    public String toString(){
        return String.format("(%d,%d)",row,col);
    }
}
