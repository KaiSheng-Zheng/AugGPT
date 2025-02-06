public class Player {
    private boolean cao = false;
    private final int id;
    private int score;
    private int steps;
    private int maxStepAllowed;
    private Position position;
    private Map map;
    public static int ids = 0;
    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        ids++;
        this.id = ids;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.cao = true;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        ids++;
        this.id = ids;
    }
    public boolean move(Direction direction, int steps){
        boolean can = true;
        boolean Suddenly = false;
        switch (direction){
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()){
                        Suddenly = true;
                        break;
                    }
                    if (cao && this.steps == maxStepAllowed){
                        can = false;
                    }
                    if (this.position.getCol() + 1 == map.getColumns() || !map.isActive()){
                        can = false;
                    }
                    if (can){
                        this.steps = this.steps + 1;
                        this.position.setCol(this.position.getCol()+1);
                        score = score + map.hasTreasure(this.position);
                            map.update(this.position);
                    }
                }
                break;
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()){
                        Suddenly = true;
                        break;
                    }
                    if (cao && this.steps == maxStepAllowed){
                        can = false;
                    }
                    if (this.position.getCol() == 0 || !map.isActive()) {
                        can = false;
                    }
                    if (can) {
                        this.steps = this.steps+1;
                        this.position.setCol(this.position.getCol() - 1);
                        score = score + map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
                break;
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()){
                        Suddenly = true;
                        break;
                    }
                    if (cao && this.steps == maxStepAllowed){
                        can = false;
                    }
                    if (this.position.getRow()+1 == map.getRows() || !map.isActive()) {
                        can = false;
                    }
                    if (can) {
                        this.steps = this.steps+1;
                        this.position.setRow(this.position.getRow() + 1);
                        score = map.hasTreasure(this.position) + score;
                        map.update(this.position);
                    }
                }
                break;
            }
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    if (!map.isActive()){
                        Suddenly = true;
                        break;
                    }
                    if (cao && this.steps == maxStepAllowed){
                        can = false;
                    }
                    if (this.position.getRow() == 0 || !map.isActive()){
                        can = false;
                    }
                    if (can){
                        this.steps = this.steps+1;
                        this.position.setRow(this.position.getRow()-1);
                        score = score + map.hasTreasure(this.position);
                        map.update(this.position);
                    }
                }
                break;
            }
        }
        if (Suddenly){return false;}
        else {return can;}
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.id == this.id){return true;}
        else {return false;}
    }
    public int getScore(){return score;}
    public int getSteps(){return steps;}
    public int getId(){return id;}
    public Position getPosition() {return position;}
}