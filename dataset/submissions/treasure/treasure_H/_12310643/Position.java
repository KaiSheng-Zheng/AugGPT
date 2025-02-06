public class Position {
    private int row;
    private int col;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        Position p=(Position)position;
        boolean b1=(p.row==this.row)&&(p.col==this.col);
        return b1;
    }
    public String toString(){
        return String.format("(%d,%d)",getRow(),getCol());
    }
}
