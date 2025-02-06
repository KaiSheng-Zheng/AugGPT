public class Player {
    private final int id,steps;
    private static int players;
    private int score,stepsUsed;
    private final Position position;
    private final Map map;

    public Player(Map map, Position initialPosition) {this(map,initialPosition,-1);}
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id=players++;
        this.steps = maxStepAllowed;
        this.position = initialPosition;
        this.map = map;
    }
    public boolean move(Direction direction,int steps){
        while (steps>0) {
            if (direction.equals(Direction.UP)&&position.getRow()<=0 ||
            direction.equals(Direction.DOWN)&&position.getRow()>=map.getRows()-1 ||
            direction.equals(Direction.LEFT)&&position.getCol()<=0 ||
            direction.equals(Direction.RIGHT)&&position.getCol()>=map.getColumns()-1 ||
            this.steps>-1 && this.steps<=stepsUsed || !map.isActive())
                return false;
            stepsUsed++;
            steps--;
            position.go(direction);
            score+=map.hasTreasure(position);
            map.update(position);
        }
        return true;
    }
    public boolean equals(Object player){
        if (player.getClass()!=Player.class) return false;
        Player player1 = (Player) player;
        return this.id==player1.id;
    }
    public int getScore() {return score;}
    public int getSteps() {return stepsUsed;}
    public int getStepsUsed() {return stepsUsed;}
    public Position getPosition() {return position;}
    public int getId() {return id;}
    public static int getPlayers() {return players;}
    public String toString(){return String.format("%s %2d %2d",position,score,stepsUsed);}
}