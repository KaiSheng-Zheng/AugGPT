public class Player
{
    private static int idgen = 1;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private final int maxStep;
    private Map map;
    public Player(Map map, Position initialPosition)
    {
        this.map = map;
        this.id = idgen++;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStep = Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed)
    {
        this.map = map;
        this.id = idgen++;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStep = maxStepAllowed;
    }
    public int getId() { return id;}
    public boolean move(Direction direction, int steps)
    {
        if (!map.isActive() || steps < 0)
            return false;

        int rowCheck = position.getRow();
        int colCheck = position.getCol();

        if (steps >= this.maxStep)
            steps = this.maxStep;

        if (direction == Direction.UP)
            rowCheck = rowCheck - steps;
        else if (direction == Direction.DOWN)
            rowCheck = rowCheck + steps;
        else if (direction == Direction.LEFT)
            colCheck = colCheck - steps;
        else if (direction == Direction.RIGHT)
            colCheck = colCheck + steps;

        if (rowCheck < 0)
        {
            steps = steps - position.getRow();
            rowCheck = 0;
        }
        else if(rowCheck > map.getRows())
        {
            steps = steps - position.getRow();
            rowCheck = map.getRows();
        }
        if (colCheck > map.getCol())
        {
            steps = steps - position.getCol();
            colCheck = map.getCol();
        }
        else if(colCheck < 0)
        {
            steps = steps - position.getCol();
            colCheck = 0;
        }

        if(direction == Direction.UP)
        {
            for(int x=position.getRow(); x>=rowCheck; x--)
            {
                int scoring = map.hasTreasure(new Position(x,colCheck));
                if(scoring>0)
                {
                    this.score = this.score + scoring;
                    map.update(new Position(x, colCheck));
                }
            }
        }
        if(direction == Direction.DOWN)
        {
            for(int x=position.getRow(); x<=rowCheck; x++)
            {
                int scoring = map.hasTreasure(new Position(x,colCheck));
                if(scoring>0)
                {
                    this.score = this.score + scoring;
                    map.update(new Position(x,colCheck));
                }
            }
        }
        if(direction == Direction.LEFT)
        {
            for(int x=position.getCol(); x>=colCheck; x--)
            {
                int scoring = map.hasTreasure(new Position(rowCheck,x));
                if(scoring>0)
                {
                    this.score = this.score + scoring;
                    map.update(new Position(rowCheck,x));
                }
            }
        }
        if(direction == Direction.RIGHT)
        {
            for(int x=position.getCol(); x<=colCheck; x++)
            {
                int scoring = map.hasTreasure(new Position(rowCheck,x));
                if(scoring>0)
                {
                    this.score = this.score + scoring;
                    map.update(new Position(rowCheck,x));
                }
            }
        }

        this.steps = this.steps + steps;
        position.setCol(colCheck);
        position.setRow(rowCheck);
        return true;
    }
    public void setSteps(int steps) {this.steps = steps;}
    public int getSteps() {return steps;}
    public void setPosition(Position position) {this.position = position;}
    public Position getPosition() {return position;}
    public int getScore() {return score;}

    public boolean equals(Object player)
    {
        if(this == player)
            return true;
        else if(player instanceof Player || player == null)
            return false;

        Player p = (Player) player;
        return this.id == p.getId();
    }
}
