public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    static int count;
     private int maxStepAllowed;
     private int step;

    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=-1;
        this.step=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.id=++count;
        this.maxStepAllowed=maxStepAllowed;
        this.step=0;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return step;
    }

    public int getStep() {
        return step;
    }

    public Position getPosition() {
        return position;
    }
    public boolean move(Direction direction, int steps){
        int s=steps;
        int ss=0;
        boolean flag=false;
        switch(direction) {
            // must be unqualified name of the enum constant
            case UP:
                for (int i = 0; i < s; i++) {
                    if (map.isActive() == false) {
                        flag= false;
                        break;
                    } else if (position.getRow() <=0) {
                        flag= false;
                        break;
                    } else if (maxStepAllowed >= 0) {
                        if (step >= maxStepAllowed) {
                            flag= false;
                            break;
                        } else {
                            position.setRow(position.getRow() - 1);
                            step++;
                            ss++;
                            if (map.hasTreasure(position) != 0) {
                                score = score + map.hasTreasure(position);
                                map.update(position);
                            }
                        }
                    } else {
                        position.setRow(position.getRow() - 1);
                        step++;
                        ss++;
                        if (map.hasTreasure(position) != 0) {
                            score = score + map.hasTreasure(position);
                            map.update(position);
                        }

                    }

                }
                if(ss==steps){
                    flag=true;
                }
                break;
            case DOWN:
                for (int i = 0; i < s; i++) {
                    if (map.isActive() == false) {
                        flag= false;
                        break;
                    } else if (position.getRow() >=map.getRows()-1) {
                        flag= false;
                        break;
                    } else if (maxStepAllowed >= 0) {
                        if (step >= maxStepAllowed) {
                            flag= false;
                            break;
                        } else {
                            position.setRow(position.getRow() + 1);
                            step++;
                            ss++;
                            if (map.hasTreasure(position) != 0) {
                                score = score + map.hasTreasure(position);
                                map.update(position);
                            }
                        }
                    } else {
                        position.setRow(position.getRow() + 1);
                        step++;
                        ss++;
                        if (map.hasTreasure(position) != 0) {
                            score = score + map.hasTreasure(position);
                            map.update(position);
                        }

                    }

                }
                if(ss==steps){
                    flag=true;
                }
                break;

            case RIGHT:
                for (int i = 0; i < s; i++) {
                    if (map.isActive() == false) {
                        flag= false;
                        break;
                    } else if (position.getCol() >=map.getColumns()-1) {
                        flag= false;
                        break;
                    } else if (maxStepAllowed >= 0) {
                        if (step >= maxStepAllowed) {
                            flag= false;
                            break;
                        } else {
                            position.setCol(position.getCol() + 1);
                            step++;
                            ss++;
                            if (map.hasTreasure(position) != 0) {
                                score = score + map.hasTreasure(position);
                                map.update(position);
                            }
                        }
                    } else {
                        position.setCol(position.getCol() + 1);
                        step++;
                        ss++;
                        if (map.hasTreasure(position) != 0) {
                            score = score + map.hasTreasure(position);
                            map.update(position);
                        }

                    }

                }
                if(ss==steps){
                    flag=true;
                }
                break;
            case LEFT:
                for (int i = 0; i < s; i++) {
                    if (map.isActive() == false) {
                        flag= false;
                        break;
                    } else if (position.getCol() <=0) {
                        flag= false;
                        break;
                    } else if (maxStepAllowed >= 0) {
                        if (step >= maxStepAllowed) {
                            flag= false;
                            break;
                        } else {
                            position.setCol(position.getCol() - 1);
                            step++;
                            ss++;
                            if (map.hasTreasure(position) != 0) {
                                score = score + map.hasTreasure(position);
                                map.update(position);
                            }
                        }
                    } else {
                        position.setCol(position.getCol() - 1);
                        step++;
                        ss++;
                        if (map.hasTreasure(position) != 0) {
                            score = score + map.hasTreasure(position);
                            map.update(position);
                        }

                    }

                }
                if(ss==steps){
                    flag=true;
                }
                break;

        }
        return flag;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.id==id){
            return true;
        }
        else {
            return false;
        }
    }

}
