public class Position
{
    private int row;
    private int col;
    public Position(int row,int col)
    {
        this.row = row;
        this.col = col;
    }
    public int getRow()
    {
        return this.row;
    }
    public int getCol()
    {
        return this.col;
    }
    public boolean equals(Object position)
    {
        Position otherpos = (Position) position;
        return ((otherpos.getCol() == this.col) && (otherpos.getRow() == this.row));
    }
}
