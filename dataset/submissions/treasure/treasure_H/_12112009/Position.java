public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public int getrow(){return row;}
    public int getcol(){return col;}
    public void setrow(int a){this.row=a;}
    public void setcol(int a){this.col=a;}
    public boolean equals(Object position){
        Position p=(Position)position;
        if(p.getrow()==row&&p.getcol()==col){
            return true;}
            else{return false;}
    }
}