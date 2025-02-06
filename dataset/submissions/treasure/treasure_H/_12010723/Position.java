
public class Position {
    private int row;
    private int col;

    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object position) {
        Position p = (Position) position;
        if(this.row== p.getRow()&&this.col==p.getCol()){
            return true;
        }else {
            return false;
        }
    }
}
