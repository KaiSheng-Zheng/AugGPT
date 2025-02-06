public class Position {
    private int row;
    private int col;

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

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position){
        Position p=(Position) position;
        if(p.getRow()==getRow()&&p.getCol()==getCol()){
            return true;
        }else {
            return false;
        }
    }
}