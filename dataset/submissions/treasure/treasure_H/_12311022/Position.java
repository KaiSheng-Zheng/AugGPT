

public class Position {
    private int row;
    private int col;
    public Position(int row,int col){
        this.row=row;
        this.col=col;
    }

    public int getRow() {
        return row;
    }

    public void up() {
       row--;
    }
    public void down() {
       row++;
    }
    public void right() {
        col++;
    }
    public void left() {
        col--;
    }
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public  boolean equals(Object position){
        Position p=(Position) position;
        return p.getCol()==col && p.getRow()==row?true:false;
    }
}
