public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    public static int n=0;
    private int maxStepAllowed=-1;
    public Player( Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        n++;
        this.id=n;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        n++;
        this.id=n;
    }
    public boolean move(Direction direction, int steps){
        boolean w=true;
        if(maxStepAllowed!=-1){
            if(this.steps>=this.maxStepAllowed){
                w=false;
            }
            else{
                for (int i=1;i<=steps;i++) {
                    if(!map.isActive()){
                        w=false;
                        break;
                    }
                    if(this.steps>=this.maxStepAllowed||position.getRow()+direction.getY()>=map.getRows()||position.getRow()+direction.getY()<0||position.getCol()+direction.getX()>=map.getColumns()||position.getCol()+direction.getX()<0){
                        w=false;
                        break;
                    }else {
                        position.setRow(position.getRow()+direction.getY());
                        position.setCol(position.getCol()+direction.getX());
                        this.steps++;
                    }for(int a=0;a<map.getTreasures().length;a++){
                        if(position.getCol()==map.getTreasures()[a].getPosition().getCol()&&position.getRow()==map.getTreasures()[a].getPosition().getRow()){
                            score+=map.getTreasures()[a].getScore();
                            map.getTreasures()[a].setScore(0);
                        }
                    }
                }
            }
        }else {
            for (int i=1;i<=steps;i++) {
                if(!map.isActive()){
                    w=false;
                    break;
                }
                if(position.getRow()+direction.getY()>=map.getRows()||position.getRow()+direction.getY()<0||position.getCol()+direction.getX()>=map.getColumns()||position.getCol()+direction.getX()<0){
                    w=false;
                    break;
                }else {
                    position.setRow(position.getRow()+direction.getY());
                    position.setCol(position.getCol()+direction.getX());
                    this.steps++;
                }for(int a=0;a<map.getTreasures().length;a++){
                    if(position.getCol()==map.getTreasures()[a].getPosition().getCol()&&position.getRow()==map.getTreasures()[a].getPosition().getRow()){
                        score+=map.getTreasures()[a].getScore();
                        map.getTreasures()[a].setScore(0);
                    }
                }
            }
        }
        return w;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        return this.id==p.id;
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
}