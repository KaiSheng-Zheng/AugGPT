public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }

    public boolean equals(Object position){
        Position p = (Position) position;
        return row == p.getRow() && col == p.getCol();
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
}

