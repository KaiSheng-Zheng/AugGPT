public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.col = col;
        this.row = row;
    }
    @Override
    public boolean equals (Object position){
        Position p = (Position) position;
        if (this.col==p.col &&this.row == p.row){
            return true;
        }else return false;
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
}
