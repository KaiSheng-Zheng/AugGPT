public class Position{
    private int row, col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean equals(Object Obj){
        if(!(Obj instanceof Position)) return false;
        Position other = (Position) Obj;
        return row == other.row && col == other.col;
    }

    public Position move(Direction direction, int steps){
        return new Position(row + direction.dy() * steps, col + direction.dx() * steps);
    }
}