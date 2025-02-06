public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    private static int counter=0;


    public Player(Map map, Position initialPosition){
        this.id = ++counter;
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = 100000000;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this(map, initialPosition);
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){
        if(!map.isActive()||this.steps==maxStepAllowed) return false;

        score+=map.hasTreasure(position);
        map.update(position);
        
        for(int i=1;i<=steps&&this.steps<maxStepAllowed;i++,this.steps++){
            Position newPosition = position.move(direction, 1);
            if(!map.isInside(newPosition)||!map.isActive()) return false;
            position = newPosition;

            score+=map.hasTreasure(position);
            map.update(position);

            if(this.steps==maxStepAllowed-1&&i<steps){
                this.steps++;
                return false;
            }
        }

        return true;
    }

    public boolean equals(Object Obj){
        if(!(Obj instanceof Player)) return false;
        Player other = (Player) Obj;
        return id == other.id;
    }

    public int getId(){
        return id;
    }

    public int getScore(){
        return score;
    }

    public int getSteps(){
        return steps;
    }

    public Position getPosition(){
        return position;
    }
}