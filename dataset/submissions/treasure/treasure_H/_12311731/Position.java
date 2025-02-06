public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row = row;
        this.col = col;
    }

    public boolean equals(Position position){
        if(this.row == position.getRow() && this.col == position.getCol()){
            return true;
        }
        return false;
    }
@Override
    public String toString(){return "("+this.row+","+this.col+")";}
    public int getRow() {return row;}
    public void setRow(int row) {this.row = row;}
    public int getCol() {return col;}
    public void setCol(int col) {this.col = col;}
}