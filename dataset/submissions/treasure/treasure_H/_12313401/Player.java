public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStep;
    public static int counter = 1;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = counter;
        counter++;this.maxStep=-1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStep = maxStepAllowed;
        this.id = counter;
        counter++;
    }

    public Player() {
        this.id = counter;
        counter++;
    }

    public boolean move(Direction direction, int steps) {
        for (int i = steps; i > 0; i--) {
            if (!map.isActive()) {
                return false;
            }
            if (this.steps == maxStep && maxStep >= 0) {
                return false;
            }
            switch (direction) {
                case UP -> {
                    if (position.getRow() > 0) {
                        position.setRow(position.getRow()-1 );
                        this.steps++;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                case DOWN -> {
                    if (position.getRow() < map.getRows()-1) {
                        position.setRow(position.getRow() + 1);
                        this.steps++;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }

                case LEFT -> {
                    if (position.getCol() > 0) {
                        position.setCol(position.getCol() -1);
                        this.steps++;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
                case RIGHT -> {
                    if (position.getCol() < map.getColumns()-1) {
                        position.setCol(position.getCol() + 1);
                        this.steps++;
                        this.score += map.hasTreasure(position);
                        map.update(position);
                    } else return false;
                }
            }
        }
        return true;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        return p.id == this.id;
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
}
