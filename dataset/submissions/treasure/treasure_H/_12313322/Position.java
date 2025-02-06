import java.util.*;
public class Position
{
    private int row;
    private int col;
    public Position(int x,int y)
    {
        this.row=x;
        this.col=y;
    }
    public int getRow()
    {
        return this.row;
    }
    public int getCol()
    {
        return this.col;
    }
    public void setRow(int x)
    {
        this.row=x;
    }
    public void setCol(int y)
    {
        this.col=y;
    }
    public boolean equals(Object p)
    {
        Position  pos=(Position)p;
        if(this.row==pos.getRow() && this.col==pos.getCol()) return true;
        return false;
    }
}
