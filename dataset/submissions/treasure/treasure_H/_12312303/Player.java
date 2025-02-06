import java.security.SecureRandom;
import java.util.Random;

public class Player {
    private final int id;
    private static int cnt=0;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        cnt++;
        this.id = cnt;
        this.maxStepAllowed = -1;
        this.position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        cnt++;
        this.id = cnt;
        this.maxStepAllowed = maxStepAllowed;

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

    public boolean move(Direction direction, int steps) {
        if (!this.map.isActive())
            return false;
        if (maxStepAllowed == 0)
            return false;
        switch (direction) {
            case UP:
                for (int i = 1; i <= steps; i++) {
                    if (this.position.getRow() - 1 >= 0) {
                        this.position.setRow(this.position.getRow() - 1);
                        maxStepAllowed--;
                        this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                        if(!map.isActive()){
                            return i==steps;
                        }
                        if (maxStepAllowed == 0) {
                            return i==steps;
                        }
                    }else{
                        return false;
                    }
                }
                return true;
            case DOWN:
                for (int i = 1; i <= steps; i++) {
                    if (this.position.getRow() + 1 < this.map.getRows()) {
                        this.position.setRow(this.position.getRow() + 1);
                        maxStepAllowed--; this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                        if(!map.isActive()){
                            return i==steps;
                        }
                        if (maxStepAllowed == 0) {
                            return i==steps;
                        }
                    }else{
                        return false;
                    }

                }
                return true;
            case LEFT:
                for (int i = 1; i <= steps; i++) {
                    if (this.position.getCol() - 1 >= 0) {
                        this.position.setCol(this.position.getCol() - 1);
                        maxStepAllowed--; this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                        if(!map.isActive()){
                            return i==steps;
                        }
                        if (maxStepAllowed == 0) {
                            return i==steps;
                        }
                    }else{
                        return false;
                    }

                }
                return true;
            case RIGHT:
                for (int i = 1; i <= steps; i++) {
                    if (this.position.getCol() + 1 < this.map.getColumns()) {
                        this.position.setCol(this.position.getCol() + 1);
                        maxStepAllowed--; this.steps++;
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                        if(!map.isActive()){
                            return i==steps;
                        }
                        if (maxStepAllowed == 0) {
                            return i==steps;
                        }
                    }else{
                        return false;
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public boolean equals(Object player) {
        if (player instanceof Player pl) {
            return this.id == pl.id;
        }
        return false;
    }
}
