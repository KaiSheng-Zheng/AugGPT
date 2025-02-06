public class Player
{
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int count=1;
    //maxStepAllowed=-1 means no restriction
    private int maxStepAllowed;

    public Player(Map map,Position initialPosition) {
        this.position = initialPosition;
        this.maxStepAllowed = -1;
        this.map = map;
        this.score=0;
        this.steps=0;
        this.id=count;
        count++;
    }

    public Player(Map map, Position initialPosition,int maxStepAllowed) {
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.score=0;
        this.steps=0;
        this.map=map;
        this.id=count;
        count++;
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
        if(!map.isActive()) return false;
        for(int i=1;i<=steps;i++)
        {
            if(!map.isActive()) return false;
            if(!oneStep(direction)) return false;
        }
        return true;
    }
    public boolean oneStep(Direction direction)
    {
        if( ((getPosition().getCol()+direction.col)>map.getColumns()-1) || ((getPosition().getCol()+direction.col)<0) || ((getPosition().getRow()+direction.row)>map.getRows()-1) || ((getPosition().getRow()+direction.row)<0) || (getSteps()==maxStepAllowed))
            return false;
        else
        {
            Position temp=new Position(getPosition().getRow()+direction.row,getPosition().getCol()+direction.col);
            setPosition(temp);
            if(map.hasTreasure(temp)!=0)
            {
                setScore(getScore()+map.hasTreasure(temp));
                map.update(temp);
            }
            setSteps(getSteps()+1);
        }
        return true;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public boolean equals(Object player)
    {
        if(player instanceof Player)
        {
            return ((Player) player).getId() == getId();
        }
        return false;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
