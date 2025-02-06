public enum Direction
{
	UP(-1,0),
	DOWN(1,0),
	LEFT(0,-1),
	RIGHT(0,1);
	final int dx,dy;
	Direction(int dx,int dy)
	{
		this.dx=dx;
		this.dy=dy;
	}
	public int getDx()
	{
		return dx;
	}
	public int getDy()
	{
		return dy;
	}
}