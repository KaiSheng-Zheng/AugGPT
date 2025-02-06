public class Player
{
	private final int id;
	private int score;
	private int steps;
	private Position position;
	private Map map;
	int maxStepAllowed;
	static int cnt;
	public Player(Map map,Position initialPosition)
	{
		this.map=map;
		this.position=initialPosition;
		this.maxStepAllowed=Integer.MAX_VALUE;
		steps=0;
		score=0;
		id=++cnt;
	}
	public Player(Map map,Position initialPosition,int maxStepAllowed)
	{
		this.map=map;
		this.position=initialPosition;
		this.maxStepAllowed=maxStepAllowed;
		steps=0;
		score=0;
		id=++cnt;
	}
	public int getId() 
	{
        return id;
    }
    public int getScore() 
	{
        return score;
    }
    public int getSteps() 
	{
        return steps;
    }
    public Position getPosition() 
	{
        return position;
    }
	public boolean move(Direction direction,int steps)
	{
		int dx=direction.getDx(),dy=direction.getDy();
		for(int i=1;i<=steps;i++)
		{
			if(!map.isActive())
				return false;
			if(this.steps==maxStepAllowed)
				return false;
			int px=position.getRow(),py=position.getCol();
			if(px+dx<0||px+dx>=map.getRows()||py+dy<0||py+dy>=map.getColumns())
				return false;
			this.steps++;
			position.setRow(px+dx);
			position.setCol(py+dy);
			score+=map.hasTreasure(position);
			map.update(position);
		}
		return true;	
	}
	public boolean equals(Object player)
	{
		Player t=(Player)player;
		return id==t.id;
	}
}