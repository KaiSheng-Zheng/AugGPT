public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;

    public static int ide=0;
    public int limit;
    private boolean ifLimit;
    public Player(Map map, Position initialPosition){
        ifLimit=false;
        this.position=new Position(initialPosition.getRow(),initialPosition.getCol() );
        this.map=map;
        ide+=1;
        this.id=ide;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        ifLimit=true;
        this.limit=maxStepAllowed;
        this.position=new Position(initialPosition.getRow(),initialPosition.getCol() );
        this.map=map;
        ide+=1;
        this.id=ide;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public int getSteps() {
        return steps;
    }

    public boolean move(Direction direction, int steps){
        if(map.isActive()){

            Position p=new Position(position.getRow(),position.getCol());
            boolean lim=true;
            if(ifLimit){

                boolean ok=true;

                if(this.steps>=this.limit){
                    ok=false;
                }



                for(int i=0;i<steps && lim && ok && map.isActive();i++){

                    switch (direction){
                        case UP :
                            if(p.getRow()-1>=0){
                                position.setRow(p.getRow()-1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);

                            }else{
                                lim=false;
                            }
                            break;
                        case DOWN:
                            if(p.getRow()+1<=map.getRows()-1){
                                position.setRow(p.getRow()+1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                            break;
                        case LEFT:
                            if(p.getCol()-1>=0){
                                position.setCol(p.getCol()-1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                            break;
                        case RIGHT:
                            if(p.getCol()+1<=map.getColumns()-1){
                                position.setCol(p.getCol()+1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                    }
                    if(map.isActive()){

                    }else{
                        return false;
                    }
                    p.setRow(position.getRow());
                    p.setCol(position.getCol());


                    if(this.steps>=this.limit){
                        ok=false;
                    }

                }
                if(lim && ok && map.isActive()){
                    return true;
                }else{
                    return false;
                }
            }else{

                for(int i=0;i<steps && lim && map.isActive();i++){
                    switch (direction){
                        case UP :
                            if(p.getRow()-1>=0){
                                position.setRow(p.getRow()-1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                            break;
                        case DOWN:
                            if(p.getRow()+1<=map.getRows()-1){
                                position.setRow(p.getRow()+1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                            break;
                        case LEFT:
                            if(p.getCol()-1>=0){
                                position.setCol(p.getCol()-1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                            break;
                        case RIGHT:
                            if(p.getCol()+1<=map.getColumns()-1){
                                position.setCol(p.getCol()+1);
                                this.steps+=1;
                                this.score+=map.hasTreasure(position);
                                map.update(position);
                            }else{
                                lim=false;
                            }
                    }
                    p.setRow(position.getRow());
                    p.setCol(position.getCol());
                    if(map.isActive()){

                    }else{
                        return false;
                    }
                }
                if(lim && map.isActive()){
                    return true;
                }else{
                    return false;
                }
            }



        }

        return false;

    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean equals(Object player){
        Player p=(Player) player;
        if(p.getId()==this.id){
            return true;
        }
        return false;
    }






}
