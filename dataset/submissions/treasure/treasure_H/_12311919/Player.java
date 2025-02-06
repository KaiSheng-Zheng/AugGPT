public class Player {
    private static int id=0;
    private  int ID;
    private int score=0;
    private int steps;
    private final Position position;
    private final Map map;
    private int maxStepAllowed=-1;
    private int numberofsteps=0;
    public Player(Map map, Position initialPosition){
        this.position=initialPosition;
        this.map=map;
        id++;
        ID=id;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.position=initialPosition;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
        id++;
        ID=id;

    }

    public int getId() {
        return ID;
    }

    public int getScore() {
        return score;
    }

    public int getSteps() {
        setSteps(numberofsteps);
        return steps;
    }

    public Position getPosition() {

        return position;
    }
    public boolean move(Direction direction, int steps){
        if(!map.isActive())return false;
        if(maxStepAllowed!=-1){
            if(numberofsteps==maxStepAllowed)
            {return false;}
        }
        switch (direction){
            case UP -> {
                return Moveup(steps,map);
            }
            case DOWN -> {
                return Movedown(steps,map);
            }
            case LEFT -> {
                return Moveleft(steps,map);
            }
            case RIGHT -> {
                return Moveright(steps,map);
            }
        }
        return true;
    }
    private boolean Moveup(int steps,Map map){
        boolean b=false;
        Position position1=new Position(0,0);
        position1.setCol(position.getCol());
        position1.setRow(position.getRow());
        if(position.getRow()==0)
            return false;
        else if (maxStepAllowed==-1) {
            if(position.getRow()+Direction.UP.up()*steps>=0){
                b=true;
                numberofsteps+=steps;
                position.setRow(position.getRow()+Direction.UP.up()*steps);
            }else{
                steps=position.getRow();
                numberofsteps+=steps;
                position.setRow(0);
            }
        }else{
            if(numberofsteps+steps<=maxStepAllowed){
                if(position.getRow()+Direction.UP.up()*steps>=0){
                    b=true;
                    numberofsteps+=steps;
                    position.setRow(position.getRow()+Direction.UP.up()*steps);
                }else{
                    steps=position.getRow();
                    numberofsteps+=steps;
                    position.setRow(0);
                }
            }else {
                steps=maxStepAllowed-numberofsteps;
                if(position.getRow()+Direction.UP.up()*steps>=0){
                    numberofsteps+=steps;
                    position.setRow(position.getRow()+Direction.UP.up()*steps);
                }else{
                    steps=position.getRow();
                    numberofsteps+=steps;
                    position.setRow(0);
                }
            }

        }
        for (int i = position1.getRow(); i >=position.getRow(); i--) {
            Position position2=new Position(i,position1.getCol());
            score+=map.hasTreasure(position2);
            if(map.hasTreasure(position2)!=0)
            { map.update(position2);
            if(!map.isActive()){
                numberofsteps-=position2.getRow()-position.getRow();
                position.setRow(position2.getRow());
            }
            }
        }
        return b;
    }
    private boolean Movedown(int steps,Map map ){
        boolean b=false;
        Position position1=new Position(0,0);
        position1.setCol(position.getCol());
        position1.setRow(position.getRow());
        if(position.getRow()== map.getRows()-1)
            return false;
        else if (maxStepAllowed==-1) {
            if((position.getRow()+Direction.DOWN.down()*steps)<= map.getRows()-1){
                b=true;
                numberofsteps+=steps;
                position.setRow((position.getRow()+Direction.DOWN.down()*steps));
            }else{
                steps= map.getRows()-1-position.getRow();
                numberofsteps+=steps;
                position.setRow((position.getRow()+Direction.DOWN.down()*steps));
            }
        } else {
            if(numberofsteps+steps<=maxStepAllowed){
                if((position.getRow()+Direction.DOWN.down()*steps)<= map.getRows()-1){
                    b=true;
                    numberofsteps+=steps;
                    position.setRow((position.getRow()+Direction.DOWN.down()*steps));
                }else{
                    steps= map.getRows()-1-position.getRow();
                    numberofsteps+=steps;
                    position.setRow((position.getRow()+Direction.DOWN.down()*steps));
                }
            } else if (numberofsteps+steps>maxStepAllowed) {
                steps=maxStepAllowed-numberofsteps;
                if((position.getRow()+Direction.DOWN.down()*steps)<= map.getRows()-1){
                    numberofsteps+=steps;
                    position.setRow((position.getRow()+Direction.DOWN.down()*steps));
                }else{
                    steps= map.getRows()-1-position.getRow();
                    numberofsteps+=steps;
                    position.setRow((position.getRow()+Direction.DOWN.down()*steps));
                }
            }
        }
        for (int i = position1.getRow(); i <=position.getRow(); i++) {
            Position position2=new Position(i,position1.getCol());
            score+=map.hasTreasure(position2);
            if(map.hasTreasure(position2)!=0)
            { map.update(position2);
                if(!map.isActive()){
                    numberofsteps-=position.getRow()-position2.getRow();
                    position.setRow(position2.getRow());
                }}
        }
        return b;
    }
    private boolean Moveleft(int steps,Map map){
        boolean b=false;
        Position position1=new Position(0,0);
        position1.setCol(position.getCol());
        position1.setRow(position.getRow());
        if(position.getCol()==0)
            return false;
        else if (maxStepAllowed==-1) {
            if((position.getCol()+Direction.LEFT.left()*steps)>=0){
                b=true;
                numberofsteps+=steps;
                position.setCol((position.getCol()+Direction.LEFT.left()*steps));
            }else {
                steps=position.getCol();
                numberofsteps+=steps;
                position.setCol(0);
            }
        } else {
            if(numberofsteps+steps<=maxStepAllowed){
                if((position.getCol()+Direction.LEFT.left()*steps)>=0){
                    b=true;
                    numberofsteps+=steps;
                    position.setCol((position.getCol()+Direction.LEFT.left()*steps));
                }else {
                    steps=position.getCol();
                    numberofsteps+=steps;
                    position.setCol(0);
                }
            }else{
                steps=maxStepAllowed-numberofsteps;
                if((position.getCol()+Direction.LEFT.left()*steps)>=0){
                    numberofsteps+=steps;
                    position.setCol((position.getCol()+Direction.LEFT.left()*steps));
                }else {
                    steps=position.getCol();
                    numberofsteps+=steps;
                    position.setCol(0);
                }
            }

        }
        for (int i = position1.getCol(); i >=position.getCol(); i--) {
            Position position2=new Position(position.getRow(),i);
            score+=map.hasTreasure(position2);
            if(map.hasTreasure(position2)!=0)
            {map.update(position2);
                if(!map.isActive()){
                    numberofsteps-=position2.getCol()-position.getCol();
                    position.setCol(position2.getCol());
                }}
        }
        return b;
    }
    private boolean Moveright(int steps,Map map){
        boolean b=false;
        Position position1=new Position(0,0);
        position1.setCol(position.getCol());
        position1.setRow(position.getRow());
        if(position.getCol()== map.getColumns()-1)
            return false;
       if(maxStepAllowed==-1){
           if((position.getCol()+Direction.RIGHT.right()*steps)<= map.getColumns()-1){
               b=true;
               numberofsteps+=steps;
               position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
           }else{
               steps= map.getColumns()-1-position.getCol();
               numberofsteps+=steps;
               position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
           }
       }else {
           if(numberofsteps+steps<=maxStepAllowed){
               if((position.getCol()+Direction.RIGHT.right()*steps)<= map.getColumns()-1){
               b=true;
               numberofsteps+=steps;
               position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
           }else{
               steps= map.getColumns()-1-position.getCol();
               numberofsteps+=steps;
               position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
           }
           }else {
               steps=maxStepAllowed-numberofsteps;
               if((position.getCol()+Direction.RIGHT.right()*steps)<= map.getColumns()-1){
                   numberofsteps+=steps;
                   position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
               }else{
                   steps= map.getColumns()-1-position.getCol();
                   numberofsteps+=steps;
                   position.setCol((position.getCol()+Direction.RIGHT.right()*steps));
               }
           }

       }
        for (int i = position1.getCol(); i <=position.getCol(); i++) {
            Position position2=new Position(position.getRow(),i);
            score+=map.hasTreasure(position2);
            if(map.hasTreasure(position2)!=0)
            { map.update(position2);
                if(!map.isActive()){
                    numberofsteps-=position.getCol()-position2.getCol();
                    position.setCol(position2.getCol());
                }}
        }
        return b;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return (p.getId()==this.ID);
    }

    public void resetScore() {
        this.score =0;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
    public void resetsteps(){
        numberofsteps=0;
    }
    public String toString(){
        return String.format("id= %d score= %d steps= %d",getId(),getScore(),getSteps());
    }
}
