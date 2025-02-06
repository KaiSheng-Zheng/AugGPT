public class Position{
    private int row,col;
    public int getC(){return col;}public int getR(){return row;}
    public void setC(int c){col=c;}public void setR(int r){row=r;}
    public Position(int r,int c){row=r;col=c;}
    public boolean equals(Object P){Position p=(Position)P;return row==p.row&&col==p.col;}
}