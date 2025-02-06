public class Position {
    private int row,col;

    public Position(int r, int c){
        this.row=r;this.col=c;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        return (p.row==row)&&(p.col==col);
    }
    public int getRow(){return row;}
    public int getCol(){return col;}
    public void setRow(int x){row=x;return;}
    public void setCol(int x){col=x;return;}

}
