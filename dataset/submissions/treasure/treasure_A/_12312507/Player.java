public class Player {
    private static int tot=0;
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private int maxStepAllowed;
    private Map map;
    public Player(Map map, Position initialPosition){
        id=++tot;
        this.map=map;
        position=initialPosition;
        maxStepAllowed=-1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id=++tot;
        this.map=map;
        position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }
    public int getId(){return id;}
    public int getScore(){return score;}
    public int getSteps(){return steps;}
    public Position getPosition(){return position;}
    public boolean move(Direction direction,int steps){
        for(int i=1;i<=steps;++i){
            Position now=new Position(position.getRow()+direction.getDr(),position.getCol()+direction.getDc());
            if(map.isActive()==false||this.steps==maxStepAllowed||map.isIn(now)==false)
                return false;
            position=now;
            score+=map.hasTreasure(position);
            ++this.steps;//
            map.update(position);
        }
        return true;
    }
    public String toString(){return String.format("%d",id);}
    public boolean equals(Object player){
        if(player instanceof Player)
            return this.toString().equals(player.toString());
        return false;
    }
    public boolean compareTo(Player player){
        if(score!=player.score)return score>player.score;
        return steps<player.steps;
    }
}