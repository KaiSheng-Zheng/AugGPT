import java.util.Random;

public class Player implements Comparable<Player> {

    @Override
    public int compareTo(Player o) {
        if (score > o.score) return 1;
        if (score < o.score) return -1;
        if (steps < o.steps) return 1;
        return -1;
    }


    static int count=0;
    private final int id ;

    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = -1;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        position = initialPosition;
        this.id=++count;

    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id=++count;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        switch (direction) {
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    }
                    if (position.getRow() == 0) {
                        return false;
                    }
                    if (!map.isActive()) return false;
                    position.rowd();
                    this.steps++;
                    score = score + map.hasTreasure(position);
                     map.update(position);

                }
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    }
                    if (position.getRow() == map.getRows()-1) {
                        return false;
                    }
                    if (!map.isActive()) return false;
                    position.rowu();
                    this.steps++;
                    score = score + map.hasTreasure(position);
                    map.update(position);

                }
            }
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    }
                    if (position.getCol() == map.getColumns()-1) {
                        return false;
                    }
                    if (!map.isActive()) return false;
                    position.colu();
                    this.steps++;
                    score = score + map.hasTreasure(position);
                     map.update(position);

                }
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    }
                    if (position.getCol() == 0) {
                        return false;
                    }
                    if (!map.isActive()) return false;
                    position.cold();
                    this.steps++;
                    score = score + map.hasTreasure(position);
                    map.update(position);

                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player P = (Player) player;
        return P.id == this.id;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }
}
