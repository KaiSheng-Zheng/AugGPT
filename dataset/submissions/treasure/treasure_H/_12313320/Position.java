public class Position {
    private int row;
    private int col;
    public Position(int row, int col){
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position){
        Position temp=(Position) position;
        if(temp.getCol()==this.getCol()&&temp.getRow()==this.getRow())return true;
        else return false;
    }

    @Override
    public String toString() {
        return String.format("%d  %d",row,col);
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
}
