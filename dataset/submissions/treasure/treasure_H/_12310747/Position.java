public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object positon){
        Position p=(Position) positon;
        boolean f=false;
        if (p.getRow()==this.row&&p.getCol()==this.col){
            f=true;
        }
        return f;
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