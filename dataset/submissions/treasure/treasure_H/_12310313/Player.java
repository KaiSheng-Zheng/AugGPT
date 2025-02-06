import java.util.Random;

public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position pos;
    private Map map;
    private int max;
    int bs=0;


    public Player(Map map, Position initialPos){
        Random random=new Random();
        this.map=map;
        this.pos=pos;
        max=99999;
        id=random.nextInt(1000);
    }
    public Player(Map map, Position initialPos,  int maxStepAllowed){
        Random random=new Random();
        this.map=map;
        this.pos=pos;
        max=maxStepAllowed;
        id=random.nextInt(1000);
    }
    public boolean equals(Player player){
        if (this.id==player.id) {
            return true;
        }else return false;
    }
    public boolean move(Direction direction, int steps){
        int a=1;
        if (map.isActive()==false) {
            return false;
        }
        for (int i = 0; i < steps; i++) {
            if (this.steps>=max) {
                return false;
            }
            switch(direction){
                case UP -> {
                    pos.row-=1;
                    break;
                }
                case DOWN -> {
                    pos.row+=1;
                    break;
                }
                case LEFT -> {
                    pos.col-=1;
                    break;
                }
                case RIGHT -> {
                    pos.col+=1;
                    break;
                }
            }
            this.steps+=1;
            if (pos.row==-1) {
                pos.row+=1;
                a=0;this.steps-=1;
            } else if (map.rows==pos.row) {
                pos.row-=1;
                a=0;this.steps-=1;
            } else if (pos.col==-1) {
                pos.col+=1;
                a=0;this.steps-=1;
            } else if (pos.col==map.columns) {
                pos.col-=1;
                a=0;this.steps-=1;
            }
            if (map.hasTreasure(pos)!=0) {
                this.score+=map.hasTreasure(pos);
            }
        }
        if (a==0) {
            return false;
        }else return  true;
    }
}