public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStep=Integer.MAX_VALUE;
    static int count=0;
    public Position getPosition(){
        return position;
    }


    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }public void setId(int id){

    }

    public int getSteps() {
        return steps;
    }

    public Player(Map map, Position initialPosition){
        this.id=++count;
        this.map=map;
        this.position=initialPosition;
        this.score=0;this.steps=0;
    }


    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=++count;
        this.map=map;
        this.position=initialPosition;
        this.maxStep=maxStepAllowed;
        this.score=0;this.steps=0;


    }public boolean move(Direction direction,int steps){
        if(direction==Direction.UP) {int i=1;
            while ( i <= steps) {
                if (!map.isActive()) {
                    return false;
                } else {
                    if (position.getRow() - 1 < 0) {
                        return false;
                    } else {
                        if (this.steps < maxStep) {
                            position.setRow(position.getRow() - 1);
                            this.steps=this.steps+1;
                            for (int a = 0; a < map.getTreasureArraylist().size(); a++) {
                                if (position.getRow() ==this.map.getTreasureArraylist().get(a).getPosition().getRow() &&
                                        position.getCol() == this.map.getTreasureArraylist().get(a).getPosition().getCol()) {
                                    this.score = this.score + this.map.getTreasureArraylist().get(a).getScore();
                                    map.update(this.map.getTreasureArraylist().get(a).getPosition());
                                    if(i==steps){
                                        return true;
                                    }
                                    }
                                }
                            }
                         else {
                            return false;
                        }
                    }
                }i++;
            }
        }if(direction==Direction.DOWN){int i=1;
            while(i<=steps){
                if(!map.isActive()){
                    return false;
                }else{
                    if(position.getRow()+1>map.getRows()-1){
                        return false;
                    }else{
                        if(this.steps<maxStep){
                            position.setRow(position.getRow()+1);
                            this.steps=this.steps+1;
                            for(int a=0;a<map.getTreasureArraylist().size();a++){
                                if(position.getRow() ==this.map.getTreasureArraylist().get(a).getPosition().getRow() &&
                                        position.getCol() == this.map.getTreasureArraylist().get(a).getPosition().getCol()){
                                    this.score=this.score+this.map.getTreasureArraylist().get(a).getScore();
                                    map.update(this.map.getTreasureArraylist().get(a).getPosition());
                                    if(i==steps){
                                        return true;
                                    }
                                }
                            }
                        }else{
                            return false;
                        }
                    }
                }i++;
            }
        }if(direction==Direction.RIGHT) {int i=1;
            while (  i <= steps ) {
                if (!map.isActive()) {
                    return false;
                } else {
                    if (position.getCol() + 1 > map.getColumns()-1) {
                        return false;
                    } else {
                        if (this.steps < maxStep) {
                            position.setCol(position.getCol() + 1);
                            this.steps=this.steps+1;
                            for (int a = 0; a < map.getTreasureArraylist().size(); a++) {
                                if (position.getRow() == this.map.getTreasureArraylist().get(a).getPosition().getRow() &&
                                        position.getCol() == this.map.getTreasureArraylist().get(a).getPosition().getCol()) {
                                    this.score = this.score + this.map.getTreasureArraylist().get(a).getScore();
                                    map.update(this.map.getTreasureArraylist().get(a).getPosition());
                                    if(i==steps){
                                        return true;
                                    }
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                }i++;
            }
        }if(direction==Direction.LEFT){int i=1;
            while(i<=steps){
                if(!map.isActive()){
                    return false;
                }else{
                    if(position.getCol()-1<0){
                        return false;
                    }else{
                        if(this.steps<maxStep){
                            position.setCol(position.getCol() - 1);
                            this.steps=this.steps+1;
                            for (int a = 0; a < map.getTreasureArraylist().size(); a++){
                                if (position.getRow() == this.map.getTreasureArraylist().get(a).getPosition().getRow() &&
                                        position.getCol() == this.map.getTreasureArraylist().get(a).getPosition().getCol()){
                                    this.score = this.score + this.map.getTreasureArraylist().get(a).getScore();
                                    map.update(this.map.getTreasureArraylist().get(a).getPosition());
                                    if(i==steps){
                                        return true;
                                    }

                                }

                            }

                        }else{
                            return false;
                        }
                    }
                }i++;
            }

        }return true;


    }public boolean equals(Object player){
        Player p=(Player)player;
        return this.id==p.id;
    }

}
