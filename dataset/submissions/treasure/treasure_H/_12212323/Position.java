public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object pos){
        boolean isEquals;
        Position otherPos = (Position) pos;
        if(otherPos.row==this.row&&otherPos.col==this.col){
            isEquals=true;
        }else {
            isEquals=false;
        }
        return isEquals;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void setRow(int row){
            this.row=row;
    }
    public void setCol(int col){
            this.col=col;
    }
}
