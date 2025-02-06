

public class Player {
    private final int id;
    private int score;
    private int steps=0;
    private int count;
    private Position position;
    private Map map;
    static int counter = 0;
    private int maxStepAllowed;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++counter;
        this.maxStepAllowed=-1;
        this.score=getScore();
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.id = ++counter;
        this.maxStepAllowed = maxStepAllowed;

        this.score=getScore();
    }

    public Position getPosition() {
        return position;
    }

    public void setScore() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public boolean move(Direction direction, int steps) {
        count=0;
        for (int i = 0; i <steps; i++) {
            if(!map.isActive()||maxStepAllowed==0){
                break;
            } else {
                if(maxStepAllowed>0&&(this.steps+count)==maxStepAllowed)
                    break;
                if (Direction.UP== direction&&position.getRow()>0) {
                    position.setRow(position.getRow()-1);
                    count++;
                }
                if (Direction.DOWN== direction&&position.getRow()<map.getRows()-1) {
                    position.setRow(position.getRow()+1);
                    count++;
                }
                if (Direction.LEFT == direction&&position.getCol()>0) {
                    position.setCol(position.getCol()-1);
                    count++;
                }
                if (Direction.RIGHT == direction&&position.getCol()<map.getColumns()-1) {
                    position.setCol(position.getCol()+1);
                    count++;
                }
                this.score+= map.hasTreasure(position);
                map.update(position);
            }
        }
        this.steps+=count;

        if(maxStepAllowed==-1) {
            return count == steps;
        }
        else
            // bug: implementation error
            // assume the current step take the last treasure and make the map inactive,
            // the step should still be valid and return true.
            return steps==count&&this.steps<=maxStepAllowed&& map.isActive();

    }
    public int getSteps() {
        return steps;
    }
    public boolean equals(Object player) {
        if (player == null) {
            return false;
        } else {
            Player p = (Player) player;
            return this.id == p.id;
        }
    }

}
