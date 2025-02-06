public class Position
{
	private int row;
	private int col;
	public Position(int row,int col)
	{
		this.row=row;
		this.col=col;
	}
	public boolean equals(Object position)
	{
		Position t=(Position)position;
		return row==t.row&&col==t.col;
	}
	public int getRow()
	{
		return row;
	}
	public void setRow(int row)
	{
		this.row=row;
	}
	public int getCol()
	{
		return col;
	}
	public void setCol(int col)
	{
		this.col=col;
	}
}