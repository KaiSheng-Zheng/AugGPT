public class Position {
    private int row;
    private int col;

//    Constructors
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }


//    Methods
    public boolean equals(Object position){
        if(position instanceof Position){
            if(((Position) position).row ==this.row&&((Position) position).col ==this.col){
                return true;
            }
        }
        return false;
    }


//    set,get
    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

}
