
import java.util.Random;

public class Player {
    //id: a unique ID for each player. Different players should have different IDs.
    //score: the current scores of the player. Initialized to 0.
    //steps: the number of steps taken by the player. Initialized to 0.
    //position: the current position of the player. Multiple players can be at the same position at the same time.
    //map: the current map.
    private final int id;
    private int score;
    private int max_steps;
    private int steps = 0;
    private Position position;
    private Map map;
    Random random = new Random();
    public Player(Map map, Position initialPosition){
        this.id = random.nextInt(Integer.MAX_VALUE);
        this.score = 0;
        this.max_steps = Integer.MAX_VALUE;
        this.position = initialPosition;
        this.map = map;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.id = random.nextInt(Integer.MAX_VALUE);
        this.score = 0;
        this.max_steps = maxStepAllowed;
        this.position = initialPosition;
        this.map = map;
    }

    public int getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }
    public Position getPosition(){
        return this.position;
    }
    // The method returns true if the player can successfully move the given steps to the given direction. The method returns false if:
    //
    //The map is inactive, meaning that all treasures have been found. In this case, players can no longer move.
    //The player cannot move at all because s/he will hit the boundary of the map.
    //The player cannot move because s/he has already taken maximum steps allowed.
    //The player can move. However, s/he cannot finish all the steps because s/he will hit the boundary during the process.
    //For example, if steps is 5, but the player can only take 2 steps before hitting the boundary. Then the player will take only 2 steps and stop.
    public boolean move(Direction direction, int steps){
        if (!map.isActive()){
            return false;
        }
        if (direction == Direction.UP) {
            for (int i = 0; i < steps; i++) {
                if (position.getRow() - 1 < 0 || max_steps == 0) {
                    return false;
                } else {
                    position.setRow(position.getRow() - 1);
                    this.steps++;
                    this.max_steps--;
                    collectTreasure();
                }
            }
            return true;
        }
        if (direction == Direction.DOWN) {
            for (int i = 0; i < steps; i++) {
                if (position.getRow() + 1 >= map.getRows() || max_steps == 0) {
                    return false;
                } else {
                    position.setRow(position.getRow() + 1);
                    this.steps++;
                    this.max_steps--;
                    collectTreasure();
                }
            }
            return true;
        }
        if (direction == Direction.LEFT) {
            for (int i = 0; i < steps; i++) {
                if (position.getCol() - 1 < 0 || max_steps == 0) {
                    return false;
                } else {
                    position.setCol(position.getCol() - 1);
                    this.steps++;
                    this.max_steps--;
                    collectTreasure();
                }
            }
            return true;
        }
        if (direction == Direction.RIGHT) {
            for (int i = 0; i < steps; i++) {
                if (position.getCol() + 1 >= map.getColumns() || max_steps == 0) {
                    return false;
                } else {
                    position.setCol(position.getCol() + 1);
                    this.steps++;
                    this.max_steps--;
                    collectTreasure();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;
            return this.id == player.getId();
        }
        return false;
    }
    public int getSteps() {
        return steps;
    }
    // If there is a treasure in any position of the Move path, the score of the treasure must be added and the treasure must be updated.
    private void collectTreasure(){
        int score = map.hasTreasure(position);
        this.score += score;
        map.update(position);
    }
}
