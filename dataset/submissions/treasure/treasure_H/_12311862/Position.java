public class Position {
    private int row;
    private int col;
//    public void setRow(){
//        this.row = row;
//    }
    public int getRow(){
        return this.row;
    }
//    public void setCol(){
//        this.col = col;
//    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return this.col;
    }

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position){
        Position p = (Position) position;
        return row==p.row && col==p.col;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}