public class Player {
    private final int id;
    private int score=0;
    private int steps=0,maxStepAllowed=(int)1E9;
    private Position position;
    private Map map;
    static int count = 0;
    public Player(Map map, Position initialPosition) {
        this.map=map;
        position=initialPosition;
        id=++count;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map,initialPosition);
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        while (steps!=0&&map.isActive()&&
                map.moveByOne(position,direction)!=null&&maxStepAllowed!=0) {
            position=map.moveByOne(position,direction);
            steps--;this.steps++;
            maxStepAllowed--;
            if (map.hasTreasure(position)!=0) {
                score+=map.hasTreasure(position);
                map.update(position);
            }
        }
        return steps==0;
    }
    public boolean equals(Object player) {
        Player p=(Player) player;
        return p.id==id;
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
    public int compareTo(Player otherPlayer) {
        if (score!=otherPlayer.score) return score-otherPlayer.score;
        return otherPlayer.steps-steps;
    }
}