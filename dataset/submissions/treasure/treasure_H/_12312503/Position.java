public class Position {
    private int row;
    private int col;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Position(int row, int col){
        this.col=col;
        this.row=row;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        if(p.getCol()==col&&p.getRow()==row){
            return true;
        }else {
            return false;
        }
    }

}
