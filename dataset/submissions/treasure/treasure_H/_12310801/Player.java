public class Player {
    private final int id;
    private int score;
    private static int tot;
    private int steps, maxSteps;
    private final boolean infSteps;
    private Position position;
    private Map map;
    private boolean checkIn(int row, int col) {
        if(row < 0 || col < 0) return false;
        return row < map.getRows() && col < map.getColumns();
    }
    public Player(Map map, Position initialPosition) {
        id = ++ tot;
        this.map = map;
        position = new Position(initialPosition.getRow(), initialPosition.getCol());
        infSteps = true;
        maxSteps = 1;
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

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        id = ++ tot;
        this.map = map;
        position = new Position(initialPosition.getRow(), initialPosition.getCol());
        maxSteps = maxStepAllowed;
        infSteps = false;
    }
    public void getPos() {
        int v = map.hasTreasure(position);
        if(v != 0) {
            score += v;
            map.update(position);
        }
    }
    public boolean move(Direction direction, int steps) {
        boolean flag = false;
        for(int i = 0, nextRow = 0, nextCol = 0; i < steps && maxSteps > 0 && map.isActive(); i ++) {
            switch (direction) {
                case UP : {
                    nextRow = position.getRow() - 1;
                    nextCol = position.getCol();
                    break;
                }
                case DOWN : {
                    nextRow = position.getRow() + 1;
                    nextCol = position.getCol();
                    break;
                }
                case LEFT : {
                    nextRow = position.getRow();
                    nextCol = position.getCol() - 1;
                    break;
                }
                case RIGHT : {
                    nextRow = position.getRow();
                    nextCol = position.getCol() + 1;
                    break;

                }
            }
            if(!checkIn(nextRow, nextCol)) break;
            position.setRow(nextRow);
            position.setCol(nextCol);
            score += map.hasTreasure(position);
            map.update(position);
            this.steps ++;
            if(!infSteps) {
                maxSteps--;
            }
            if(i == steps - 1) flag = true;
        }
        return flag;
    }
    public int getId() {
        return id;
    }

    public boolean equals(Object player) {
        Player tmp = (Player) player;
        return id == tmp.getId();
    }
}
