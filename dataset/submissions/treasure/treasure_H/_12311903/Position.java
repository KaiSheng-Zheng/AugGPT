public class Position {
    private int row;
    private int col;
    public int getRow(){
        return row;
    }

    public int getCol(){

        return col;
    }
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
@Override
    public boolean equals( Object position){
        if(position instanceof Position position0){
            return this.row == position0.getRow() && this.col == position0.getCol();
    }
        else return false;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
