public class Position {
    private int row;
    private int col;

    public Position(int row,int col){
        this.row = row;
        this.col = col;
    }

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
    
    public boolean equals(Object position){
        if(position == this){
            return true;
        }
        Position position2 = (Position)position;
        if(position2.getCol()==this.getCol()&&position2.getRow()==this.getRow()){
            return true;
        }
        else return false;
    }

    

}
