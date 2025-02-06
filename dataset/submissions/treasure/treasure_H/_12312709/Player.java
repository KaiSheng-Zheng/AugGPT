import java.util.Random;
public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private final int maxStepsAllowed;

    Random ra = new Random();
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.score=0;
        this.steps=0;
        this.maxStepsAllowed=-1;
        this.id= ra.nextInt(1000000);
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.score=0;
        this.maxStepsAllowed=maxStepAllowed;
        this.id= ra.nextInt(1000000);
    }

    public int getId() {
        return id;
    }

    public Map getMap() {
        return map;
    }

    public Position getPosition() {
        return position;
    }

    public boolean move(Direction direction, int steps){
        int dRow,dCol;
        if(direction==Direction.UP){
            dRow=-1;
            dCol=0;
        } else if (direction==Direction.DOWN){
            dRow=1;
            dCol=0;
        } else if (direction==Direction.LEFT){
            dRow=0;
            dCol=-1;
        } else {
            dRow=0;
            dCol=1;
        }
        for (int i = 0; i < steps; i++) {
            if(!this.map.isActive())
                return false;
            if(this.steps>=maxStepsAllowed&&maxStepsAllowed!=-1)
                return false;
            if(this.position.getRow()+dRow>this.map.getRows()||this.position.getCol()+dCol>this.map.getColumns()||this.position.getRow()+dRow<0||this.position.getCol()+dCol<0)
                return false;
            this.position.setRow(this.position.getRow()+dRow);
            this.position.setCol(this.position.getCol()+dCol);
            int dScore = map.hasTreasure(this.position);
            if(dScore!=0){
                map.update(this.position);
            }
            this.score+=dScore;
            this.steps++;
        }
        return true;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        return steps;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.id;
    }
}
