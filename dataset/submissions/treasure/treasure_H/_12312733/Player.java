public class Player {
    public Player(int id, int score, int steps, Position position, Map map) {
        this.id = id;
        this.score = score;
        this.steps = steps;
        this.position = position;
        this.map = map;
    }

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    public static int count = 0;

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    private int maxStepAllowed;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Player.count = count;
    }


    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = Integer.MAX_VALUE;
        this.id = ++count;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++count;
    }

    int ste = 0;

    public boolean move(Direction direction, int steps) {
        if (!map.isActive() || maxStepAllowed == 0) {
            return false;
        }
        if (direction == Direction.UP && steps > position.getRow()) {
            ste--;
        }
        if (direction == Direction.DOWN && steps > map.getRows() - position.getRow() - 1) {
            ste--;
        }
        if (direction == Direction.LEFT && steps > position.getCol()) {
            ste--;
        }
        if (direction == Direction.RIGHT && steps > map.getColumns() - position.getCol() - 1) {
            ste--;
        }
        int step = steps;
        for (int i = 0; i < steps; i++) {
            if (direction == Direction.UP) {
                position.setRow(position.getRow() - 1);
                ste++;
                setSteps(ste);
                step--;
                if (map.hasTreasure(getPosition()) != 0) {
                    setScore(getScore() + map.hasTreasure(getPosition()));
                    map.update(getPosition());
                    if (step == 0) {
                        return true;
                    }
                    if (!map.isActive() && step > 0) {
                        ste--;
                        setSteps(ste);
                        return false;
                    } else if (!map.isActive()) {
                        return false;
                    }
                }
                if (position.getRow() < 0) {
                    position.setRow(position.getRow() + 1);
                    return false;
                }
                if (steps > position.getRow() && step > 0 && ste == maxStepAllowed - 1) {
                    ste++;
                    setSteps(ste);
                }
                if (ste >= maxStepAllowed) {
                    return false;
                }
            } else if (direction == Direction.DOWN) {
                position.setRow(position.getRow() + 1);
                ste++;
                setSteps(ste);
                step--;
                if (map.hasTreasure(getPosition()) != 0) {
                    setScore(getScore() + map.hasTreasure(getPosition()));
                    map.update(getPosition());
                    if (step == 0) {
                        return true;
                    }
                    if (!map.isActive() && step > 0) {
                        ste--;
                        setSteps(ste);
                        return false;
                    } else if (!map.isActive()) {
                        return false;
                    }
                }
                if (position.getRow() > map.getRows() - 1) {
                    position.setRow(position.getRow() - 1);
                    return false;
                }
                if (steps > map.getRows() - position.getRow() - 1 && step > 0 && ste == maxStepAllowed - 1) {
                    ste++;
                    setSteps(ste);
                }
                if (ste >= maxStepAllowed) {
                    return false;
                }
            } else if (direction == Direction.LEFT) {
                position.setCol(position.getCol() - 1);
                ste++;
                setSteps(ste);
                step--;
                if (map.hasTreasure(getPosition()) != 0) {
                    setScore(getScore() + map.hasTreasure(getPosition()));
                    map.update(getPosition());
                    if (step == 0) {
                        return true;
                    }
                    if (!map.isActive() && step > 0) {
                        ste--;
                        setSteps(ste);
                        return false;
                    } else if (!map.isActive()) {
                        return false;
                    }
                }
                if (position.getCol() < 0) {
                    position.setCol(position.getCol() + 1);
                    return false;
                }
                if (steps > position.getCol() && step > 0 && ste == maxStepAllowed - 1) {
                    ste++;
                    setSteps(ste);
                }
                if (ste >= maxStepAllowed) {
                    return false;
                }
            } else {
                position.setCol(position.getCol() + 1);
                ste++;
                setSteps(ste);
                step--;
                if (map.hasTreasure(getPosition()) != 0) {
                    setScore(getScore() + map.hasTreasure(getPosition()));
                    map.update(getPosition());
                    if (step == 0) {
                        return true;
                    }
                    if (!map.isActive() && step > 0) {
                        ste--;
                        setSteps(ste);
                        return false;
                    } else if (!map.isActive()) {
                        return false;
                    }
                }
                if (position.getCol() > map.getColumns() - 1) {
                    position.setCol(position.getCol() - 1);
                    return false;
                }
                if (steps > map.getColumns() - position.getCol() - 1 && step > 0 && ste == maxStepAllowed - 1) {
                    ste++;
                    setSteps(ste);
                }
                if (ste >= maxStepAllowed) {
                    return false;
                }
            }
        }
        return (step == 0);
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return getId() == p.getId();
    }

}
