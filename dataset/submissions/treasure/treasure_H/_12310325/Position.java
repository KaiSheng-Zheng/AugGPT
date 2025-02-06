public class Position {
private int row;
private int col;
public Position(int row, int col){
    this.row=row;
    this.col=col;
}
public void setPosition(Object position){
    Position p =(Position) position;
    this.col=p.col;
    this.row=p.row;

}

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean equals(Object position){
    Position p =(Position) position;
    return p.getRow()==row&&p.getCol()==col;
    }


}
