import java.util.function.Function;

public class Player
{
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxstep;
    private static int  cn=0;

    public Player(Map map, Position initialPosition)
    {
        score=0;steps=0;id=++cn;maxstep=Integer.MAX_VALUE;
        this.map=map;
        position=initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        score=0;steps=0;id=++cn;maxstep=maxStepAllowed;
        this.map=map;
        position=initialPosition;
    }
    public boolean move(Direction direction, int steps)
    {
        Function<Direction,Boolean>move=new Function<Direction, Boolean>()
        {
            public Boolean apply(Direction direction)
            {
                if(position.getCol()+direction.getCol()<0||position.getCol()+direction.getCol()>=map.getColumns()||position.getRow()+direction.getRow()<0||position.getRow()+direction.getRow()>=map.getRows())
                {
                    return false;
                }
                position.setCol(position.getCol()+direction.getCol());
                position.setRow(position.getRow()+direction.getRow());
                return true;
            }
        };
        for(int i=0;i<steps;i++)
        {
            if(!map.isActive())return false;
            if(maxstep==0)return false;
            if(!move.apply(direction))return false;
            maxstep--;
            this.steps++;
            int sc=map.hasTreasure(position);
            if(sc!=0)
            {
                score+=sc;
                map.update(position);
                if(!map.isActive())return false;
            }
        }
        return true;
    }
    public boolean equals(Object player)
    {
        Player p=(Player)player;
        return id==p.id;
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

    public int getId()
    {
        return id;
    }
}
