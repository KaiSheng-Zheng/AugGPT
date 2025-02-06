public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count = 0;
    public Player(Map map, Position initialPosition){
        this.map =map;
        this.position = initialPosition;
        this.score =0;
        this.steps = 0;
        this.id = ++count;
        maxStepAllowed = Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map =map;
        this.position = initialPosition;
        this.score =0;
        this.steps = 0;
        this.id = ++count;
        this.maxStepAllowed=maxStepAllowed;
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
        if(map.isActive()){
            int a = position.getRow();
            int b = position.getCol();
            if(distance(position,direction) >= steps){
                if(steps <= (maxStepAllowed-this.steps)){
                    return movement(new Position(a,b),direction, steps);
                }else {
                    movement(new Position(a,b),direction,(maxStepAllowed-this.steps));
                    return false;
                }
            }else{
                if(distance(position,direction) >= (maxStepAllowed-this.steps)){
                    movement(new Position(a,b),direction,(maxStepAllowed-this.steps));
                }else {
                    movement(new Position(a,b),direction,distance(position,direction));
                }
                return false;
            }
        }else return false;
    }
    public int distance(Position position,Direction direction){
        int distance = 0;
        switch (direction){
            case UP:
                distance = position.getRow();
                break;
            case DOWN:
                distance = (map.getRows()-1) - position.getRow();
                break;
            case LEFT:
                distance = position.getCol();
                break;
            case RIGHT:
                distance = (map.getColumns()-1) - position.getCol();
                break;
        }
        return distance;
    }
    public boolean movement(Position position,Direction direction,int steps){
        boolean judge = true;
        switch (direction){
            case UP:
                for (int i = position.getRow()-1; i >= position.getRow() - steps; i--) {
                    if(!map.isActive()) {
                        judge = false;
                        break;
                    }
                    this.position.setRow(i);
                    this.steps++;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);
                }
                break;
            case DOWN:
                for (int i = position.getRow()+1; i <= position.getRow() + steps; i++) {
                    if(!map.isActive()) {
                        judge = false;
                        break;
                    }
                    this.position.setRow(i);
                    this.steps++;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);

                }
                break;
            case LEFT:
                for (int i = position.getCol()-1; i >= position.getCol() - steps; i--) {
                    if(!map.isActive()) {
                        judge = false;
                        break;
                    }
                    this.position.setCol(i);
                    this.steps++;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);
                }
                break;
            case RIGHT:
                for (int i = position.getCol()+1; i <= position.getCol() + steps; i++) {
                    if(!map.isActive()) {
                        judge = false;
                        break;
                    }
                    this.position.setCol(i);
                    this.steps++;
                    score += map.hasTreasure(this.position);
                    map.update(this.position);
                }
                break;
        }
        return judge;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id == p.id;
    }
}
