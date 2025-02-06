import static java.lang.Math.random;
public class Player {
    public static int cnt;
    private final int id= (int) (random() * 10000);
    private int score=0;
    private int steps=0;
    private int maxStepAllowed=10000;
    private Position position;
    private Map map;



    public Player(Map map, Position initialPosition){
        this.position=initialPosition;
        this.map=map;
        cnt++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.position=initialPosition;
        this.map=map;
        this.maxStepAllowed=maxStepAllowed;
    }

    public boolean move(Direction direction, int steps){
        int row=position.getRow();
        int col=position.getCol();
        int k=0;
        if(!map.isActive()){
        return false;
        }
        else if(direction.equals(Direction.UP)){
           k=0;
            while (row>0&&k<steps&&this.maxStepAllowed>0){
                if(!map.isActive()){
                    return false;
                }
                k++;
                this.maxStepAllowed--;
                row--;
                this.steps++;
                position.setRow(row);
                if(map.hasTreasure(position)!=0){
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }
            return k == steps;
        }
        else if(direction.equals(Direction.DOWN)){
            k=0;
            while (row<map.getRows()-1&&k<steps&&this.maxStepAllowed>0){
                if(!map.isActive()){
                    return false;
                }
                k++;
                this.maxStepAllowed--;
                row++;
                this.steps++;
                position.setRow(row);
                if(map.hasTreasure(position)!=0){
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }
            return k == steps;
        }
        else if(direction.equals(Direction.RIGHT)){
            k=0;
            while (col<map.getColumns()-1&&k<steps&&this.maxStepAllowed>0){
                if(!map.isActive()){
                    return false;
                }
                k++;
                this.maxStepAllowed--;
                col++;
                this.steps++;
                position.setCol(col);
                if(map.hasTreasure(position)!=0){
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }
            return k == steps;
        }
        else if(direction.equals(Direction.LEFT)){
            k=0;
            while (col>0&&k<steps&&this.maxStepAllowed>0){
                if(!map.isActive()){
                    return false;
                }
                k++;
                this.maxStepAllowed--;
                col--;
                this.steps++;
                position.setCol(col);
                if(map.hasTreasure(position)!=0){
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                }
            }
            return k == steps ;
        }
        return true;
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if(p.getId()==id){
            return true;
        }
       return false;

    }


    public int getId() {
        return this.id;

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


}
