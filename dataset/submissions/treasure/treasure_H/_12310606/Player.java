public class Player
{
    private final int id;
    private int score;
    private int steps,maxStepAllowed;
    private Position position;
    private Map map;
    static private int total=0;
    public Player(Map map, Position initialPosition)
    {
        this.map=map;
        steps=0;
        score=0;
        position=initialPosition;
        this.maxStepAllowed=2147483647;
        id=++total;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        this.map=map;
        steps=0;
        score=0;
        position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        id=++total;
    }
    public int getId()
    {
        return id;
    }

    public int getSteps()
    {
        return steps;
    }

    public int getScore()
    {
        return score;
    }

    public Position getPosition()
    {
        return position;
    }

    @Override
    public boolean equals(Object player)
    {
        if((player instanceof Player pl))
            return pl.id == this.id;
        return false;
    }

    public boolean move(Direction direction, int steps)
    {
        score+=map.hasTreasure(position);
        map.update(position);
//        System.out.printf("player%d totalStep=%d,score=%d,(%d,%d)\n",id,this.steps,score,position.getRow(),position.getCol());
        if(steps==0)
            return true;
        if (!map.isActive())
        {
//            System.out.printf("id is %d,map is disactive\n",id);
            return false;
        }
        if(maxStepAllowed==0)
        {
//            System.out.printf("player%d no step allowed\n",id);
            return false;
        }
        if(direction==Direction.UP)
        {
            if(position.getRow()>0)
            {
                position.setRow(position.getRow()-1);
                maxStepAllowed--;
                this.steps++;
                return move(direction,steps-1);
            }
            else
                return false;
        }
        else if(direction==Direction.DOWN)
        {
            if(position.getRow()+1<map.getRows())
            {
                position.setRow(position.getRow() + 1);
                maxStepAllowed--;
                this.steps++;
                return move(direction,steps-1);
            }
            else
                return false;
        }
        else if(direction==Direction.LEFT)
        {
            if(position.getCol()>0)
            {
                position.setCol(position.getCol() - 1);
                maxStepAllowed--;
                this.steps++;
                return move(direction,steps-1);
            }
            else
                return false;
        }
        else
        {
            if(position.getCol()+1<map.getColumns())
            {
                position.setCol(position.getCol() + 1);
                maxStepAllowed--;
                this.steps++;
                return move(direction,steps-1);
            }
            else
                return false;
        }
    }
}