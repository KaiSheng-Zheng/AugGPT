import java.util.ArrayList;

public class Player {
    private final int id;
    private static int idd=1;
    private int score=0;
    private int steps=0;
    private Position position;
    private static Map map;
    private int maxStepAllowed=-1;


    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.id=idd;
        idd++;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        this.id=idd;
        idd++;
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
        Boolean ifcan=true;
            int x=this.position.getRow();
            int y=this.position.getCol();
            for(int i=0;i<steps;i++){
                y+=direction.getCol();
                x+= direction.getRow();
                if (y>=map.getColumns()||x>=map.getRows()||y<0||x<0||(maxStepAllowed!=-1&&this.steps>=maxStepAllowed)||map.isActive()==false){
                    ifcan=false;
                    break;
                }

                    score+=map.getMap()[x][y];
                    setPosition(x,y);
                    map.update(position);
                    this.steps++;
                    ifcan=true;
                }


        return ifcan;
    }
        public boolean equals(Object player) {
            Player p = (Player) player;
            return this.id==p.id;
        }


    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPosition(int x,int y) {
        this.position = new Position(x,y);
    }
}
