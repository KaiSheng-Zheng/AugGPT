public class Player {
    public static int cnt=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=9999;
    public Player(Map map,Position initialPos){
        this.map = map;
        this.position=initialPos;
        id=cnt;
        cnt++;
    }
    public Player(Map map,Position initialPos,int maxStepAllowed){
        this.map=map;
        this.position=initialPos;
        this.maxStepAllowed=maxStepAllowed;
        id=cnt;
        cnt++;
    }
    public int getScore(){
        return this.score;
    }
    public int getId(){
        return this.id;
    }
    public int getSteps(){
        return this.steps;
    }
    public Position getPosition(){
        return this.position;
    }
    public int getMaxStepAllowed(){
        return maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        boolean bounded=true;
        if(this.steps==maxStepAllowed|| !map.isActive()){
            bounded=false;
        }else {
            a: if (direction == Direction.UP) {
                for (int i = 0; i < steps; i++) {
                    if(this.steps==maxStepAllowed) {
                        bounded=false;
                        break a;
                    }
                    if (position.getRow() == 0) {
                        bounded = false;
                        break a;
                    } else {
                        position.setRow(position.getRow() - 1);
                        bounded = true;
                        this.steps++;
                    }
                    score += map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        bounded = false;
                        break a;
                    }
                }
            } else b: if (direction == Direction.DOWN) {
                for (int i = 0; i < steps; i++) {
                    if(this.steps==maxStepAllowed) {
                        bounded=false;
                        break b;
                    }
                    if (position.getRow() == map.getRows() - 1) {
                        bounded = false;
                        break b;
                    } else {
                        position.setRow(position.getRow() + 1);
                        bounded = true;
                        this.steps++;
                    }
                    score += map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        bounded = false;
                        break b;
                    }
                }
            } else c: if (direction == Direction.LEFT) {
                for (int i = 0; i < steps; i++) {
                    if(this.steps==maxStepAllowed) {
                        bounded=false;
                        break c;
                    }
                    if (position.getCol() == 0) {
                        bounded = false;
                        break c;
                    } else {
                        position.setCol(position.getCol() - 1);
                        bounded = true;
                        this.steps++;
                    }
                    score += map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        bounded = false;
                        break c;
                    }
                }
            } else d: if (direction == Direction.RIGHT) {
                for (int i = 0; i < steps; i++) {
                    if(this.steps==maxStepAllowed) {
                        bounded=false;
                        break d;
                    }
                    if (position.getCol() == map.getColumns() - 1) {
                        bounded = false;
                        break d;
                    } else {
                        position.setCol(position.getCol() + 1);
                        bounded = true;
                        this.steps++;
                    }
                    score += map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        bounded = false;
                        break d;
                    }
                }
            }
        }
        return bounded;
    }
    public boolean equals(Object player){
        boolean equal=false;
        Player player1=(Player) player;
        if(player1.id==this.id){
            equal=true;
        }
        return equal;
    }
}
