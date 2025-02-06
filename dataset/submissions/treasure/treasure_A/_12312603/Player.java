public class Player {
    private int id;
    private int score = 0;
    private int step = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed = -1;

    public Player(Map map, Position initialPos) {
        this.map = map;
        this.position = initialPos;
    }

    public Player(Map map, Position initialPos, int maxStepAllowed) {
        this.map = map;
        this.position = initialPos;
        this.maxStepAllowed = maxStepAllowed;
    }

    public void setId(int id) {
        this.id = id + 1;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public boolean move(Direction direction, int steps) {
        Position pos = this.position;
        if (map.isActive() == false) {
            return false;
        }
        if (maxStepAllowed == -1 || maxStepAllowed >= step + steps) {
            switch (direction) {
                case UP:
                    if (pos.getRow() - steps < 0) {
                        for (int i = pos.getRow(); i > -1; i--) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getRow() - i;
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += pos.getRow();
                        pos.setRow(0);
                        return false;
                    } else {
                        for (int i = pos.getRow(); i > pos.getRow() - steps - 1; i--) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getRow() - i;
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += steps;
                        pos.setRow(pos.getRow() - steps);
                        return true;
                    }
                case DOWN:
                    if (pos.getRow() + steps > map.getRows() - 1) {
                        for (int i = pos.getRow(); i < map.getRows(); i++) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getRow();
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += map.getRows() - 1 - pos.getRow();
                        pos.setRow(map.getRows() - 1);
                        return false;
                    } else {
                        for (int i = pos.getRow(); i < pos.getRow() + steps + 1; i++) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getRow();
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += steps;
                        pos.setRow(pos.getRow() + steps);
                        return true;
                    }
                case LEFT:
                    if (pos.getCol() - steps < 0) {
                        for (int i = pos.getCol(); i > -1; i--) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getCol() - i;
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += pos.getCol();
                        pos.setCol(0);
                        return false;
                    } else {
                        for (int i = pos.getCol(); i > pos.getCol() - steps - 1; i--) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getCol() - i;
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += steps;
                        pos.setCol(pos.getCol() - steps);
                        return true;
                    }
                case RIGHT:
                    if (pos.getCol() + steps > map.getColumns() - 1) {
                        for (int i = pos.getCol(); i < map.getColumns(); i++) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getCol();
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += map.getColumns() - 1 - pos.getCol();
                        pos.setCol(map.getColumns() - 1);
                        return false;
                    } else {
                        for (int i = pos.getCol(); i < pos.getCol() + steps + 1; i++) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getCol();
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += steps;
                        pos.setCol(pos.getCol() + steps);
                        return true;
                    }
            }
        } else if (maxStepAllowed != -1) {
            int mior = maxStepAllowed - step;
            switch (direction) {
                case UP:
                    if (mior < pos.getRow()) {
                        for (int i = pos.getRow(); i > pos.getRow() - mior - 1; i--) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getRow() - i;
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += mior;
                        pos.setRow(pos.getRow() - mior);
                        return false;
                    } else {
                        for (int i = pos.getRow(); i > -1; i--) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getRow() - i;
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += pos.getRow();
                        pos.setRow(0);
                        return false;
                    }
                case DOWN:
                    if (mior < map.getRows() - 1 - pos.getRow()) {
                        for (int i = pos.getRow(); i < pos.getRow() + mior + 1; i++) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getRow();
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += mior;
                        pos.setRow(pos.getRow() + mior);
                        return false;
                    } else {
                        for (int i = pos.getRow(); i < map.getRows(); i++) {
                            Position pos2 = new Position(i, pos.getCol());
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getRow();
                                    pos.setRow(i);
                                    return false;
                                }
                            }
                        }
                        step += map.getRows() - 1 - pos.getRow();
                        pos.setRow(map.getRows() - 1);
                        return false;

                    }
                case LEFT:
                    if (mior < pos.getCol()) {
                        for (int i = pos.getCol(); i > pos.getCol() - mior - 1; i--) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getCol() - i;
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += mior;
                        pos.setCol(pos.getCol() - mior);
                        return false;
                    } else {
                        for (int i = pos.getCol(); i > -1; i--) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += pos.getCol() - i;
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += pos.getCol();
                        pos.setCol(0);
                        return false;
                    }
                case RIGHT:
                    if (mior < map.getColumns() - 1 - pos.getCol()) {
                        for (int i = pos.getCol(); i < pos.getCol() + mior + 1; i++) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getCol();
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += mior;
                        pos.setCol(pos.getCol() + mior);
                        return false;
                    } else {
                        for (int i = pos.getCol(); i < map.getColumns(); i++) {
                            Position pos2 = new Position(pos.getRow(), i);
                            int s = map.hasTreasure(pos2);
                            if (s != 0) {
                                addScore(s);
                                map.update(pos2);
                                if (map.isActive() == false) {
                                    step += i - pos.getCol();
                                    pos.setCol(i);
                                    return false;
                                }
                            }
                        }
                        step += map.getColumns() - 1 - pos.getCol();
                        pos.setCol(map.getColumns() - 1);
                        return false;
                    }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object player) {
        Player other = (Player) player;
        if (this.getId() == other.getId()) {
            return true;
        } else {
            return false;
        }
    }

    public int getSteps() {
        return step;
    }

    public Position getPosition() {
        return position;
    }

    public int getmaxStep() {
        return maxStepAllowed;
    }
}
