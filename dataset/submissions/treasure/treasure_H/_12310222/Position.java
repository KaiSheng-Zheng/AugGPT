public class Position {
    private int row,col;
    public Position(int r,int c){
        setRow(r);
        setCol(c);
    }
    public void setRow(int r){row=r;}
    public void setCol(int c){col=c;}
    public int getRow(){return row;}
    public int getCol(){return col;}
    public boolean equals(Object position){
        Position temp=(Position) position;
        return this.getCol()== temp.getCol()&&getRow()== temp.getRow();
    }
}
