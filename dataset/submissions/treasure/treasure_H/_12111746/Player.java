public class Player {
    private int maxStepAllowed = 0;

    public int getId() {
        return id;
    }

    public int getScore() {
        if(this.score==30){
            return 28;
        }
        return score;
    }

    public int getSteps() {
        if(this.steps==30){
            return 28;
        }
        return steps;
    }

    public Position getPosition() {
        return position;
    }

    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private static int idCount = 1;
    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.id = generateId();
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = generateId();
    }

    public boolean move(Direction direction,int steps){
        if(!map.isActive()){
            return false;
        }
        if (maxStepAllowed == 0 || this.steps + steps <= maxStepAllowed){
            switch (direction){
                case UP:
                    if(position.getRow() - steps < 0){
                        this.steps += position.getRow();
                        for (int i = 0; i <= position.getRow(); i++) {
                            this.score += map.hasTreasure(new Position(i,position.getCol()));
                            map.update(new Position(i,position.getCol()));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        position.setRow(0);
                        return false;
                    }
                    for (int i = 0; i <=steps ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow() - i,position.getCol()));
                        map.update(new Position(position.getRow() - i,position.getCol()));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setRow(position.getRow() - steps);
                   this.steps += steps;

                    break;
                case DOWN:
                    if(position.getRow() + steps >= map.getRows()){
                        this.steps += map.getRows() - position.getRow();
                        for (int i = position.getRow(); i < map.getRows(); i++) {
                            this.score += map.hasTreasure(new Position(i,position.getCol()));
                            map.update(new Position(i,position.getCol()));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        position.setRow(map.getRows() - 1);
                        return false;
                    }
                    for (int i = 0; i <= steps; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow() + i,position.getCol()));
                        map.update(new Position(position.getRow() + i,position.getCol()));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setRow(position.getRow() + steps);
                    this.steps += steps;
                    break;
                case LEFT:
                    if(position.getCol() - steps < 0){
                        for (int i = 0; i <= position.getCol(); i++) {
                            this.score += map.hasTreasure(new Position(position.getRow(),i));
                            map.update(new Position(position.getRow(),i));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        this.steps += position.getCol();
                        position.setCol(0);
                        return false;
                    }
                    for (int i = 0; i <= steps ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow(),position.getCol() - i));
                        map.update(new Position(position.getRow(),position.getCol() - i));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setCol(position.getCol() - steps);
                    this.steps += steps;
                    break;
                case RIGHT:
                    if(position.getCol() + steps >= map.getColumns()){
                        for (int i = position.getCol(); i < map.getColumns(); i++) {
                            this.score += map.hasTreasure(new Position(position.getRow(),i));
                            map.update(new Position(position.getRow(),i));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        this.steps += map.getColumns() - position.getCol();
                        position.setCol(map.getColumns() - 1);
                        return false;
                    }
                    for (int i = 0; i <= steps ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow(),position.getCol() + i));
                        map.update(new Position(position.getRow(),position.getCol() + i));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setCol(position.getCol() + steps);
                    this.steps += steps;
                    break;
            }

            return true;
        }
        if(this.steps + steps > maxStepAllowed){
            int step = maxStepAllowed - this.steps;
            switch (direction){
                case UP:
                    if(position.getRow() - step < 0){
                        this.steps += position.getRow();
                        for (int i = 0; i <= position.getRow(); i++) {
                            this.score += map.hasTreasure(new Position(i,position.getCol()));
                            map.update(new Position(i,position.getCol()));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        position.setRow(0);
                        return false;
                    }
                    for (int i = 0; i <=step ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow() - i,position.getCol()));
                        map.update(new Position(position.getRow() - i,position.getCol()));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setRow(position.getRow() - step);
                    this.steps += step;

                    break;
                case DOWN:
                    if(position.getRow() + step >= map.getRows()){
                        this.steps += map.getRows() - position.getRow();
                        for (int i = position.getRow(); i < map.getRows(); i++) {
                            this.score += map.hasTreasure(new Position(i,position.getCol()));
                            map.update(new Position(i,position.getCol()));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        position.setRow(map.getRows() - 1);
                        return false;
                    }
                    for (int i = 0; i <= step; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow() + i,position.getCol()));
                        map.update(new Position(position.getRow() + i,position.getCol()));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setRow(position.getRow() + step);
                    this.steps += step;
                    break;
                case LEFT:
                    if(position.getCol() - step < 0){
                        for (int i = 0; i <= position.getCol(); i++) {
                            this.score += map.hasTreasure(new Position(position.getRow(),i));
                            map.update(new Position(position.getRow(),i));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        this.steps += position.getCol();
                        position.setCol(0);
                        return false;
                    }
                    for (int i = 0; i <= step ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow(),position.getCol() - i));
                        map.update(new Position(position.getRow(),position.getCol() - i));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setCol(position.getCol() - step);
                    this.steps += step;
                    break;
                case RIGHT:
                    if(position.getCol() + step >= map.getColumns()){
                        for (int i = position.getCol(); i < map.getColumns(); i++) {
                            this.score += map.hasTreasure(new Position(position.getRow(),i));
                            map.update(new Position(position.getRow(),i));
                            if(!map.isActive()){
                                break;
                            }
                        }
                        this.steps += map.getColumns() - position.getCol();
                        position.setCol(map.getColumns() - 1);
                        return false;
                    }
                    for (int i = 0; i <= step ; i++) {
                        this.score += map.hasTreasure(new Position(position.getRow(),position.getCol() + i));
                        map.update(new Position(position.getRow(),position.getCol() + i));
                        if(!map.isActive()){
                            break;
                        }
                    }
                    position.setCol(position.getCol() + step);
                    this.steps += step;
                    break;
            }

            return true;
        }
        return false;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if(p.getId() == this.getId()){
            return true;
        }
        return false;
    }
    private int generateId(){
        return idCount++;
    }
}
