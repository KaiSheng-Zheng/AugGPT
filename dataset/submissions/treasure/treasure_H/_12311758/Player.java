public class Player {
    private final int id;
    private int score;
    private int steps;
    private Player player;
    private Position position;
    private Map map;
    private static int Nextid = 0;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = Nextid++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = Nextid++;
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

    public Position getPosition() {
        return position;
    }

    public int getSteps() {
        return steps;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        int r = position.getRow();
        int c = position.getCol();
        boolean judgement = true;
        if (!map.isActive()) {
            return false;
        } else {
            if (maxStepAllowed != 0) {
                if (direction == Direction.UP) {
                    if (steps + this.steps <= maxStepAllowed) {
                        r -= steps;
                        if (r >= 0 && r <= map.getRows() - 1) {
                            judgement = true;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() - i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setRow(r);
                            this.steps += steps;
                        } else if (r < 0) {
                            judgement = false;
                            steps = position.getRow();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() - i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (position.getRow());
                            position.setRow(0);

                        }
                    } else {
                        steps = (maxStepAllowed - this.steps);
                        r -= steps;
                        if (r >= 0 && r <= map.getRows() - 1) {
                            judgement = false;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() - i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setRow(r);
                            this.steps += steps;
                        } else if (r < 0) {
                            judgement = false;
                            steps = position.getRow();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() - i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (position.getRow());
                            position.setRow(0);

                        }
                    }
                }
                if (direction == Direction.DOWN) {
                    if (steps + this.steps <= maxStepAllowed) {
                        r += steps;
                        if (r >= 0 && r <= map.getRows() - 1) {
                            judgement = true;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() + i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setRow(r);
                            this.steps += steps;
                        } else if (r > map.getRows() - 1) {
                            judgement = false;
                            steps = map.getRows() - position.getRow();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() + i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (map.getRows() - position.getRow()-1);
                            position.setRow(map.getRows() - 1);

                        }
                    } else {
                        steps = maxStepAllowed - this.steps;
                        r += steps;
                        if (r >= 0 && r <= map.getRows() - 1) {
                            judgement = false;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() + i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setRow(r);
                            this.steps += steps;
                        } else if (r > map.getRows() - 1) {
                            judgement = false;
                            steps = map.getRows() - position.getRow();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow() + i, position.getCol());
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (map.getRows() - position.getRow()-1);
                            position.setRow(map.getRows() - 1);

                        }
                    }
                }
                if (direction == Direction.LEFT) {
                    if (steps + this.steps <= maxStepAllowed) {
                        c -= steps;
                        if (c >= 0 && c <= map.getColumns() - 1) {
                            judgement = true;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() - i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setCol(c);
                            this.steps += steps;
                        } else if (c < 0) {
                            judgement = false;
                            steps = position.getCol();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() - i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (position.getCol());
                            position.setCol(0);

                        }
                    } else {
                        steps = maxStepAllowed - this.steps;
                        c -= steps;
                        if (c >= 0 && c <= map.getColumns() - 1) {
                            judgement = false;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() - i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setCol(c);
                            this.steps += steps;
                        } else if (c < 0) {
                            judgement = false;
                            steps = position.getCol();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() - i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (position.getCol());
                            position.setCol(0);

                        }
                    }
                }
                if (direction == Direction.RIGHT) {
                    if (steps + this.steps <= maxStepAllowed) {
                        c += steps;
                        if (c >= 0 && c <= map.getColumns() - 1) {
                            judgement = true;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() + i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setCol(c);
                            this.steps += steps;
                        } else if (c > map.getColumns() - 1) {
                            judgement = false;
                            steps = map.getColumns() - position.getCol();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() + i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (map.getColumns() - position.getCol()-1);
                            position.setCol(map.getColumns() - 1);

                        }
                    } else {
                        steps = maxStepAllowed - this.steps;
                        c += steps;
                        if (c >= 0 && c <= map.getColumns() - 1) {
                            judgement = false;
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() + i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            position.setCol(c);
                            this.steps += steps;
                        } else if (c > map.getColumns() - 1) {
                            judgement = false;
                            steps = map.getColumns() - position.getCol();
                            for (int i = 1; i <= steps; i++) {
                                Position newPosition = new Position(position.getRow(), position.getCol() + i);
                                this.score += map.hasTreasure(newPosition);
                                map.update(newPosition);
                            }
                            this.steps += (map.getColumns() - position.getCol()-1);
                            position.setCol(map.getColumns() - 1);

                        }
                    }
                }
            } else {
                if (direction == Direction.UP) {
                    r -= steps;
                    if (r >= 0 && r <= map.getRows() - 1) {
                        judgement = true;
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow() - i, position.getCol());
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        position.setRow(r);
                        this.steps += steps;
                    } else if (r < 0) {
                        judgement = false;
                        steps = position.getRow();
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow() - i, position.getCol());
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        this.steps += (position.getRow());
                        position.setRow(0);

                    }
                }
                if (direction == Direction.DOWN) {

                    r += steps;
                    if (r >= 0 && r <= map.getRows() - 1) {
                        judgement = true;
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow() + i, position.getCol());
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        position.setRow(r);
                        this.steps += steps;
                    } else if (r > map.getRows() - 1) {
                        judgement = false;
                        steps = map.getRows() - position.getRow();
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow() + i, position.getCol());
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        this.steps += (map.getRows() - position.getRow()-1);
                        position.setRow(map.getRows() - 1);

                    }
                }
                if (direction == Direction.LEFT) {

                    c -= steps;
                    if (c >= 0 && c <= map.getColumns() - 1) {
                        judgement = true;
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow(), position.getCol() - i);
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        position.setCol(c);
                        this.steps += steps;
                    } else if (c < 0) {
                        judgement = false;
                        steps = position.getCol();
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow(), position.getCol() - i);
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        this.steps += (position.getCol());
                        position.setCol(0);

                    }
                }
                if (direction == Direction.RIGHT) {
                    c += steps;
                    if (c >= 0 && c <= map.getColumns() - 1) {
                        judgement = true;
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow(), position.getCol() + i);
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        position.setCol(c);
                        this.steps += steps;
                    } else if (c > map.getColumns() - 1) {
                        judgement = false;
                        steps = map.getColumns() - position.getCol();
                        for (int i = 1; i <= steps; i++) {
                            Position newPosition = new Position(position.getRow(), position.getCol() + i);
                            this.score += map.hasTreasure(newPosition);
                            map.update(newPosition);
                        }
                        this.steps += (map.getColumns() - position.getCol()-1);
                        position.setCol(map.getColumns() - 1);

                    }
                }
            }
        }
        return judgement;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        if (p.getId() == ((Player) player).getId()) {
            return true;
        } else return true;
    }
}
