public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        if(this.col==((Position) position).col&&this.row==((Position) position).row){
            return true;
        }else {
            return false;
        }
    }
    public void setRow(int n){
        this.row=n;
    }
    public void setCol(int n){
        this.col=n;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
}
