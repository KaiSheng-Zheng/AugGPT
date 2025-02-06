public class Player {
    private final int id ;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int max;
    public static int counter = 0;
    private boolean just ;


    public Player(Map map, Position initiaPosition) {
        position = initiaPosition;
        this.map = map;
        id=++counter;
        steps=0;
        score= 0;
        max=-1;
        just=true;
    }

    public Player(Map map, Position initialposition, int maxStepallowed) {
        max = maxStepallowed;
        position=initialposition;
        this.map = map;
        id=++counter;
        steps=0;
        score=0;
        just=true;
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

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if (max!=-1) {
            if(this.steps>=max){return false;}
            if (steps + this.steps > max) {
                steps=max-this.steps;
                just=false;
            }
        }
        Position origin = new Position(position.getRow(), position.getCol());
        switch (direction) {
            case LEFT:
                if (position.getCol() - steps >= 0) {
                    position.setCol(position.getCol() - steps);
                    this.steps += steps;
                } else {
                    this.steps += position.getCol();
                    position.setCol(0);
                    just = false;
                }
                for (int i = position.getCol(); i <= origin.getCol(); i++) {
                    Position trans = new Position(position.getRow(), i);
                    score += map.hasTreasure(trans);
                    map.update(trans);
                    if(!map.isActive()){
                        position=trans;
                        break;
                    }
                }break;
            case RIGHT:
                if (position.getCol() + steps <= map.getColumns()-1) {
                    position.setCol(position.getCol() + steps);
                    this.steps += steps;
                } else {
                    this.steps += map.getColumns()-1 - position.getCol();
                    position.setCol(map.getColumns()-1);
                    just = false;
                }
                for (int i = origin.getCol(); i <= position.getCol(); i++) {
                    Position trans = new Position(position.getRow(), i);
                    score += map.hasTreasure(trans);
                    map.update(trans);if(!map.isActive()){
                        position=trans;
                        break;
                    }
                }break;
            case UP:
                if (position.getRow() - steps >= 0) {
                    position.setRow(position.getRow() - steps);
                    this.steps += steps;
                } else {
                    this.steps += position.getRow();
                    position.setRow(0);
                    just = false;
                }
                for (int i = position.getRow(); i <= origin.getRow(); i++) {
                    Position trans = new Position(i, position.getCol());
                    score += map.hasTreasure(trans);
                    map.update(trans);if(!map.isActive()){
                        position=trans;
                        break;
                    }
                }break;
            case DOWN:
                if (position.getRow() + steps <= map.getRows()) {
                    position.setRow(position.getRow() + steps);
                    this.steps += steps;
                } else {
                    this.steps += map.getRows()-1 - position.getRow();
                    position.setRow(map.getRows()-1);
                    just = false;
                }
                for (int i = origin.getRow(); i <= position.getRow(); i++) {
                    Position trans = new Position(i, position.getCol());
                    score += map.hasTreasure(trans);
                    map.update(trans);if(!map.isActive()){
                        position=trans;
                        break;
                    }
                }break;
        }
        return just;
    }

    public boolean equals(Object player) {
        Player p=(Player)player;
        if(this.getId()==p.getId()){
            return true;
        }else{
            return false;
        }
    }
}
