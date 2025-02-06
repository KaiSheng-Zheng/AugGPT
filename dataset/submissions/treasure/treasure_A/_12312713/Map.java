public class Map
{
	private final int rows;
	private final int columns;
	static private boolean isActive;
	private Treasure[] treasures;
	private int[][] s;
	private int c;
	public Map(int rows,int columns,Treasure[] treasures)
	{
		this.rows=rows;
		this.columns=columns;
		this.treasures=treasures;
		isActive=true;
		c=0;
		s=new int[rows][columns];
		for(int i=0;i<treasures.length;i++)
		{
			int x=treasures[i].getPosition().getRow();
			int y=treasures[i].getPosition().getCol();
			s[x][y]=treasures[i].getScore();
			c++;
		}
	}
	public int getRows()
	{
		return rows;
	}
	public int getColumns()
	{
		return columns;
	}
	public boolean isActive()
	{
		return isActive;
	}
	public int hasTreasure(Position position)
	{
		return s[position.getRow()][position.getCol()];
	}
	public void update(Position position)
	{
		if(s[position.getRow()][position.getCol()]>0)
		{
			s[position.getRow()][position.getCol()]=0;
			c--;
			if(c==0)
				isActive=false;
		}
	}
}