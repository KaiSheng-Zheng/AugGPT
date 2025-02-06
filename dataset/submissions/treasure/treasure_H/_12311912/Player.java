public class Player
{
    private static int number = 0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private int maxsteps = -1;
    private Position position;
    private Map map;
    public Player(Map map,Position initialPos)
    {
        this.map = map;
        this.position = initialPos;
        this.id = ++number;
    }
    public Player(Map map,Position initialPos,int maxStepAllowed)
    {
        this.map = map;
        this.position = initialPos;
        this.maxsteps = maxStepAllowed;
        this.id = ++number;
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
        if (!map.isActive())
            return false;
        boolean bz = true;
        int currentstep = 0;
        for (int i = 1;i <= steps;i++)
        {
            if (!map.isActive())
            {
                bz = false;
                break;
            }
            if (outside(0,map.getRows(),this.position.getRow() + direction.getXmove()) || outside(0, map.getColumns(),this.position.getCol() + direction.getYmove()))
            {
                bz = false;
                break;
            }
            else
            {
                if (this.steps == maxsteps)
                {
                    bz = false;
                    break;
                }
                this.position = new Position(this.position.getRow() + direction.getXmove(),this.position.getCol() + direction.getYmove());
                this.score += map.hasTreasure(this.position);
                map.update(this.position);
                this.steps++;
            }
        }
        return bz;
    }
    public boolean outside(int left,int right,int index)
    {
        return !((index >= left) && (index < right));
    }
    public boolean equals(Object player)
    {
        Player otherplayer = (Player) player;
        return (otherplayer.getId() == id);
    }
}
