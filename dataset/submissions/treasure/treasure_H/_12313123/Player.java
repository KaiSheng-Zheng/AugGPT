public class Player {
    private static int count=1;
    private final int id=count;
    private  int  maxStepAllowed=100;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        count++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        count++;

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

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }
    public boolean move(Direction direction,int steps){
        map.update();
        if (map.isActive()==false){return false;}
        if(getSteps()==maxStepAllowed){return false;}
        int [] row = {-1,1,0,0};
        int [] cal = {0,0,-1,1};
        switch (direction){
            case UP -> {
                boolean ret=true;
                if(position.getRow()+row[0]*steps<0|getSteps()+steps>maxStepAllowed) {ret=false;}
                int rowbefore= position.getRow();
                position.setRow(Math.max((position.getRow()+row[0]*steps),Math.max(0,position.getRow()-(maxStepAllowed-getSteps()))));
                int stepBefore=getSteps();
                setSteps(getSteps()+Math.abs(position.getRow()-rowbefore));
                for(int i=1;i<=(getSteps()-stepBefore);i++){
                    score=score+ map.hasTreasure(rowbefore+row[0]*i, position.getCal());
                    if(map.hasTreasure(rowbefore+row[0]*i, position.getCal())>0){
                        map.update(rowbefore+row[0]*i, position.getCal());
                        if(map.isActive()==false){
                            position.setRow(rowbefore+row[0]*i);
                            ret=false;
                        }
                    }
                }
                map.update();
                return ret;

            }
            case DOWN -> {
                boolean ret=true;
                if(position.getRow()+row[1]*steps> map.getRows()-1|getSteps()+steps>maxStepAllowed){ret=false;}
                int rowbefore= position.getRow();
                position.setRow(Math.min((position.getRow()+row[1]*steps),Math.min(map.getRows()-1, position.getRow()+maxStepAllowed-getSteps())));
                int stepBefore=getSteps();
                setSteps(getSteps()+Math.abs(position.getRow()-rowbefore));
                for(int i=1;i<=(getSteps()-stepBefore);i++){
                    score=score+ map.hasTreasure(rowbefore+row[1]*i, position.getCal());
                    if(map.hasTreasure(rowbefore+row[1]*i, position.getCal())>0){
                        map.update(rowbefore+row[1]*i, position.getCal());
                        if(map.isActive()==false){
                            position.setRow(rowbefore+row[1]*i);
                            ret=false;
                        }
                    }
                }
                map.update();
                return ret;

            }
            case LEFT -> {
                boolean ret=true;
                if (position.getCal()+cal[2]*steps<0|getSteps()+steps>maxStepAllowed){ret=false;}
                int calbefore= position.getCal();
                position.setCal(Math.max((position.getCal()+cal[2]*steps),Math.max(0,position.getCal()-(maxStepAllowed-getSteps()))));
                int stepBefore=getSteps();
                setSteps(getSteps()+Math.abs(position.getCal()-calbefore));
                for(int i=1;i<=(getSteps()-stepBefore);i++){
                    score=score+ map.hasTreasure(position.getRow(),calbefore+cal[2]*i);
                    if(map.hasTreasure(position.getRow(),calbefore+cal[2]*i)>0){
                        map.update(position.getRow(),calbefore+cal[2]*i);
                        if(map.isActive()==false){
                            position.setCal(calbefore+cal[2]*i);
                            ret=false;
                        }
                    }
                }
                map.update();
                return ret;

            }
            case RIGHT -> {
                boolean ret=true;
                if(position.getCal()+cal[3]*steps>map.getColumns()-1|getSteps()+steps>maxStepAllowed){ret=false;}
                int calbefore= position.getCal();
                position.setCal(Math.min((position.getCal()+cal[3]*steps),Math.min(map.getColumns()-1, position.getCal()+maxStepAllowed-getSteps())));
                int stepBefore=getSteps();
                setSteps(getSteps()+Math.abs(position.getCal()-calbefore));
                for(int i=1;i<=(getSteps()-stepBefore);i++){
                    score=score+ map.hasTreasure(position.getRow(),calbefore+cal[3]*i);
                    if(map.hasTreasure(position.getRow(),calbefore+cal[3]*i)>0){
                        map.update(position.getRow(),calbefore+cal[3]*i);
                        if(map.isActive()==false){
                            position.setCal(calbefore+cal[3]*i);
                            ret=false;
                        }
                    }
                }
                map.update();
                return ret;

            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(this.getId()==p.getId()){return true;}
        map.update();
        return false;

    }
}
