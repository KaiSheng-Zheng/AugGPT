public class Player {
    private final int id;

    private static int playerCnt;
    public static int getPlayerCnt(){
        return playerCnt;
    }

    public int getId() {
        return id;
    }

    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    private int steps;

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }
    private int maxStepAllowed=Integer.MAX_VALUE;

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        playerCnt++;
        this.id=playerCnt;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id=playerCnt;
    }
    public boolean move(Direction direction, int steps){
        for(int i = 0; i<steps; i++){
            if (!getMap().isActive()){
                return false;
            }
            if (this.steps>=maxStepAllowed){
                return false;
            }
            switch (direction){
                case UP:if (position.getRow()==0){
                    return false;
                }else {
                    position.setRow(position.getRow()-1);
                }
                break;
                case DOWN:if (position.getRow()==map.getRows()-1){
                    return false;
                }else {
                    position.setRow(position.getRow()+1);
                }
                break;
                case LEFT:if (position.getCol()==0){
                    return false;
                }else {
                    position.setCol(position.getCol()-1);
                }
                break;
                case RIGHT:if (position.getCol()==map.getColumns()-1){
                    return false;
                }else {
                    position.setCol(position.getCol()+1);
                }
                break;
            }
            score =this.getScore()+map.hasTreasure(this.position);
            map.update(position);
            this.steps=this.steps+1;
        }
        return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.getId() == p.getId();
    }
}