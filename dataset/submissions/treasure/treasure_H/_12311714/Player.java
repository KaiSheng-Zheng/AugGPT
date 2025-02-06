public class Player {
    private final int id;
    private int score;
    private int stp;
    private int steps;
    private Position position;
    public static int cnt=0;
    private Map map;
    public Player(Map map,Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.steps=Integer.MAX_VALUE;
        id=++cnt;stp=0;
    }
    public Player(Map map,Position initialposition,int maxStepAllowed){
        this(map,initialposition);
        this.steps=maxStepAllowed;
    }
    private boolean check(int x,int y){
        return (0<=x&&x<map.getRows()&&0<=y&&y<map.getColumns()&&map.isActive());
    }
    public boolean move(Direction direction,int steps){
        if(!map.isActive())
            return false;
        boolean flag=true;
        switch (direction){
            case LEFT:
                while(this.steps>0&&steps>0&&check(position.getRow(),position.getCol()-1)){
                position.setCol(position.getCol()-1);
                steps--;
                this.steps--;
                stp++;
                score+=map.hasTreasure(position);
                map.update(position);
                }
                if(steps>0)
                    flag=false;
                break;
            case RIGHT:
                while(this.steps>0&&steps>0&&check(position.getRow(),position.getCol()+1)){
                    position.setCol(position.getCol()+1);
                    steps--;
                    this.steps--;
                    stp++;
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                if(steps>0)
                    flag=false;
                break;
            case UP:
                while(this.steps>0&&steps>0&&check(position.getRow()-1,position.getCol())){
                    position.setRow(position.getRow()-1);
                    steps--;
                    this.steps--;
                    stp++;
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                if(steps>0)
                    flag=false;
                break;
            case DOWN:
                while(this.steps>0&&steps>0&&check(position.getRow()+1,position.getCol())){
                    position.setRow(position.getRow()+1);
                    steps--;
                    this.steps--;
                    stp++;
                    score+=map.hasTreasure(position);
                    map.update(position);
                }
                if(steps>0)
                    flag=false;
                break;

        }
        return flag;
    }

    public int getId() {
        return id;
    }

    public int getStp() {
        return stp;
    }

    public int getSteps() {
        return stp;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }

    public boolean equals(Object player) {
        Player p=(Player) player;
        return id==p.getId();
    }
}
