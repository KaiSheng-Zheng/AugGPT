public class Player {
    private final int id;
    private int score;
    private int steps;
    private int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Position position;
    private Map map;
    private static int count;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;
        this.score = 0;
        this.steps = 0;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.position = initialPosition;
        this.map = map;
        this.steps = 0;
        this.score = 0;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        Position nextposition;
        for (int i = 0; i < steps; i++) {
            nextposition = new Position(this.position.getRow() + dir[direction.ordinal()][0],
                    this.position.getCol() + dir[direction.ordinal()][1]);
            if (nextposition.getRow() < 0 || nextposition.getRow() >= map.getRows() ||
                    nextposition.getCol() < 0 || nextposition.getCol() >= map.getColumns()) {
                return false;
            }
            if (!map.isActive()) {
                return false;
            }
            if (this.steps >= maxStepAllowed) {
                return false;
            }
            int score = map.hasTreasure(nextposition);
            if (score > 0) {
                this.score += score;
                map.update(nextposition);
            }
            this.steps++;
            this.position = nextposition;
        }
        return true;
    }




    /*public boolean move(Direction direction, int steps) {
        if (map.isActive() == true) {
            if (this.steps <= maxStepAllowed) {
                if (direction == Direction.UP) {
                    if (position.getRow() - steps >= 0) {
                        for (int i = position.getRow(); i >= position.getRow() - steps; i--) {
                            Position p = new Position(i, position.getCol());
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }

                        }
                        this.steps += steps;
                        this.position.setRow(position.getRow() - steps);
                        return true;
                    } else if (position.getRow() - steps < 0 && position.getRow() != 0) {
                        for (int i = position.getRow(); i >= 0; i--) {
                            Position p = new Position(i, position.getCol());
                            if (map.hasTreasure(p) > 0) {
                                this.score += this.map.hasTreasure(p);
                                this.map.update(p);
                            }
                        }
                        this.steps += position.getRow() - 0;
                        this.position.setRow(0);
                        return false;
                    } else return false;

                } else if (direction == Direction.DOWN) {
                    if (position.getRow() + steps <= map.getRows() - 1) {
                        for (int i = position.getRow(); i <= position.getRow() + steps; i++) {
                            Position p = new Position(i, position.getCol());
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }

                        }
                        this.steps += steps;
                        this.position.setRow(position.getRow() + steps);
                        return true;

                    } else if (position.getRow() + steps > map.getRows() - 1 && position.getRow() != 0) {
                        for (int i = position.getRow(); i <= map.getRows() - 1; i++) {
                            Position p = new Position(i, position.getCol());
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }
                        }
                        this.steps += map.getRows() - 1 - position.getRow();
                        this.position.setRow(map.getRows() - 1);
                        return false;
                    } else return false;
                } else if (direction == Direction.LEFT) {
                    if (position.getCol() - steps >= 0) {
                        for (int i = position.getCol(); i >= position.getCol() - steps; i--) {
                            Position p = new Position(position.getRow(), i);
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }

                        }
                        this.steps += steps;
                        this.position.setCol(position.getCol() - steps);
                        return true;

                    } else if (position.getCol() - steps < 0 && position.getCol() != 0) {
                        for (int i = position.getCol(); i >= 0; i--) {
                            Position p = new Position(position.getRow(), i);
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }
                        }
                        this.steps += position.getCol() - 0;
                        this.position.setCol(0);
                        return false;
                    } else return false;
                } else if (direction == Direction.RIGHT) {
                    if (position.getCol() + steps <= map.getColumns() - 1) {
                        for (int i = position.getCol(); i <= position.getCol() + steps; i++) {
                            Position p = new Position(position.getRow(), i);
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }

                        }
                        this.steps += steps;
                        this.position.setCol(position.getCol() + steps);
                        return true;

                    } else if (position.getCol() + steps > map.getColumns() - 1 && position.getCol() != 0) {
                        for (int i = position.getCol(); i <= map.getColumns() - 1; i++) {
                            Position p = new Position(position.getRow(), i);
                            if (map.hasTreasure(p) > 0) {
                                this.score += map.hasTreasure(p);
                                map.update(p);
                            }
                        }
                        this.steps += map.getColumns() - 1 - position.getCol();
                        this.position.setCol(map.getColumns() - 1);
                        return false;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }*/


    public boolean equals(Object player) {
        Player p = (Player) player;
        return this.id == p.id;
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
}
