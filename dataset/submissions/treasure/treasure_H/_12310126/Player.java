public class Player {
    private   int id;
    private  int score;
    private  int steps=0;
    private int maxStepAllowed=-1;
    private  Position position;
    private Map map;


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
    public Player(Map map,Position initialPosition){
        this.map=map;
        this.position=initialPosition;

    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;

    }
    public boolean move(Direction direction,int steps){


        int count =0;
        int i=0;
        boolean con =true;
        while(i<steps&&con){

            switch (direction){
                case UP : {if(position.getRow()==0||maxStepAllowed- this.steps -count==0||!map.isActive()){con =false;break;}
                    else {
                        position.setRow(position.getRow()-1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        count++;}}
                break;
                case DOWN : {if (position.getRow()== map.getRows()-1||maxStepAllowed- this.steps -count==0||!map.isActive()){con=false;}
                    else{
                        position.setRow(position.getRow()+1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        count++;}}
                break;
                case LEFT :
                {if(position.getCol()==0||maxStepAllowed- this.steps -count==0||!map.isActive()){con=false;}
                    else {
                        position.setCol(position.getCol()-1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        count++;}}
                break;
                case RIGHT : {if(position.getCol()==map.getColumns()-1||maxStepAllowed- this.steps -count==0||!map.isActive()){con=false;}
                    else {
                        position.setCol(position.getCol()+1);
                        score+=map.hasTreasure(position);
                        map.update(position);
                        count++;}}
                break;
            }
            i++;
        }
        this.steps +=count;
        return con;

    }
    public boolean equals(Object player){
        if (player == null) return false;

       Player p =(Player) player;
        return p.getId() == this.id;

    }

    public void setId(int id) {
        this.id = id;
    }
}
