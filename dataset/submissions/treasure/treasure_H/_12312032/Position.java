public class Position
{
    private int row;
    private int col;
    public Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public int getRow()
    {
        return row;
    }
    public void setRow(int row)
    {
        this.row = row;
    }
    public int getCol()
    {
        return col;
    }
    public void setCol(int col)
    {
        this.col = col;
    }
    public boolean equals(Object position)
    {
        if(this == position)
            return true;
        else if(position instanceof Position || position == null)
            return false;

        Position p = (Position) position;
        return this.row == p.getRow() && this.col == p.getCol();
    }
}
