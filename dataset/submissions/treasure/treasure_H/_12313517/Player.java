public class Player {
    private static int shitid = 0;

    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.id = generateUniqueId();
        this.score = 0;
        this.steps = 0;
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this(map, initialPosition);
        this.maxStepAllowed = maxStepAllowed;
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
        int newRow = position.getRow();
        int newCol = position.getCol();
        if (!map.isActive() || maxStepAllowed == 0||steps==0) {
            return false;
        }
        if (steps + this.steps > maxStepAllowed) {
            steps = steps + this.steps - maxStepAllowed;
            switch (direction) {
                case UP:
                    if (newRow == 0){
                        return false;
                    }
                    for (int i = 0; i < steps; i++) {
                        
                        newRow -= 1;
                        if (newRow >= 0) {
                            int score = map.hasTreasure(new Position(newRow, newCol));
                            position.setRow(newRow);
                            position.setCol(newCol);
                            if (score != 0) {
                                this.score += score;
                                map.update(new Position(newRow, newCol));
                                if (!map.isActive()){
                                    return false;
                                }
                            }
                            this.steps++;
                            if(this.steps>this.maxStepAllowed){
                                this.steps -=1;
                            }
                            

                        } else {
                            newRow += 1;
                            position.setRow(newRow);
                            position.setCol(newCol);
                            return false;
                        }
                    }
                    break;
                case DOWN:
                    if (newRow== map.getRows()-1){
                        return false;
                    }
                    for (int i = 0; i < steps; i++) {
                        newRow += 1;
                        if (newRow < map.getRows()) {
                            int score = map.hasTreasure(new Position(newRow, newCol));
                            position.setRow(newRow);
                            position.setCol(newCol);
                            if (score > 0) {
                                this.score += score;
                                map.update(new Position(newRow, newCol));
                                if (!map.isActive()){
                                    this.steps++;
                                    return false;
                                }
                            }
                            this.steps++;
                        } else {
                            newRow -= 1;
                            position.setRow(newRow);
                            position.setCol(newCol);
                            return false;
                        }
                    }
                    break;
                case LEFT:
                    if (newCol == 0){
                        return false;
                    }
                    for (int i = 0; i < steps; i++) {
                        newCol -= 1;
                        if (newCol >= 0) {
                            int score = map.hasTreasure(new Position(newRow, newCol));
                            position.setRow(newRow);
                            position.setCol(newCol);
                            if (score > 0) {
                                this.score += score;
                                map.update(new Position(newRow, newCol));
                                if (!map.isActive()){
                                    this.steps++;
                                    return false;
                                }
                            }
                            this.steps++;

                        } else {
                            newCol += 1;
                            position.setRow(newRow);
                            position.setCol(newCol);
                            return false;
                        }
                    }
                    break;
                case RIGHT:
                    if (newCol == map.getColumns()-1){
                        return false;
                    }
                    for (int i = 0; i < steps; i++) {
                        newCol += 1;
                        if (newCol < map.getColumns()) {
                            int score = map.hasTreasure(new Position(newRow, newCol));
                            position.setRow(newRow);
                            position.setCol(newCol);
                            if (score > 0) {
                                this.score += score;
                                map.update(new Position(newRow, newCol));
                                if (!map.isActive()){
                                    this.steps++;
                                    return false;
                                }
                            }
                            this.steps++;

                        } else {
                            newCol -= 1;
                            position.setRow(newRow);
                            position.setCol(newCol);
                            return false;
                        }
                    }
                default:
                    return false;
            }

        }
        switch (direction) {
            case UP:
                if (newRow == 0){
                    return false;
                }
                for (int i = 0; i < steps; i++) {
                    newRow -= 1;
                    if (newRow >= 0) {
                        int score = map.hasTreasure(new Position(newRow, newCol));
                        position.setRow(newRow);
                        position.setCol(newCol);
                        if (score != 0) {
                            this.score += score;
                            map.update(new Position(newRow, newCol));
                            if (!map.isActive()){
                                this.steps++;
                                return false;
                            }
                        }
                        this.steps++;

                    } else {
                        newRow += 1;
                        position.setRow(newRow);
                        position.setCol(newCol);
                        return false;
                    }
                }
                break;
            case DOWN:
                if (newRow== map.getRows()-1){
                    return false;
                }
                for (int i = 0; i < steps; i++) {
                    newRow += 1;
                    if (newRow < map.getRows()) {
                        int score = map.hasTreasure(new Position(newRow, newCol));
                        position.setRow(newRow);
                        position.setCol(newCol);
                        if (score > 0) {
                            this.score += score;
                            map.update(new Position(newRow, newCol));
                            if (!map.isActive()){
                                this.steps++;
                                return false;
                            }
                        }
                        this.steps++;

                    } else {
                        newRow -= 1;
                        position.setRow(newRow);
                        position.setCol(newCol);
                        return false;
                    }
                }
                break;
            case LEFT:
                if (newCol == 0){
                    return false;
                }
                for (int i = 0; i < steps; i++) {
                    newCol -= 1;
                    if (newCol >= 0) {
                        int score = map.hasTreasure(new Position(newRow, newCol));
                        position.setRow(newRow);
                        position.setCol(newCol);
                        if (score > 0) {
                            this.score += score;
                            map.update(new Position(newRow, newCol));
                            if (!map.isActive()){
                                this.steps++;
                                return false;
                            }
                        }
                        this.steps++;

                    } else {
                        newCol += 1;
                        position.setRow(newRow);
                        position.setCol(newCol);
                        return false;
                    }
                }
                break;
            case RIGHT:
                if (newCol == map.getColumns()-1){
                    return false;
                }
                for (int i = 0; i < steps; i++) {
                    newCol += 1;
                    if (newCol < map.getColumns()) {
                        int score = map.hasTreasure(new Position(newRow, newCol));
                        position.setRow(newRow);
                        position.setCol(newCol);
                        if (score > 0) {
                            this.score += score;
                            map.update(new Position(newRow, newCol));
                            if (!map.isActive()){
                                this.steps++;
                                return false;
                            }
                        }
                        this.steps++;

                    } else {
                        newCol -= 1;
                        position.setRow(newRow);
                        position.setCol(newCol);
                        return false;
                    }
                }
                break;
            default:
                return false;
        }
        if(this.steps > this.maxStepAllowed){
            this.steps = this.maxStepAllowed;
        }
        position.setRow(newRow);
        position.setCol(newCol);
        return true;
    }

    public boolean equals(Object player) {
        if (player instanceof Player) {
            Player p = (Player) player;
            if(this.id == p.getId()){
                return true;
            }else return false;
        }
        return false;
    }
    private int generateUniqueId() {
        return shitid++;
    }
}
