public class Player {
    private static int totalPlayerNumber=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition)
    {
        id=totalPlayerNumber;
        totalPlayerNumber++;
        score=0;
        steps=0;
        this.map=map;
        this.position=initialPosition;
        maxStepAllowed=-1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        id=totalPlayerNumber;
        totalPlayerNumber++;
        score=0;
        steps=0;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }

    public boolean move(Direction direction, int steps)
    {
        if(!map.isActive())
        {
            return false;
        }
        if(this.maxStepAllowed!=-1&&this.steps>=this.maxStepAllowed)
        {
            return false;
        }
        int success=1;
        for(int i=0;i<steps;i++)
        {
            if(!map.isActive())
            {
                return false;
            }
            if(this.maxStepAllowed!=-1&&this.steps>=this.maxStepAllowed)
            {
                return false;
            }
            else if(direction==Direction.UP)
            {
                if(this.position.getRow()==0)
                {
                    success=0;
                }
                else
                {
                    this.position.setRow(this.position.getRow()-1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(this.position);
                    this.map.update(this.position);
                }
            }
            else if(direction==Direction.DOWN)
            {
                if(this.position.getRow()==this.map.getRows()-1)
                {
                    success=0;
                }
                else
                {
                    this.position.setRow(this.position.getRow()+1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(this.position);
                    this.map.update(this.position);
                }
            }
            else if(direction==Direction.LEFT)
            {
                if(this.position.getCol()==0)
                {
                    success=0;
                }
                else
                {
                    this.position.setCol(this.position.getCol()-1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(this.position);
                    this.map.update(this.position);
                }
            }
            else if(direction==Direction.RIGHT)
            {
                if(this.position.getCol()==this.map.getColumns()-1)
                {
                    success=0;
                }
                else
                {
                    this.position.setCol(this.position.getCol()+1);
                    this.steps+=1;
                    this.score+=map.hasTreasure(this.position);
                    this.map.update(this.position);
                }
            }
        }
        return success==1;
    }
    public boolean equals(Object player)
    {
        return ((Player) player).id==this.id;
    }
    public int getSteps() {
        return steps;
    }
    public int getScore() {
        return score;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public int getId() {
        return id;
    }
}