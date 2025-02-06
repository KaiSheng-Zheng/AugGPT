public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean equals(Object position){
        if (position instanceof Position position1) {
            if(position1.row == this.row && position1.col == this.col){
                return true;
            }else return false;
        }
        return false;
    }

}
