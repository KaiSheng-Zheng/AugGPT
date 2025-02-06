public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maximunstep;

    public static int players=0;

    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        maximunstep=-1;
        players++;
        id=players;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        maximunstep=maxStepAllowed;
        players++;
        id=players;
    }

    public boolean move(Direction direction, int steps){
        int i,flag=0;
        int row=direction.getRow(),col=direction.getCol();
        int row2,col2;
        for(i=1;i<=steps;i++)
        {
            if(!map.isActive())return false;
            if(this.steps==this.maximunstep) return false;
            flag=0;
            row2=row+this.position.getRow();
            col2=col+this.position.getCol();
            if(row2>=0&&row2<=map.getRows()-1){
                if(col2>=0&&col2<=map.getColumns()-1){
                    this.position.setRow(row2);
                    this.position.setCol(col2);
                    score+=map.getTreasure(this.position);
                    flag=1;
                    this.steps++;

                }
            }
            if(flag==0){
                return false;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player x=(Player) player;
        if(this.id==x.getId())
        return true;
        else return false;
    }
    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public int getSteps() {
        return steps;
    }
}
