public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        if (position instanceof Position){
            Position tempP=(Position)position;
            return equals(tempP);
        }else return false;
    }
    public boolean equals(Position tempP){
        return (tempP.getRow() == this.row & tempP.getCol() == this.col);
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }

    public String toString(){
        return "("+this.col+","+this.row+")";
    }
}