public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row = row;
        this.col = col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object position) {
        Position position1 = (Position)position;
        if (position1.getCol()== col&&position1.getRow()==row){
            return true;
        }else {
            return false;
        }

    }
}
