public class Player {
    public static int ids = 0;
    private final int id;  
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = 2147483647;
        this.id = ids;
        ids++;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        this.id = ids;
        ids++;
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

    public boolean equals(Object Player){
        Player p = (Player)Player;
        return p.getId() == this.getId();
    }

    public boolean move(Direction direction, int steps){
         //first check map is active


        
        for (int i = 1; i <= steps; i++) {
            if(!map.isActive())return false;
            if(this.steps + 1 > maxStepAllowed)return false; //second check if player has steps to move
            switch (direction) {
            case UP:
                if(position.getRow()-1<0)return false;
                this.position.setRow(position.getRow()-1);
                if (map.hasTreasure(position)!=0) {
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                this.steps++;
                break;
            case DOWN:
                if(position.getRow()+1>map.getRows())return false;
                this.position.setRow(position.getRow()+1);
                if (map.hasTreasure(position)!=0) {
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                this.steps++;
                break;
            case LEFT:
                if(position.getCol()-1<0)return false;
                this.position.setCol(position.getCol()-1);
                if (map.hasTreasure(position)!=0) {
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                this.steps++;
                break;
            case RIGHT:
                if(position.getCol()+1>map.getColumns())return false;
                this.position.setCol(position.getCol()+1);
                if (map.hasTreasure(position)!=0) {
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                this.steps++;
                break;
            default:
                break;
            }
        
        }
        return true;
        
    }
}
