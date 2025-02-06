public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        setRow(row);
        setCol(col);
    }
    public boolean equals(Object position){
        boolean tof = false;
        Position p = (Position) position;
        if(this.row == p.row && this.col == p.col ){
            tof = true;
        }
        else{
            tof = false;
        }
        return tof;
    }
    public int getRow(){
        return row;
    }
    public int getCol() {
        return col;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
}