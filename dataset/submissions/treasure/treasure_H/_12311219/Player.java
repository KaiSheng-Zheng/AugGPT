import java.util.Objects;

import static java.lang.Math.random;

public class Player {

    private int score;  
    private final int id=(int)(random()*10000);
    private int steps;  
    private Position pos;  
    private Map map;  
    private int maxStepAllowed;
private int trueorfalse;

    public Player( Map map, Position initialPos, int maxStepAllowed) {
        this.map = map;
        this.pos = initialPos;
        this.steps = 0;
        this.score = 0;
        this.maxStepAllowed = maxStepAllowed;
    }
public Player( Map map, Position initialPos) {

        this.map = map;
        this.pos = initialPos;
        this.steps = 0;
        this.score = 0;
        this.maxStepAllowed=100000000;

    }

    
    public int getScore() {
        return score;
    }


    public int getSteps() {
        return steps;
    }

 
    public Position getPosition() {
        return pos;
    }

    
    public boolean move(Direction direction, int steps) {
        trueorfalse=1;
        if (!map.isActive() || this.steps == maxStepAllowed ) {
            return false;
        }


           else{  int newRow = pos.getRow();
               int newCol = pos.getCol();
               int initialRow=pos.getRow();
               int initialCol=pos.getCol();
            Position temposition=new Position(pos.getRow(), pos.getCol());

            if(direction==Direction.UP){
                int currentMaxsteps1=maxStepAllowed-this.steps;
                int whetheroutbound1=pos.getRow()+1;
                newRow-=steps;
                if(newRow<0&&currentMaxsteps1>=steps||newRow<0&&currentMaxsteps1<steps&&whetheroutbound1<=currentMaxsteps1)
                {trueorfalse=0;
                    newRow=0;
                
                    for(int i=1;i<=initialRow-newRow&& map.isActive();i++){
                        temposition=new Position(initialRow-i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                }
                else if(newRow>=0&&currentMaxsteps1<steps||newRow<0&&currentMaxsteps1<steps&&currentMaxsteps1>=whetheroutbound1)
                {trueorfalse=0;
                 

                    for(int i=1;i<=currentMaxsteps1&& map.isActive();i++){
                        temposition=new Position(initialRow-i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                }
                else{
                    for(int i=1;i<=steps&& map.isActive();i++){
                        temposition=new Position(initialRow-i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                }}



            if(direction==Direction.DOWN){
                newRow+=steps;
                int currentMaxsteps2=maxStepAllowed-this.steps;
                int whetheroutbound2=map.getRows()-1-pos.getRow();
                if(newRow> map.getRows()-1&&currentMaxsteps2>=steps||newRow>map.getRows()-1&&currentMaxsteps2<steps&&whetheroutbound2<=currentMaxsteps2)
                {trueorfalse=0;
                    
                    newRow= map.getRows()-1;
                    for(int i=1;i<=newRow-initialRow&& map.isActive();i++){
                        temposition=new Position(initialRow+i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                } else if (newRow <= map.getRows()-1 && currentMaxsteps2 < steps || newRow > map.getRows()-1 && currentMaxsteps2<steps&&whetheroutbound2>=currentMaxsteps2) {
                    trueorfalse=0;
                   

                    for(int i=1;i<=currentMaxsteps2&& map.isActive();i++){
                        temposition=new Position(initialRow+i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    } 
                } else{

                    for(int i=1;i<=steps&& map.isActive();i++){
                        temposition=new Position(initialRow+i, pos.getCol());
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                }}




            if(direction==Direction.LEFT)
            {newCol-=steps;
                int currentMaxsteps3=maxStepAllowed-this.steps;
                int whetheroutbound3=pos.getCol()+1;
                if(newCol< 0&&currentMaxsteps3>=steps||newCol<0&&currentMaxsteps3<steps&&whetheroutbound3<=currentMaxsteps3)
                {trueorfalse=0;
                    newCol=0;
                    for(int i=1;i<=initialCol-newCol&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol-i);
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                } else if (newCol>=0&&currentMaxsteps3<steps||newCol<0&&currentMaxsteps3<steps&&currentMaxsteps3<=whetheroutbound3) {
                    trueorfalse=0;
                   

                    for(int i=1;i<=currentMaxsteps3&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol-i);


                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
                } else{

                    for(int i=1;i<=steps&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol-i);
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }  
                }
            }



            if(direction==Direction.RIGHT){
                newCol+=steps;
                int currentMaxsteps4=maxStepAllowed-this.steps;
                int whetheroutbound4=map.getColumns()-1-pos.getCol();
                if(newCol>map.getColumns()-1&&currentMaxsteps4>=steps||newCol> map.getColumns()-1&&currentMaxsteps4<steps&&whetheroutbound4<=currentMaxsteps4)
                {trueorfalse=0;
                    newCol= map.getColumns()-1;
                    for(int i=1;i<=newCol- initialCol&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol+i);
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;

                      
                    }
                }
                else if(newCol<=map.getColumns()-1&&currentMaxsteps4<steps||newCol>map.getColumns()-1&&currentMaxsteps4<steps&&currentMaxsteps4<=whetheroutbound4)
                { trueorfalse=0;
                  

                    for(int i=1;i<=currentMaxsteps4&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol+i);
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;

                    }
                }
                else{
                    for(int i=1;i<=steps&& map.isActive();i++){
                        temposition=new Position(pos.getRow(), initialCol+i);
                        int treasureScore = map.hasTreasure(temposition);
                        score += treasureScore;
                        if (treasureScore > 0) {
                            map.update(temposition);}
                        this.steps++;this.pos=temposition;
                    }
            }







           } if(trueorfalse==0){return false;}
            else{return true;}}



    }

    public int getId(){return this.id;}
    public boolean equals(Object player) {
        Player s=(Player) player;
        if(s.getId()==id){
            return true;
        }return false;
    }



 
    }

