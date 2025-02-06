import java.util.*;
public class Player {

    public int getId() {
        return id;
    }

    public boolean equals(Object player) {
        boolean y;
        Player p = (Player) player;
        if (this.id != p.id) {
            y = false;
        } else {
            y = true;
        }
        return y;
    }

    private final int id;

    public int getScore() {
        return score;
    }

    private int score = 0;

    public int getSteps() {
        return steps;
    }

    private int steps = 0;

    public Position getPosition() {
        return position;
    }

    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position=initialPosition;
        id = Map.number();
        step = 1000000000;
        score = 0;
    }

    int step;

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position=initialPosition;
        id = Map.number();
        step = maxStepAllowed;
        score = 0;
    }
// for(;;)
    public boolean move(Direction direction, int steps) {
        boolean a = true;

        for (int i=1 ;i <= steps; i++) {
            a = false;
            if (map.isActive()) {
                if (direction == Direction.DOWN) {
                    if (position.getRow() < Map.heng) {
                        if (this.steps < step) {
                            this.steps++;
                            position.setRow(position.getRow() + 1);
                            score = score + Treasure.xunBaoTu[position.getRow()][position.getCol()];
                            map.update(position);
                            map.isActive();
                            a=true;
                        }
                    }
                }
                if (direction == Direction.UP) {
                    if (position.getRow() > 0) {
                        if (this.steps < step) {
                            this.steps++;
                            position.setRow(position.getRow() - 1);
                            score =score + Treasure.xunBaoTu[position.getRow()][position.getCol()];
                            map.update(position);
                            map.isActive();
                            a = true;
                        }

                    }
                }
                if (direction == Direction.LEFT) {
                    if (position.getCol() > 0) {
                        if (this.steps < step) {
                            this.steps++;
                            position.setCol(position.getCol() - 1);
                            score = score + Treasure.xunBaoTu[position.getRow()][position.getCol()];
                            map.update(position);
                            map.isActive();
                            a = true;
                        }

                    }
                }
                if (direction == Direction.RIGHT) {
                    if (position.getCol() < Map.shu) {
                        if (this.steps < step) {
                            this.steps++;
                            position.setCol(position.getCol() + 1);
                            score = score + Treasure.xunBaoTu[position.getRow()][position.getCol()];
                            map.update(position);
                            map.isActive();
                            a = true;
                        }
                    }
                }
            }
        }

        return a;
    }
}


