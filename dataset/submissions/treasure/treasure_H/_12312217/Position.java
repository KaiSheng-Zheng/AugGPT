public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        if(p.col==this.col&&p.row==this.row){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return "("+this.row+","+this.col+")";
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
