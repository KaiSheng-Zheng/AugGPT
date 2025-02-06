public class Player implements Comparable<Player> {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count = 0;
    private Treasure treasure;

    public Player(Map map, Position position ) {
        this.position = position;
        this.map = map;
        this.id = ++count;
        this.maxStepAllowed = Integer.MAX_VALUE;

    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++count;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()){
            return false;
        }
        if (map.isActive()) {

            switch (direction) {
                case UP:
                    if (map.isActive()) {
                        for (int i = 1; i <= steps; i++) {
                            this.position.setRow(this.position.getRow() - i);
                            map.hasTreasure(this.position);
                                map.update(this.position);

                        }
                        if (this.position.getRow() - steps < 0) {
                            this.position.setRow(0);
                            return false;
                        }
                    } else
                        return true;
                case DOWN:

                    if (map.isActive()) {
                        for (int i = 1; i <= steps; i++) {
                            this.position.setRow(this.position.getRow() + i);
                            map.hasTreasure(this.position);
                                map.update(this.position);

                        }

                        if (this.position.getRow() + steps > map.getRows()) {
                            this.position.setRow(map.getRows());
                            return false;

                        }
                    } else return true;


                case LEFT:
                    if (map.isActive()) {
                        for (int i = 1; i <= steps; i++) {
                            this.position.setCol(this.position.getCol() - i);
                            map.hasTreasure(this.position);
                                map.update(this.position);

                        }
                        if (this.position.getCol() - steps < 0) {
                            this.position.setCol(0);
                            return false;

                        }
                    } else return false;
                case RIGHT:
                    if (map.isActive()) {


                        for (int i = 1; i <= steps; i++) {
                            this.position.setCol(this.position.getCol() + i);
                            map.hasTreasure(this.position);
                                map.update(this.position);

                        }
                        if (this.position.getCol() + steps > map.getColumns()) {
                            this.position.setCol(map.getColumns());
                            return false;

                        }
                    }
            }
        } else if (steps > maxStepAllowed) {
            switch (direction) {
                case UP:
                    for (int i = 1; i <= maxStepAllowed; i++) {
                        this.position.setRow(this.position.getRow() - i);
                        map.hasTreasure(this.position);
                            map.update(this.position);

                    }
                    if (this.position.getRow() - maxStepAllowed < 0) {
                        this.position.setRow(0);
                        return false;

                    }
                case DOWN:
                    for (int i = 1; i <= maxStepAllowed; i++) {
                        this.position.setRow(this.position.getRow() + i);
                        map.hasTreasure(this.position);
                            map.update(this.position);

                    }
                    if (this.position.getRow() + maxStepAllowed > map.getRows()) {
                        this.position.setRow(map.getRows());
                        return false;

                    }
                case LEFT:
                    for (int i = 1; i <= maxStepAllowed; i++) {
                        this.position.setCol(this.position.getCol() - i);
                        map.hasTreasure(this.position);
                            map.update(this.position);
                        }

                    if (this.position.getCol() - maxStepAllowed < 0) {
                        this.position.setCol(0);
                        return false;

                    }
                case RIGHT:
                    for (int i = 1; i <= maxStepAllowed; i++) {
                        this.position.setCol(this.position.getCol() + i);
                        map.hasTreasure(this.position);
                            map.update(this.position);

                    }
                    if (this.position.getCol() + maxStepAllowed > map.getColumns()) {
                        this.position.setCol(map.getColumns());
                        return false;

                    }
            }
        } else return true;
        return true;

    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        if (this.id == p.id) {
            return true;
        } else return false;
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

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(this.score, o.score);
    }
}
