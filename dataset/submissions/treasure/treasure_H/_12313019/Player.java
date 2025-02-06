
public class Player
{
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;

    static int count=0;
    private int maxStep;
    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;
        id=++count;
        score=0;
        steps=0;
        maxStep=99999;
    }
    public Player(Map map, Position initialPosition,int maxStepAllowed) {
        this.position = initialPosition;
        this.map = map;
        id=++count;
        maxStep=maxStepAllowed;
        score=0;
        steps=0;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    public boolean move(Direction direction, int steps)
    {
        if(!map.isActive())
            return false;
        switch(direction)
        {
            case RIGHT :

                for(int i=1;i<=steps;i++)
                {
                    if(!map.isActive())
                        return false;
                    if(this.steps==maxStep)
                    {
                        return false;
                    }
                    if(position.getCol()==map.getColumns()-1)
                    {
                        return false;
                    }
                    position.setCol(position.getCol()+1);
                    int tempScore=map.hasTreasure(position);

                    if(tempScore>0)
                    {
                        score+=tempScore;
                        map.update(position);
                    }
                    this.steps++;
                }
                break;
            case LEFT :
                for(int i=1;i<=steps;i++)
                {
                    if(!map.isActive())
                        return false;
                    if(this.steps==maxStep)
                    {
                        return false;
                    }
                    if(position.getCol()==0)
                        return false;
                    position.setCol(position.getCol()-1);
                    int tempScore=map.hasTreasure(position);

                    if(tempScore>0)
                    {
                        score+=tempScore;
                        map.update(position);
                    }
                    this.steps++;

                }
                break;
            case UP :
                for(int i=1;i<=steps;i++)
                {
                    if(!map.isActive())
                        return false;
                    if(this.steps==maxStep)
                    {
                        return false;
                    }
                    if(position.getRow()==0)
                        return false;
                    position.setRow(position.getRow()-1);
                    int tempScore=map.hasTreasure(position);

                    if(tempScore>0)
                    {
                        score+=tempScore;
                        map.update(position);
                    }
                    this.steps++;

                }
                break;
            case DOWN :
                for(int i=1;i<=steps;i++)
                {
                    if(!map.isActive())
                        return false;
                    if(this.steps==maxStep)
                    {
                        return false;
                    }
                    if(position.getRow()==map.getRows()-1)
                    {
                        return false;
                    }
                    position.setRow(position.getRow()+1);
                    int tempScore=map.hasTreasure(position);

                    if(tempScore>0)
                    {
                        score+=tempScore;
                        map.update(position);
                    }
                    this.steps++;

                }
                break;
        }
        return true;
    }
    public boolean equals(Object player)
    {
        return ((Player) player).getId()==this.id;
    }
}

