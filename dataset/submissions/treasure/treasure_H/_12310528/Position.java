public class Position {
    private int row;
    private int col;

    public Position(int row , int col){
        this.row = row;
        this.col = col;
    }//construct the object

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

    public boolean equals(Position position) {
        return this.row == position.row && this.col == position.col;
    }//The Functions
}