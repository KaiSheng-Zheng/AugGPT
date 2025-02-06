//package A4_2;

public class Player {
    private final int id;
    private int score;
    private int steps;//counting steps
    private Map map;
    private Position position;
    private int maxStepAllowed;
    private static int cur=0;//counting players
    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        setSteps(0);
        setScore(0);
        id=++cur;
    }
    public Player(Map map, Position position) {
        this(map,position,2147483647);
    }
    public boolean move(Direction direction, int steps)
    {
        if(!map.isActive())return false;
        for(int i=1;i<=steps;i++)
        {
            if(!map.isActive())return false;
            if(direction==Direction.UP)
            {
                int row=position.getRow()-1,col=position.getCol();
                if(row<0)return false;
                if(this.steps==maxStepAllowed)return false;
                this.steps++;position.setRow(row);
                this.score+=map.hasTreasure(position);map.update(position);
                continue;
            }
            if(direction==Direction.DOWN)
            {
                int row=position.getRow()+1,col=position.getCol();
                if(row>=map.getRows())return false;
                if(this.steps==maxStepAllowed)return false;
                this.steps++;position.setRow(row);
                this.score+=map.hasTreasure(position);map.update(position);
                continue;
            }
            if(direction==Direction.LEFT)
            {
                int row=position.getRow(),col=position.getCol()-1;
                if(col<0)return false;
                if(this.steps==maxStepAllowed)return false;
                this.steps++;position.setCol(col);
                this.score+=map.hasTreasure(position);map.update(position);
                continue;
            }
            if(direction==Direction.RIGHT)
            {
                int row=position.getRow(),col=position.getCol()+1;
                if(col>=map.getColumns())return false;
                if(this.steps==maxStepAllowed)return false;
                this.steps++;position.setCol(col);
                this.score+=map.hasTreasure(position);map.update(position);
                continue;
            }
        }
        return true;
    }
    public boolean equals(Object player)
    {
        if(id==((Player) player).getId())return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
