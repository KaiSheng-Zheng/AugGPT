public class Player {
    private final int id = playerId++;
    private int score;
    private int maxstepsAllowed = 9999;
    private Position position;
    private Map map;
    private int intial = 9999;

    private int steps;

    private static int playerId = 1;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxstepsAllowed = maxStepAllowed;
        this.intial = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (maxstepsAllowed == 0) {
            return false;
        }
        if (direction == Direction.UP) {
            if (steps <= position.getRow()) {
                if (maxstepsAllowed >= steps) {
                    for (int i = position.getRow() - steps; i < position.getRow(); i++) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=i-position.getRow()+steps;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow() - steps, position.getCol());
                    maxstepsAllowed -= steps;
                    return true;
                } else {
                    for (int i = position.getRow() - maxstepsAllowed; i < position.getRow(); i++) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=i-position.getRow()+maxstepsAllowed;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow() - steps, position.getCol());
                    maxstepsAllowed = 0;
                    return false;
                }
            } else {
                if (maxstepsAllowed>= position.getRow()) {
                    for (int i = 0; i < position.getRow(); i++) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=i;
                            return false;
                        }
                    }
                    maxstepsAllowed -= position.getRow();
                    this.position = new Position(0, position.getCol());
                    return false;
                }else {
                    for (int i = 0; i < position.getRow()-maxstepsAllowed; i++) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=i;
                            return false;
                        }
                    }
                    maxstepsAllowed =0;
                    this.position = new Position(position.getRow()-maxstepsAllowed, position.getCol());
                    return false;
                }
            }
        }
        if (direction == Direction.DOWN) {
            if (steps <= map.getRows() - 1 - position.getRow()) {
                if (maxstepsAllowed >= steps) {
                    for (int i = position.getRow() + steps; i > position.getRow(); i--) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));

                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=position.getRow()+steps-i;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow() + steps, position.getCol());
                    maxstepsAllowed -= steps;
                    return true;
                } else {
                    for (int i = position.getRow() + maxstepsAllowed; i > position.getRow(); i--) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=position.getRow()+maxstepsAllowed-i;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow() + maxstepsAllowed, position.getCol());
                    maxstepsAllowed = 0;
                    return false;
                }
            } else {
                if (maxstepsAllowed>=map.getRows()-1-position.getRow()) {
                    for (int i = map.getRows() - 1; i > position.getRow(); i--) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-= map.getRows()-1-i;
                            return false;
                        }
                    }
                    maxstepsAllowed -= map.getRows() - 1 - position.getRow();
                    this.position = new Position(map.getRows() - 1, position.getCol());
                    return false;
                }else {
                    for (int i = map.getRows() - 1; i > position.getRow()+maxstepsAllowed; i--) {
                        score += map.hasTreasure2(new Position(i, position.getCol()));
                        if (!map.isActive()) {
                            this.position=new Position(i,position.getCol());
                            maxstepsAllowed-=map.getRows()-1-i;
                            return false;
                        }
                    }
                    maxstepsAllowed =0;
                    this.position = new Position(position.getRow()+maxstepsAllowed, position.getCol());
                    return false;
                }
            }
        }
        if (direction == Direction.LEFT) {
            if (steps <= position.getCol()) {
                if (maxstepsAllowed >= steps) {
                    for (int i = position.getCol() - steps; i < position.getCol(); i++) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=i-position.getCol()+steps;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow(), position.getCol() - steps);
                    maxstepsAllowed -= steps;
                    return true;
                } else {
                    for (int i = position.getCol() - maxstepsAllowed; i < position.getCol(); i++) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=i-position.getCol()+maxstepsAllowed;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow(), position.getCol() - maxstepsAllowed);
                    maxstepsAllowed =0;
                    return false;
                }
            } else {
                if (maxstepsAllowed>=position.getCol()) {
                    for (int i = 0; i < position.getCol(); i++) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=i;
                            return false;
                        }
                    }
                    maxstepsAllowed -= position.getCol();
                    this.position = new Position(position.getRow(), 0);
                    return false;
                }else {
                    for (int i = position.getCol()-maxstepsAllowed; i < position.getCol(); i++) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=i-position.getCol()+maxstepsAllowed;
                            return false;
                        }
                    }
                    maxstepsAllowed -= position.getCol();
                    this.position = new Position(position.getRow(), position.getCol()-maxstepsAllowed);
                    return false;

                }
            }
        }
        if (direction == Direction.RIGHT) {
            if (steps <= map.getColumns() - 1 - position.getCol()) {
                if (maxstepsAllowed >= steps) {
                    for (int i = position.getCol() + steps; i > position.getCol(); i--) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=position.getCol()+steps-i;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow(), position.getCol() + steps);
                    maxstepsAllowed -= steps;
                    return true;
                }else {
                    for (int i = position.getCol() + maxstepsAllowed; i > position.getCol(); i--) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=position.getCol()+maxstepsAllowed-i;
                            return false;
                        }
                    }
                    this.position = new Position(position.getRow(), position.getCol() + maxstepsAllowed);
                    maxstepsAllowed =0;
                    return false;
                }
            } else {
                if (maxstepsAllowed>=map.getColumns()-1-position.getCol()) {
                    for (int i = map.getColumns() - 1; i > position.getCol(); i--) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=map.getColumns()-1-i;
                            return false;
                        }
                    }
                    maxstepsAllowed -= map.getColumns() - 1 - position.getCol();
                    this.position = new Position(position.getRow(), map.getColumns() - 1);
                    return false;
                }else {
                    for (int i = position.getCol()+maxstepsAllowed; i > position.getCol(); i--) {
                        score += map.hasTreasure2(new Position(position.getRow(), i));
                        if (!map.isActive()) {
                            this.position=new Position(position.getRow(),i);
                            maxstepsAllowed-=position.getCol()+maxstepsAllowed-i;
                            return false;
                        }
                    }
                    maxstepsAllowed -= map.getColumns() - 1 - position.getCol();
                    this.position = new Position(position.getRow(), position.getCol()+maxstepsAllowed);
                    return false;

                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.getId() == id;
    }


    public int getId() {
        return this.id;
    }

    public int getScore() {
        return this.score;
    }

    public Position getPosition() {
        return this.position;
    }

    public int getSteps() {
        this.steps=this.intial - this.maxstepsAllowed;
        return steps;
    }

}
