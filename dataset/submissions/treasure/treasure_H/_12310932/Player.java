public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int c=0;
    private int max;
    public Player(Map map, Position initialPosition){
        c++;
        this.id=c;
        this.map=map;
        this.steps=0;
        this.score=0;
        this.max=-1;
        this.position=initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        c++;
        this.id=c;
        this.map=map;
        this.steps=0;
        this.score=0;
        this.max=maxStepAllowed;
        this.position=initialPosition;
    }
    public boolean move(Direction direction, int steps)
    {
        if(max==0)return false;
        if(!map.isActive())return false;
        if(direction.equals(Direction.UP))
        {
            for (int i=1;i<=steps;i++){
                if(position.getRow()<=0)return false;
                else
                {
                    position.setCol(position.getRow()-1);
                    this.steps++;
                    max--;
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||max==0)
                    {
                        if(i==steps)return true;
                        else return false;
                    }
                }
            }
            return true;
        }
        if(direction.equals(Direction.DOWN))
        {
            for (int i=1;i<=steps;i++){
                if(position.getRow()>=this.map.getRows()-1)return false;
                else
                {
                    position.setCol(position.getRow()+1);
                    this.steps++;
                    max--;
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||max==0)
                    {
                        if(i==steps)return true;
                        else return false;
                    }
                }
            }
            return true;
        }
        if(direction.equals(Direction.RIGHT))
        {
            for (int i=1;i<=steps;i++){
                if(position.getCol()>=this.map.getColumns()-1)return false;
                else
                {
                    position.setCol(position.getCol()+1);
                    this.steps++;
                    max--;
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||max==0)
                    {
                        if(i==steps)return true;
                        else return false;
                    }
                }
            }
            return true;
        }
        if(direction.equals(Direction.LEFT))
        {
            for (int i=1;i<=steps;i++){
                if(position.getRow()==0)return false;
                else
                {
                    position.setCol(position.getCol()-1);
                    this.steps++;
                    max--;
                    this.score+=map.hasTreasure(this.position);
                    map.update(this.position);
                    if(!map.isActive()||max==0)
                    {
                        if(i==steps)return true;
                        else return false;
                    }
                }
            }
            return true;
        }
        return true;
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
    public boolean equals(Object player)
    {
        if(player instanceof Player p&&this.id==p.id)
        {
           return true;
        }
        return false;
    }

}
