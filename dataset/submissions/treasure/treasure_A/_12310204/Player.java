

public class Player {
    public int getId() {
        return id;
    }

    public boolean status = false;
    private final int id;
    private int maximum = -1;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public int getSteps() {
        return steps;
    }

    private int steps;

    public void setSteps(int steps) {
        this.steps = steps;
    }
    static int wanjia = 0;

    public Position getPosition() {
        return position;
    }

    private Position position;

    public Map getMap() {
        return map;
    }

    private Map map;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        id = wanjia ;
        wanjia=wanjia+1;
    }



    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maximum = maxStepAllowed;
        id = wanjia;
        wanjia = wanjia + 1;
    }

    public boolean move(Direction direction, int steps) {
//        if (status == true) {
            boolean can = true;
            switch (direction) {
                case UP:
                    map.update(this.position);
                    for (int i = 0; i < steps; i++) {
                        if (this.steps == maximum || this.position.getRow() == 0 || map.isActive() == false) {
                            can = false;
                        }
                        if (can == true) {
                            this.steps = this.steps + 1;
                            this.position.setRow(this.position.getRow() - 1);
                            score = score + map.hasTreasure(this.position);
                            map.update(this.position);
                        }

                    }
                    break;
                case DOWN:
                    map.update(this.position);
                    for (int i = 0; i < steps; i++) {
                        if (this.steps == maximum || this.position.getRow()+1 == map.getRows() || map.isActive() == false) {
                            can = false;
                        }
                        if (can == true) {
                            this.steps = this.steps + 1;
                            this.position.setRow(this.position.getRow() + 1);
                            score = score + map.hasTreasure(this.position);
                            map.update(this.position);
                        }
                    }
                    break;
                case LEFT:
                    map.update(this.position);
                    for (int i = 0; i < steps; i++) {
                        if (this.steps == maximum || this.position.getCol() == 0 || map.isActive() == false) {
                            can = false;
                        }
                        if (can == true) {
                            this.steps = this.steps + 1;
                            this.position.setCol(this.position.getCol() - 1);
                            score = score + map.hasTreasure(this.position);
                            map.update(this.position);
                        }
                    }
                    break;
                case RIGHT:
                    map.update(this.position);
                    for (int i = 0; i < steps; i++) {
                        if (this.steps == maximum || this.position.getCol() + 1 == map.getColumns() || map.isActive() == false) {
                            can = false;
                        }
                        if (can == true) {
                            this.steps = this.steps + 1;
                            this.position.setCol(this.position.getCol() + 1);
                            score = score + map.hasTreasure(this.position);
                            map.update(this.position);
                        }
                    }
                    break;
            }
            return can;
//        } else {
//            return false;
//        }
    }

    public boolean equals(Object player) {
        boolean judge = false;
        if (this.id == ((Player) player).getId()) {
            judge = true;
        }
        return judge;
    }
}