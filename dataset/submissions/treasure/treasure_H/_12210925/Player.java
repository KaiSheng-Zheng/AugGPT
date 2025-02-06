import java.util.ArrayList;

public class Player{
    private int id;
    private static int count;
    private int score;
    private int step;
    private int steps;
    private int maxStepAllowed;

    private Position position;
    private Position newPosition;
    private Map map;

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Position newPosition) {
        this.newPosition = newPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
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

    public Player() {
    }
    public Player(Map map, Position position) {
        this.position = position;
        this.map = map;
        this.maxStepAllowed=10000;
        this.newPosition=position;
        this.id=count;
        count++;
    }
    public Player(Map map, Position position, int maxStepAllowed) {
        this.position = position;
        this.map = map;
        this.maxStepAllowed=maxStepAllowed;
        this.newPosition=position;
        this.id=count;
        count++;
    }
    public boolean move(Direction direction, int steps) {
        if (getStep() <= maxStepAllowed) {
            if (!map.isActive()) {
                return false;
            }
            else {
                switch (direction) {
                    case UP:
                            for (int i = 0; i < steps; i++) {
                                if(map.isActive()){
                                    if (getStep() < maxStepAllowed) {
                                        if (newPosition.getRow() == 0) {
                                            return false;
                                        } else {
                                            newPosition.setRow(getNewPosition().getRow() - 1);
                                            setScore(getScore() + map.hasTreasure(newPosition));
                                            map.update(newPosition);
                                            if (newPosition.getRow() == 0) {
                                                if (i == steps - 1) {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    break;
                                                } else {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    return false;
                                                }
                                            } else {
                                                setStep(getStep() + 1);
                                                setSteps(getStep());
                                            }
                                        }
                                    }
                                    else {
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            break;
                    case DOWN:
                            for (int i = 0; i < steps; i++) {
                                if(map.isActive()){
                                    if (getStep() < maxStepAllowed) {
                                        if (newPosition.getRow() == map.getRows() - 1) {
                                            return false;
                                        } else {
                                            newPosition.setRow(getNewPosition().getRow() + 1);
                                            setScore(getScore() + map.hasTreasure(newPosition));
                                            map.update(newPosition);
                                            if (newPosition.getRow() == map.getRows() - 1) {
                                                if (i == steps - 1) {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    break;
                                                } else {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    return false;
                                                }
                                            } else {
                                                setStep(getStep() + 1);
                                                setSteps(getStep());
                                            }
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            break;
                    case LEFT:
                            for (int i = 0; i < steps; i++) {
                                if(map.isActive()){
                                    if (getStep() < maxStepAllowed) {
                                        if (newPosition.getCol() == 0) {
                                            return false;
                                        } else {
                                            newPosition.setCol(getNewPosition().getCol() - 1);
                                            setScore(getScore() + map.hasTreasure(newPosition));
                                            map.update(newPosition);
                                            if (newPosition.getCol() == 0) {
                                                if (i == steps - 1) {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    break;
                                                } else {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    return false;
                                                }
                                            } else {
                                                setStep(getStep() + 1);
                                                setSteps(getStep());
                                            }
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            break;
                    case RIGHT:
                            for (int i = 0; i < steps; i++) {
                                if(map.isActive()){
                                    if (getStep() < maxStepAllowed) {
                                        if (newPosition.getCol() == map.getColumns() - 1) {
                                            return false;
                                        } else {
                                            newPosition.setCol(getNewPosition().getCol() + 1);
                                            setScore(getScore() + map.hasTreasure(newPosition));
                                            map.update(newPosition);
                                            if (newPosition.getCol() == map.getColumns() - 1) {
                                                if (i == steps - 1) {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    break;
                                                } else {
                                                    setStep(getStep() + 1);
                                                    setSteps(getStep());
                                                    return false;
                                                }
                                            } else {
                                                setStep(getStep() + 1);
                                                setSteps(getStep());
                                            }
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                                else{
                                    return false;
                                }
                            }
                            break;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.getId();
    }
}
