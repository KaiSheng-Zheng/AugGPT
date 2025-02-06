public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public void setRow(int r){
        row=r;
    }
    public void setCol(int c){
        col=c;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        if((this.col==p.col)&(this.row==p.row)){
            return true;
        }
        else{
            return false;
        }
    }
}
