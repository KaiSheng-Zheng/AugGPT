
public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return this.row == position.getRow() && this.col == position.getCol();
        }
        return false;
    }
}
