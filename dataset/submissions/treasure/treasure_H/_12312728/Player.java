public class Player {
    private final int id;
    private int score;
    private int steps;
    private final int maxStepAllowed;
    private Position position;
    private Map map;
    private static int mark=0;
    public Player(Map map,Position initialPosition){
        this.id=mark;
        mark++;
        this.map = map;
        this.position=initialPosition;
        this.score=this.map.hasTreasure(position);
        this.map.update(position);
        this.maxStepAllowed=-1;
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.id=mark;
        mark++;
        this.map = map;
        this.position=initialPosition;
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
    public boolean move(Direction direction,int steps){
        for (int i=0;i<steps;i++){
            if (this.steps==maxStepAllowed||!map.isActive())
                return false;
            if (direction.isDirect()?position.getRow()+direction.getLen()<0||position.getRow()+direction.getLen()>=map.getRows():position.getCol()+direction.getLen()<0||position.getCol()+direction.getLen()>=map.getColumns())
                return false;
            this.steps++;
            if (direction.isDirect())
                position.setRow(position.getRow()+direction.getLen());
            else
                position.setCol(position.getCol()+direction.getLen());
            this.score+=map.hasTreasure(position);
            map.update(position);
        }
        return true;
    }
    public boolean equals(Object player) {
        return player instanceof Player&&this.id == ((Player) player).getId();
    }
}
