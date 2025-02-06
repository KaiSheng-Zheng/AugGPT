import java.io.File;

public class Position
{
    private int row;
    private int col;
    private boolean active=true;
    public boolean getActive()
    {
        return active;
    }
    public void setActive()
    {
        this.active=false;
    }
    public Position(int row, int col)
    {
        this.row=row;
        this.col=col;
    }
    public boolean equals(Object position)
    {
        Position temp=(Position)position;
        return this.row==temp.row&&this.col==temp.col;
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
}