public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int theMaxStep;
    private int uid;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.id=uid+1;

        this.score=0;
        this.steps=0;
        theMaxStep=1000000;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.id=uid+1;

        this.score=0;
        this.steps=0;
        theMaxStep=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        if(     map.isActive()){
            if(     position.getRow()+(direction.getRow()*steps)<map.getRows()&&
                    position.getRow()+(direction.getRow()*steps)>=0&&
                    position.getCol()+(direction.getCol()*steps)<map.getColumns()&&
                    position.getCol()+(direction.getCol()*steps)>=0&&
                    this.steps+steps<=theMaxStep

            ){
                for (int i =0 ; i < steps; i++) {
                    position.setCol(position.getCol()+direction.getCol());
                    position.setRow(position.getRow()+direction.getRow());
                    if(map.hasTreasure(position)!=0){
                        this.score=this.score+map.hasTreasure(position);
                        map.update(position);
                    }
                    this.steps++;
                    if(map.isActive()){
                        }else {
                            break;
                        }
                }

                return true;
            }else {
                if(position.getRow()+(direction.getRow()*steps)>=map.getRows()){
                    for (int i =0 ; i <steps; i++) {
                        position.setCol(position.getCol()+direction.getCol());
                        position.setRow(position.getRow()+direction.getRow());
                        if(map.hasTreasure(position)!=0){
                            this.score=this.score+map.hasTreasure(position);
                            map.update(position);
                        }
                        this.steps++;
                        if(this.steps==this.theMaxStep){
                            break;
                        }
                        if(position.getRow()==map.getRows()-1){
                            break;
                        }
                        if(map.isActive()){
                        }else {
                            break;
                        }
                    }

                    

                } else if (position.getRow()+(direction.getRow()*steps)<0) {
                    for (int i =0 ; i <steps; i++) {
                        position.setCol(position.getCol()+direction.getCol());
                        position.setRow(position.getRow()+direction.getRow());
                        if(map.hasTreasure(position)!=0){
                            this.score=this.score+map.hasTreasure(position);
                            map.update(position);
                        }
                        this.steps++;
                        if(this.steps==this.theMaxStep){
                            break;
                        }
                        if(position.getRow()==0){
                            break;
                        }
                        if(map.isActive()){
                        }else {
                            break;
                        }
                    }

                   
                } else if (position.getCol()+(direction.getCol()*steps)>=map.getColumns()) {
                    for (int i =0 ; i <steps; i++) {
                        position.setCol(position.getCol()+direction.getCol());
                        position.setRow(position.getRow()+direction.getRow());
                        if(map.hasTreasure(position)!=0){
                            this.score=this.score+map.hasTreasure(position);
                            map.update(position);
                        }
                        this.steps++;
                        if(this.steps==this.theMaxStep){
                            break;
                        }
                        if(position.getCol()==map.getColumns()-1){
                            break;
                        }
                        if(map.isActive()){
                        }else {
                            break;
                        }
                    }

                    
                }else if(position.getCol()+(direction.getCol()*steps)<0){
                    for (int i =0 ; i <steps; i++) {
                        position.setCol(position.getCol()+direction.getCol());
                        position.setRow(position.getRow()+direction.getRow());
                        if(map.hasTreasure(position)!=0){
                            this.score=this.score+map.hasTreasure(position);
                            map.update(position);
                        }
                        this.steps++;
                        if(this.steps==this.theMaxStep){
                            break;
                        }
                        if(position.getCol()==0){
                            break;
                        }
                        if(map.isActive()){
                        }else {
                            break;
                        }
                    }

                   
                }else {
                    for (int i =0 ; i <theMaxStep-this.steps; i++) {
                        position.setCol(position.getCol()+direction.getCol());
                        position.setRow(position.getRow()+direction.getRow());
                        if(map.hasTreasure(position)!=0){
                            this.score=this.score+map.hasTreasure(position);
                            map.update(position);
                        }
                        this.steps++;
                        if(this.steps==this.theMaxStep){
                            break;
                        }
                        if(map.isActive()){
                        }else {
                            break;
                        }
                    }
                }
                return false;
            }
        }else {
            return false;
        }
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(p.getId()==this.id){
            return true;
        }else {
            return false;
        }
    }

    public void setUid(int uid){
        this.uid=uid;
    }
    public int getScore(){
        return this.score;
    }
    public int getId(){
        return this.id;
    }
    public int getSteps(){
        return this.steps;
    }
    public Position getPosition(){
        return this.position;
    }


}
