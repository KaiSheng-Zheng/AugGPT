public class Player {
    private final int id;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
    static int count;
   private int maxStepAllowed;

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public static void setCount(int count) {
        Player.count = count;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public static int getCount() {
        return count;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSteps() {
        return steps;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getId() {
        return id;
    }
    public Player(Map map, Position initialPosition){
        this.id=++count;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=++count;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
       boolean re=true;
        for(int i=0;i<steps;i++){
           boolean b1=getMap().isActive();
           boolean b2=getSteps()<getMaxStepAllowed();
           int afterrow=getPosition().getRow()+ direction.getRe();
           int aftercol=getPosition().getCol()+direction.getCo();
           boolean b3=(afterrow>-1)&&(afterrow<getMap().getRows());
           boolean b4=(aftercol>-1)&&(aftercol<getMap().getColumns());
           boolean doit=b1&&b2&&b3&&b4;
           if(!doit) {
               re = false;
               break;
           }if(doit){
               this.steps++;
               setPosition(new Position(afterrow,aftercol));
               for(Treasure tre:map.getTreasures()){
                   if(tre.getPosition().equals(this.position)){
                       this.score+=tre.getAnother();
                   }
               }
               map.update(this.position);
           }
        }
        return re;
    }
    public boolean equals(Object player){
        Player p=(Player)player;
        return p.getId()==this.id;
    }


}
