

public class Player {
    private int max = -1;
    private static int n = 0;
    private final int id;
    private int score = 0;

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

    private int steps = 0;
    private Position position;
    private Map map;

    public Player(Map map, Position initialPosition) {
        n++;
        id = n;
        this.map = map;
        position = initialPosition;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        n++;
        id = n;
        this.map = map;
        position = initialPosition;
        max = maxStepAllowed;
    }

    public boolean equals(Object player) {
        Player p = (Player) player;
        if (p.getId() == id) {
            return true;
        }
        return false;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (max >= 0) {
            if (this.steps >= max) {
                return false;
            }
            switch (direction) {
                case UP:
                    if (position.getRow() - steps >= 0) {
                        if (this.steps + steps <= max) {
                            this.steps += steps;
                            for (int i = 1; i <= steps; i++) {
                                position.setRow(position.getRow() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            return true;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setRow(position.getRow() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    } else {
                        if (max - this.steps > position.getRow()) {
                            int ddl = position.getRow();
                            for (int i = 1; i <= ddl; i++) {
                                position.setRow(position.getRow() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += ddl;
                            return false;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setRow(position.getRow() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    }
                case DOWN:
                    if (position.getRow() + steps <= map.getRows() - 1) {
                        if (this.steps + steps <= max) {
                            for (int i = 1; i <= steps; i++) {
                                position.setRow(position.getRow() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += steps;
                            return true;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setRow(position.getRow() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    } else {
                        if (max - this.steps > map.getRows() - 1 - position.getRow()) {int ddl = position.getRow();
                            for (int i = 1; i <= map.getRows() - 1 - ddl; i++) {
                                position.setRow(position.getRow() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += map.getRows() - 1 - ddl;
                            return false;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setRow(position.getRow() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    }
                case LEFT:
                    if (position.getCol() - steps >= 0) {
                        if (this.steps + steps <= max) {
                            this.steps += steps;
                            for (int i = 1; i <= steps; i++) {
                                position.setCol(position.getCol() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            return true;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setCol(position.getCol() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    } else {
                        if (max - this.steps > position.getCol()) {int ddl = position.getCol();
                            for (int i = 1; i <= ddl; i++) {
                                position.setCol(position.getCol() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += ddl;
                            return false;
                        } else {
                            ;
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setCol(position.getCol() - 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    }
                case RIGHT:
                    if (position.getCol() + steps <= map.getColumns() - 1) {
                        if (this.steps + steps <= max) {
                            for (int i = 1; i <= steps; i++) {
                                position.setCol(position.getCol() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += steps;
                            return true;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setCol(position.getCol() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    } else {int ddl = position.getCol();
                        if (max - this.steps > map.getColumns() - 1 - ddl) {
                            for (int i = 1; i <= map.getColumns() - 1 - ddl; i++) {
                                position.setCol(position.getCol() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps += map.getColumns() - 1 - ddl;
                            return false;
                        } else {
                            for (int i = 1; i <= max - this.steps; i++) {
                                position.setCol(position.getCol() + 1);
                                isTrue();
                                if(!map.isActive()){break;}
                            }
                            this.steps = max;
                            return false;
                        }
                    }
            }
        }
        if (max < 0) {
            switch (direction) {
                case UP:
                    if (position.getRow() - steps >= 0) {
                        this.steps += steps;
                        for (int i = 0; i < steps; i++) {
                            position.setRow(position.getRow() - 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return true;
                    } else {
                        this.steps += position.getRow();
                        int ddl = position.getRow();
                        for (int i = 0; i < ddl; i++) {
                            position.setRow(position.getRow() - 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return false;
                    }
                case DOWN:
                    if (position.getRow() + steps <= map.getRows() - 1) {
                        this.steps += steps;
                        for (int i = 0; i < steps; i++) {
                            position.setRow(position.getRow() + 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return true;
                    } else {
                        this.steps += map.getRows() - 1 - position.getRow();
                        int ddl = position.getRow();
                        for (int i = 0; i < map.getRows() - 1 - ddl; i++) {
                            position.setRow(position.getRow() + 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return false;
                    }
                case LEFT:
                    if (position.getCol() - steps >= 0) {
                        this.steps += steps;
                        for (int i = 0; i < steps; i++) {
                            position.setCol(position.getCol() - 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return true;
                    } else {
                        this.steps += position.getCol();
                        int ddl = position.getCol();
                        for (int i = 0; i < ddl; i++) {
                            position.setCol(position.getCol() - 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return false;
                    }
                case RIGHT:
                    if (position.getCol() + steps <= map.getColumns() - 1) {
                        this.steps += steps;
                        for (int i = 0; i < steps; i++) {
                            position.setCol(position.getCol() + 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return true;
                    } else {
                        this.steps += map.getColumns() - 1 - position.getCol();
                        int ddl = position.getCol();
                        for (int i = 0; i < map.getColumns() - 1 - ddl; i++) {
                            position.setCol(position.getCol() + 1);
                            isTrue();
                            if(!map.isActive()){break;}
                        }
                        return false;
                    }
            }
        }
        return false;
    }

    public void isTrue() {
        Treasure[] a = map.getTreasures();
        lable:
        for (int i = 0; i < map.getTreasures().length; i++) {
            if (position.getCol() == a[i].getPosition().getCol() && position.getRow() == a[i].getPosition().getRow()) {
                score += a[i].getScore();
                map.update(a[i].getPosition());
                break lable;
            }
        }
    }
}
