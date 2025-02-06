public class Position {
    private  int row;
    private  int col;

    public int getRow(){
        return row;
    }
    public void setRow(int A){
        row=row+A;
    }

    public int getCol(){
        return col;
    }

    public void setCol(int A){
        col=col+A;
    }
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }

    public boolean equals(Object position){
        Position B=(Position) position;
        if(this.getCol()==B.getCol()&&this.getRow()==B.getRow()){
            return true;
        }else return false;
    }
}
