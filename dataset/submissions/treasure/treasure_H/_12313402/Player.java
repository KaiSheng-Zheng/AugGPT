public class Player {
    public static int counter = 1;
    private final int id = counter;

    private int score;
    private int steps = 0;
    private int maxStepAllowed;
    private Position position;
    private Map map;


    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        counter++;
        maxStepAllowed = 10000000;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        counter++;
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

    public Map getMap() {
        return map;
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) return false;
        if (direction.equals(Direction.DOWN)) {
            if (position.getRow() + steps > map.getRows() - 1) {
                int a = position.getRow();int b=maxStepAllowed;
                for (int i = 0; i < map.getRows() - 1 - a; i++) {

                    if (this.steps < b) {
                        position.setRow((position.getRow() + 1));
                        this.steps++;
                       maxStepAllowed--;
                    } else {
                        break;
                    }
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

            }
            if (this.maxStepAllowed- steps < 0&&position.getRow() + maxStepAllowed <= map.getRows() - 1) {
                int a=this.maxStepAllowed;
                for (int i = 0; i < a; i++) {
                    position.setRow(position.getRow() + 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

            } else {if (position.getRow() + steps <= map.getRows() - 1){
                for (int i = 0; i < steps; i++) {
                    position.setRow(position.getRow() + 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }

                    }
                }


                return true;}
            }return false;
        }
        if (direction.equals(Direction.RIGHT)) {
            if (position.getCol() + steps > map.getColumns() - 1) {
                int a = position.getCol();int b=maxStepAllowed;
                for (int i = 0; i < map.getColumns() - 1 - a; i++) {
                    if (this.steps < b) {
                        position.setCol(position.getCol() + 1);
                        this.steps++;
                        maxStepAllowed--;
                    } else {
                        break;
                    }

                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }
            }
            if (this.maxStepAllowed - steps < 0&&position.getCol() + maxStepAllowed <= map.getColumns() - 1) {
                int a=this.maxStepAllowed;
                for (int i = 0; i < a; i++) {
                    position.setCol(position.getCol() + 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

            } else {if (position.getCol() + steps <= map.getColumns() - 1){
                for (int i = 0; i < steps; i++) {
                    position.setCol(position.getCol() + 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

                return true;}
            }return false;
        }
        if (direction.equals(Direction.UP)) {
            if (position.getRow() - steps < 0) {
                int a = position.getRow();int b=maxStepAllowed;
                for (int i = 0; i < a; i++) {
                    if (this.steps < b) {
                        position.setRow(position.getRow() - 1);
                        this.steps++;
                        maxStepAllowed--;
                    } else {
                        break;
                    }
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

            }
            if  (this.maxStepAllowed- steps < 0&&position.getRow() - maxStepAllowed >= 0) {
                int a=this.maxStepAllowed;
                for (int i = 0; i < a; i++) {
                    position.setRow(position.getRow() - 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }

            }

            else {if (position.getRow() - steps >= 0){
                for (int i = 0; i < steps; i++) {
                    position.setRow(position.getRow() - 1);
                    this.steps++;
                    maxStepAllowed--;
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }


                return true;}
            }return false;
        }
        if (direction.equals(Direction.LEFT)) {

            if (position.getCol() - steps < 0) {
                int a = position.getCol();int b=maxStepAllowed;
                for (int i = 0; i < a; i++) {
                    if (this.steps <b) {
                        position.setCol(position.getCol() - 1);
                        this.steps++;
                        maxStepAllowed--;
                    } else {
                        break;
                    }
                    for (int j = 0; j < map.treasures1.size(); j++) {
                        if (position.equals(map.treasures1.get(j).getPosition())) {
                            score += map.treasures1.get(j).getScore();
                            map.update(map.treasures1.get(j).getPosition());
                            j--;
                            if (!map.isActive() && i < steps - 1) {
                                return false;
                            }
                        }
                    }
                }
                }



        if (this.maxStepAllowed - steps < 0&&position.getCol() - maxStepAllowed >= 0) {
            int a=this.maxStepAllowed;
            for (int i = 0; i < a; i++) {
                position.setCol(position.getCol() - 1);
                this.steps++;
                maxStepAllowed--;
                for (int j = 0; j < map.treasures1.size(); j++) {
                    if (position.equals(map.treasures1.get(j).getPosition())) {
                        score += map.treasures1.get(j).getScore();
                        map.update(map.treasures1.get(j).getPosition());
                        j--;
                        if (!map.isActive() && i < steps - 1) {
                            return false;
                        }
                    }
                }
            }


        } else {if (position.getCol() - steps >= 0){
            for (int i = 0; i < steps; i++) {
                position.setCol(position.getCol() - 1);
                this.steps++;
                maxStepAllowed--;
                for (int j = 0; j < map.treasures1.size(); j++) {
                    if (position.equals(map.treasures1.get(j).getPosition())) {
                        score += map.treasures1.get(j).getScore();
                        map.update(map.treasures1.get(j).getPosition());
                        j--;
                        if (!map.isActive() && i < steps - 1) {
                            return false;
                        }
                    }
                }
            }


            return true;}
        }return false;}

    return false;}






    public boolean equals(Object player) {
        Player p = (Player) player;
        if (p.getId() == this.id) {
            return true;
        }
        return false;
    }

}
