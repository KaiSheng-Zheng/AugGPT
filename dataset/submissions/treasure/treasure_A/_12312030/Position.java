
public class Position {
    private int row;
    private int col;
    public Position (int row,int col) {
        this.row=row;
        this.col=col;
    }
    public void setRow(int r) {row=r;}
    public void setCol(int c) {col=c;}
    public int getRow() {return row;}
    public int getCol() {return col;}
    public boolean equals (Object position) {
        if(position==null||!(position instanceof Position)) return false;
        if(this==position) return true;
        Position exa=(Position) position;
        if(this.col==exa.col&&this.row==exa.row) return true;
        return false;
    }
}
