import java.util.IllegalFormatCodePointException;

public class Player {
    private int id;
    private int score;
    private int steps;
    private int maxStepAllowed = 999999;
    private Position position;
    private Map map;

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

    public static int count = 0;

    public Player(Map map,Position position) {
        this.position = position;
        this.map = map;
        this.id = ++ count;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++count;
    }

    public boolean move(Direction direction, int steps) {
        for (int i = 0; i < steps; i++) {
            if (!map.isActive()) {
                return false;
            }
            else {
                if (this.steps <this.maxStepAllowed) {
                    switch (direction) {
                        case UP -> {
                            if (this.position.getRow() - 1 >=0) {
                                this.position.setRow(this.position.getRow() - 1);
                                this.steps ++;
                            } else {
                                this.position.setRow(this.position.getRow());
                                return false;
                            }
                        }
                        case DOWN -> {
                            if (this.position.getRow() +1 <= map.getRows()-1) {
                                this.position.setRow(this.position.getRow() + 1);
                                this.steps ++;
                            } else {
                                this.position.setRow(this.position.getRow());
                                return false;
                            }
                        }
                        case LEFT -> {
                            if (this.position.getCol() -1 >= 0) {
                                this.position.setCol(this.position.getCol()-1);
                                this.steps ++;
                            } else {
                                this.position.setCol(this.position.getCol());
                                return false;
                            }
                        }
                        case RIGHT -> {
                            if (this.position.getCol() + 1 <= map.getColumns()-1) {
                                this.position.setCol(this.position.getCol() + 1);
                                this.steps ++;
                            } else {
                                this.position.setCol(this.position.getCol());
                                return false;
                            }
                        }
                    }
                    if (map.hasTreasure(this.position) > 0) {
                        this.score += map.hasTreasure(this.position);
                        map.update(this.position);
                        if (!map.isActive()) {
                            return false;
                        }
                    }
                }
                else{
                    return false;
                }
            }
        }
        if (!map.isActive()) {
            return false;
        }
        else{
            return true;
        }
    }


    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.getId();
    }
}
