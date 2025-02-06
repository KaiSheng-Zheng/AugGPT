
public class Player {
    private static int count=1;
    private final int id = count;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxSteps = 2147483647;


    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        count += 1;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxSteps = maxStepAllowed;
        count += 1;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Player.count = count;
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

    public int getId() {
        return id;
    }

    public boolean move(Direction direction, int steps){
        int a = 0;
        if (map.isActive()){
            for (int i = 0;i<steps;i++){
                int treasure_score = 0;
                    if (!map.isActive()){
                        break;
                    }
                    switch (direction){
                        case UP:if (position.getRow()>0&&position.getRow()< map.getRows()&& this.steps<maxSteps){position.setRow(position.getRow()-1);this.steps += 1;a+=1;break;}else{break;}
                        case DOWN:if (position.getRow()>=0&&position.getRow()< map.getRows()-1&& this.steps<maxSteps){position.setRow(position.getRow()+1);this.steps += 1;a+=1;break;}else{break;}
                        case LEFT:if (position.getCol()>0&&position.getCol()< map.getColumns()&& this.steps<maxSteps){position.setCol(position.getCol()-1);this.steps += 1;a+=1;break;}else{break;}
                        case RIGHT:if (position.getCol()>=0&&position.getCol()< map.getColumns()-1&& this.steps<maxSteps){position.setCol(position.getCol()+1);this.steps += 1;a+=1;break;}else{break;}
                    }
                if (map.hasTreasure(this.position) != 0){
                    treasure_score = map.hasTreasure(this.position);
                    map.find += 1;
                    map.update(this.position);
                }
                    score += treasure_score;

            }
            if (a == steps){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean equals(Object player){
        Player target = (Player) player;
        return this.id == target.id;
    }
}
