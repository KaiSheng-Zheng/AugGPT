public class Position {
    private int row,col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public int getRow(){return row;}
    public int getCol(){return col;}
    public void setRow(int x){row=x;}
    public void setCol(int y){col=y;}
    public boolean equals(Object position){
        Position p=(Position) position;
        return col==p.getCol() && row==p.getRow();
    }
    public void print(){
        System.out.printf("%d %d\n",row,col);
    }
}
