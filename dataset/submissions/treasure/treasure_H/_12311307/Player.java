public class Player {


    private final int id ;
    private int score;

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public int getStep() {
        return step;
    }

    public Position getPosition() {
        return position;
    }

    private int step;
    private Position position;
    private Map map;
    private int maxStepAllowed;
    static int count=0;

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int steps =0;
    public Player(Map map, Position initialPosition){
        this.id= ++count;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=-1;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id= ++count;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int step){
        boolean t=true;
        int up=position.getRow();
        int down=map.getRows()-position.getRow();
        int left=position.getCol();
        int right=map.getColumns()-position.getCol();
        if (!map.isActive()){
            t= false;
        }
        else {if (maxStepAllowed>0){
            if (step >maxStepAllowed)t= false;
            else {switch (direction){
                case UP -> {
                    if (up==0){t= false;break;}
                    if (step >up){
                        for (int i = 0; i <up; i++) {
                            if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()-1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()-1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case DOWN ->{
                    if (down==0){t= false;break;}
                    if (step >down){
                        for (int i = 0; i < down; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()+1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()+1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case LEFT -> {
                    if (left==0){t= false;break;}
                    if (step >left){
                        for (int i = 0; i < left; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()-1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()-1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case RIGHT -> {
                    if (right==0)t= false;
                    if (step >right){
                        for (int i = 0; i < right; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()+1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()+1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
            }

            }
        }
        else {
            switch (direction){
                case UP -> {
                    if (up==0){t= false;break;}
                    if (step >up){
                        for (int i = 0; i <up; i++) {
                            if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()-1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()-1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case DOWN ->{
                    if (down==0){t= false;break;}
                    if (step >down){
                        for (int i = 0; i < down; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()+1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setRow(position.getRow()+1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case LEFT -> {
                    if (left==0){t= false;break;}
                    if (step >left){
                        for (int i = 0; i < left; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()-1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()-1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
                case RIGHT -> {
                    if (right==0)t= false;
                    if (step >right){
                        for (int i = 0; i < right; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()+1);
                            steps++;t=false;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                    else {
                        for (int i = 0; i < step; i++) {if(steps==maxStepAllowed)break;
                            position.setCol(position.getCol()+1);
                            steps++;t=true;score+=map.hasTreasure(position);if (map.hasTreasure(position)!=0){map.update(position);}
                        }break;}
                }
            }
        }
        }
        return t;
    }
    public boolean equals(Object player){
        if (id==(int)player)return true;
        else return false;
    }
    
}
