public class Position
{
    private int row;
    private int col;
    public Position(int row,int col)
    {
        this.col=col;
        this.row=row;
    }
    public void setRow(int row)
    {
        this.row=row;
    }
    public void setCol(int col)
    {
        this.col=col;
    }
    public int getCol()
    {
        return col;
    }
    public int getRow()
    {
        return row;
    }
    @Override
    public boolean equals(Object position)
    {
        if(position instanceof Position p)
            return (p.getCol() == col && p.getRow() == row);
        return false;
    }
}
