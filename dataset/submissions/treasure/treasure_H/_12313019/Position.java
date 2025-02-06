
public class Position {
    private int row;
    private int col;

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

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object position)
    {
        Position ptemp=(Position) position;
        return this.col==ptemp.col&&this.row==ptemp.row;
    }

    public String toString()
    {
        return String.format("%d %d",row,col);
    }

}
