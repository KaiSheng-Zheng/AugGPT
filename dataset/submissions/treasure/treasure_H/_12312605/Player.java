public class Player {
    static int countId=0;
    private final int id=++countId;
    private int score=0;
    private int steps=0;
    private  Position position;
    private  Map map;
    private int maxStep=-1;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStep=maxStepAllowed;
    }

    public int getCountId() {
        return countId;
    }

    public boolean move(Direction direction, int steps){
        for(int i=1;i<=steps;i++){
            if(!map.isActive()){
                return false;
            }
            if(this.steps==maxStep){
                return false;
            }
            switch(direction) {
                case UP:
                    if(position.getRow()-1>=0){
                        position.setRow(position.getRow()-1);
                        this.steps++;
                        if(map.hasTreasure(position)>0){
                            score+=map.hasTreasure(position);
                            map.update(position);
                        }
                    }else {
                        return false;
                    }
                    break;
                case DOWN:
                    if(position.getRow()+1<=map.getRows()-1){
                        position.setRow(position.getRow()+1);
                        this.steps++;
                        if(map.hasTreasure(position)>0){
                            score+=map.hasTreasure(position);
                            map.update(position);
                        }
                    }else {
                        return false;
                    }


                    break;
                case LEFT:
                    if(position.getCol()-1>=0){
                        position.setCol(position.getCol()-1);
                        this.steps++;
                        if(map.hasTreasure(position)>0){
                            score+=map.hasTreasure(position);
                            map.update(position);
                        }
                    }else {
                        return false;
                    }


                    break;
                case RIGHT:
                    if(position.getCol()+1<=map.getColumns()-1){
                        position.setCol(position.getCol()+1);
                        this.steps++;
                        if(map.hasTreasure(position)>0){
                            score+=map.hasTreasure(position);
                            map.update(position);
                        }
                    }else {
                        return false;
                    }


                    break;
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player player1=(Player) player;
        if(player1==null){
            return false;
        }
        else if(this.id==player1.id){
            return true;
        }else {
            return false;
        }
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