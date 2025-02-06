public class Player {
    //            Fields
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int idCounter = 0;

    //    Constructors
    public Player(Map map, Position initialPosition) {
        this.map = map;
        position = initialPosition;
        score = 0;
        steps = 0;
        maxStepAllowed = -1;
        idCounter++;
        id = idCounter;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        position = initialPosition;
        score = 0;
        this.maxStepAllowed = maxStepAllowed;
        steps = 0;
        id = idCounter;
        idCounter++;
    }

    //    Methods
    public boolean move(Direction direction, int step) {
        boolean moveBoolean = true;
        if (steps + step > maxStepAllowed && maxStepAllowed != -1) {
            step = maxStepAllowed - steps;
            moveBoolean = false;
        }
        if (step == 0) {
            moveBoolean = false;
            return moveBoolean;
        }
        if ((steps + step <= maxStepAllowed || maxStepAllowed == -1)) {
            if (map.isActive()) {
                switch (direction) {
                    case UP:
                        if (position.getRow() - step >= 0) {
                            int stop = position.getRow() - step;
                            for (; map.isActive() && position.getRow() > stop; position.setRow(position.getRow() - 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                        } else if (position.getRow() - step < 0) {
                            int stop = 0;
                            for (; map.isActive() && position.getRow() > stop; position.setRow(position.getRow() - 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                        }
                        break;
                    case DOWN:
                        if (position.getRow() + step <= map.getRows() - 1) {
                            int stop = position.getRow() + step;
                            for (; map.isActive() && position.getRow() < stop; position.setRow(position.getRow() + 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                        } else if (position.getRow() + step > map.getRows() - 1) {
                            int stop = map.getRows() - 1;
                            for (; map.isActive() && position.getRow() < stop; position.setRow(position.getRow() + 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                            moveBoolean = false;
                        }
                        break;
                    case LEFT:
                        if (position.getCol() - step >= 0) {
                            int stop = position.getCol() - step;
                            for (; map.isActive() && position.getCol() > stop; position.setCol(position.getCol() - 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                        } else if (position.getCol() - step < 0) {
                            int stop = 0;
                            for (; map.isActive() && position.getCol() > stop; position.setCol(position.getCol() - 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                            moveBoolean = false;
                        }
                        break;
                    case RIGHT:
                        if (position.getCol() + step <= map.getColumns() - 1) {
                            int stop = position.getCol() + step;
                            for (; map.isActive() && position.getCol() < stop; position.setCol(position.getCol() + 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                        } else if (position.getCol() + step > map.getColumns() - 1) {
                            int stop = map.getColumns() - 1;
                            for (; map.isActive() && position.getCol() < stop; position.setCol(position.getCol() + 1), steps++) {
                                score = score + map.hasTreasure(position);
                                if(map.hasTreasure(position) != 0){
                                    map.update(position);
                                }
                                if( !map.isActive()){
                                    break;
                                }
                            }
                            score = score + map.hasTreasure(position);
                            if(map.hasTreasure(position) != 0){
                                map.update(position);
                            }
                            moveBoolean = false;
                        }
                        break;
                }
            } else {
                moveBoolean = false;
            }
        }
        return moveBoolean;
    }

//    get&set


    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public int getSteps() {
        return steps;
    }

    public int getScore() {
        return score;
    }
}
