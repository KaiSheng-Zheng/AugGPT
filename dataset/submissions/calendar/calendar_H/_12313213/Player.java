public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int count;
    private int maxStepAllowed;
    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = -1;
        this.id = ++count;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ++count;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
    }

    public boolean move(Direction direction, int steps){

        Position pos = position;

        switch (direction){
            case UP -> {
                pos.setRow(position.getRow()-steps);
            }
            case DOWN -> {
                pos.setRow(position.getRow()+steps);
            }
            case LEFT -> {
                pos.setRow(position.getCol()-steps);
            }
            case RIGHT -> {
                pos.setRow(position.getCol()+steps);
            }
        }

        if (!map.isActive()){
            return false;
        }else if (steps == maxStepAllowed){
            return false;
        }else if (pos.getRow()<0){
            pos.setRow(0);
            return false;
        }else if (pos.getRow()>map.getRows()){
            pos.setRow(map.getRows());
            return false;
        } else if (pos.getCol()<0) {
            pos.setCol(0);
            return false;
        } else if (pos.getCol()>map.getColumns()) {
            pos.setCol(map.getColumns());
            return false;
        }else {
            setPosition(pos);
            return true;
        }
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        return (p.getId() == getId());

    }
}
