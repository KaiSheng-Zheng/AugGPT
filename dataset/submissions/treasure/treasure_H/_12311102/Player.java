public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.steps = maxStepAllowed;
        playerId += 1;
        id = playerId;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = this.score + score;
    }
    public int getId() {
        return id;
    }
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public boolean move(Direction direction, int steps) {
        int row = position.getRow();
        int col = position.getCol();
        boolean isInBond = true;
        if (!map.isActive()) {
            isInBond = false;
        }
        else {
            if (steps > this.steps) {
                isInBond = false;
            }
            else {
                if (direction.equals(Direction.UP)) {
                    row -= steps;
                    if (row < 0) {
                        isInBond = false;
                        row = 0;
                    }
                }
                else if (direction.equals(Direction.DOWN)) {
                    row += steps;
                    if (row > map.getRows()) {
                        isInBond = false;
                        row = map.getRows();
                    }
                }
                else if (direction.equals(Direction.LEFT)) {
                    col -= steps;
                    if (col < 0) {
                        isInBond = false;
                        col = 0;
                    }
                }
                else {
                    col += steps;
                    if (col > map.getColumns()) {
                        isInBond = false;
                        col = map.getColumns();
                    }
                }
            }
        }
        position = new Position(row, col);
        return isInBond;
    }
    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.equals(id);
    }
}