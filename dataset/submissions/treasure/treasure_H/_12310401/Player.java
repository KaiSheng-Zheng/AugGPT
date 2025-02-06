public class Player {
    private static int id_cnt=0;
    private final int id;
    private int score;
    private int steps;
    private final int maxStepAllowed;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        id_cnt++;
        this.id=id_cnt;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=Integer.MAX_VALUE;
        steps=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id_cnt++;
        this.id=id_cnt;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        steps=0;
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
        for(int i=1;i<=steps;i++){
            if(this.steps==maxStepAllowed)return false;
            if(!map.isActive())return false;
            switch (direction){
                case UP -> {
                    if(position.getRow()-1>=0){
                        this.steps+=1;
                        position.setRow(position.getRow()-1);
                        score+=map.hasTreasure(position);
                        if(map.hasTreasure(position)!=0)map.update(position);
                    }
                    else return false;
                }
                case DOWN -> {
                    if(position.getRow()+1<map.getRows()) {
                        this.steps+=1;
                        position.setRow(position.getRow()+1);
                        score+=map.hasTreasure(position);
                        if(map.hasTreasure(position)!=0)map.update(position);
                    }
                    else return false;
                }
                case LEFT -> {
                    if(position.getCol()-1>=0){
                        this.steps+=1;
                        position.setCol(position.getCol()-1);
                        this.score+=map.hasTreasure(position);
                        if(map.hasTreasure(position)!=0)map.update(position);
                    }
                    else return false;
                }
                case RIGHT -> {
                    if(position.getCol()+1<map.getColumns()){
                        this.steps+=1;
                        position.setCol(position.getCol()+1);
                        score+=map.hasTreasure(position);
                        if(map.hasTreasure(position)!=0)map.update(position);
                    }
                    else return false;
                }
            }
            //System.out.println(this.id + " is at (" + position.getRow() + "," +position.getCol()+") score is "+score);
        }
        return true;
    }
    public boolean equals(Object player){
        Player player1 =(Player) player;
        return this.id==player1.getId();
    }
}
