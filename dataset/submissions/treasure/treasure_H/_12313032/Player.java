import java.util.ArrayList;
import java.util.stream.StreamSupport;

public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int count = 0;
    private int maxStepAllowed;
    //private static ArrayList<Player> players = new ArrayList<>();

    public Player(Map map, Position initialPos) {
        this.map = map;
        this.position = initialPos;
        this.id = ++count;
        this.maxStepAllowed = -1;
        //players.add(this);
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.map = map;
        this.position = initialPos;
        this.id = ++count;
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
        switch (direction) {
            case LEFT:
                for (int i = 0; i < steps; i++) {
                    if ((maxStepAllowed != -1 && this.steps < maxStepAllowed && map.isActive()) || (maxStepAllowed == -1 && map.isActive())) {
                        if (position.getCol() - 1 >= 0) {
                            position.setCol(position.getCol() - 1);
                            this.steps++;
                            for (Treasure t : map.getTreasuress()) {
                                if (t.getPosition().equals(this.position)) {
                                    ;
                                    this.score += t.getScore();
                                    map.update(t.getPosition());
                                    break;
                                }
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            case RIGHT:
                for (int i = 0; i < steps; i++) {
                    if ((maxStepAllowed != -1 && this.steps < maxStepAllowed && map.isActive()) || (maxStepAllowed == -1 && map.isActive())) {
                        if (position.getCol() + 1 <= map.getColumns() - 1) {
                            position.setCol(position.getCol() + 1);
                            this.steps++;
                            for (Treasure t : map.getTreasuress()) {
                                if (t.getPosition().equals(this.position)) {
                                    this.score += t.getScore();
                                    map.update(t.getPosition());
                                    break;
                                }
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            case UP:
                for (int i = 0; i < steps; i++) {
                    if ((maxStepAllowed != -1 && this.steps < maxStepAllowed && map.isActive()) || (maxStepAllowed == -1 && map.isActive())) {
                        if (position.getRow() - 1 >= 0) {
                            position.setRow(position.getRow() - 1);
                            this.steps++;
                            for (Treasure t : map.getTreasuress()) {
                                if (t.getPosition().equals(this.position)) {
                                    ;
                                    this.score += t.getScore();
                                    map.update(t.getPosition());
                                    break;
                                }
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
            case DOWN:
                for (int i = 0; i < steps; i++) {
                    if ((maxStepAllowed != -1 && this.steps < maxStepAllowed && map.isActive()) || (maxStepAllowed == -1 && map.isActive())) {
                        if (position.getRow() + 1 <= map.getRows() - 1) {
                            position.setRow(position.getRow() + 1);
                            this.steps++;
                            for (Treasure t : map.getTreasuress()) {
                                if (t.getPosition().equals(this.position)) {
                                    ;
                                    this.score += t.getScore();
                                    map.update(t.getPosition());
                                    break;
                                }
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                return true;
        }
        return true;
    }
    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.id;
    }}


