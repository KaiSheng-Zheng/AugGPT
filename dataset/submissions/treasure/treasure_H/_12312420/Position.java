public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position) {
        Position p = (Position) position;
        return p.getRow() == this.row && p.getCol() == this.col;
    }
    public void move(int dx,int dy){row+=dx;col+=dy;}

    public int getRow() {return row;}
    public int getCol() {
        return col;
    }
}
