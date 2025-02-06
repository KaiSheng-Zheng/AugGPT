

public class Player {
    private static int count=0;
    private final int id;
    private int score;
    private int steps;
    private int maxsteps=100000000;
    private Position position;
    private Map map;
    private boolean tt=false;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        id=++count;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxsteps=maxStepAllowed;
        this.tt=true;
        id=++count;
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

    public boolean move(Direction direction, int steps){
        //map.update(position);
        stage:{
        for (int i = 0; i <this.map.getTreasures().length; i++) {
            if(map.getTreasures()[i].getScore()!=0){
                break stage;
            }}map.setActive(false);}

        switch (direction) {

            case LEFT -> {
                if (steps==0){return true;}else{
                    if (!map.isActive()){return false;}
                for (int i = 0; i < steps; i++) {
                    if (this.steps >= maxsteps &&tt) {
                        return false;
                    }
                    if (position.getCol() > 0) {
                        this.steps++;
                        position.setCol(position.getCol() - 1);
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else {
                        return false;
                    }
                }
                return true;}

            }
            case RIGHT -> {
                if(steps==0){return true;}else{
                for (int i = 0; i < steps; i++) {
                    if(!map.isActive()){return false;}
                    if (this.steps >= maxsteps &&tt) {
                        return false;
                    }
                    if (position.getCol() < map.getColumns()-1) {
                        this.steps++;
                        position.setCol(position.getCol() + 1);
                        score += map.hasTreasure(position);
                        map.update(position);
                    } else {
                        return false;
                    }
                }
                return true;}
            }
            case UP -> {
                if (steps == 0) {
                    return true;
                } else {
                    for (int i = 0; i < steps; i++) {
                        if(!map.isActive()){return false;}
                        if (this.steps >= maxsteps &&tt) {
                            return false;
                        }
                        if (position.getRow() > 0) {
                            this.steps++;
                            position.setRow(position.getRow() - 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }

            case DOWN -> {
                if (steps == 0) {
                    return true;
                } else {
                    for (int i = 0; i < steps; i++) {
                        if(!map.isActive()){return false;}
                        if (this.steps>= maxsteps &&tt) {
                            return false;
                        }
                        if (position.getRow() < map.getRows()-1) {
                            this.steps++;
                            position.setRow(position.getRow() + 1);
                            score += map.hasTreasure(position);
                            map.update(position);
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean equals(Object player){
        Player temp=(Player)player;
        if(temp.getId()==this.id){
            return true;
        }else{
            return  false;
        }
    }
}
