
public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    public static int count;
    private final int maxStepAllowed;

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

    public static int getCount() {
        return count;
    }

    public Player(Map map, Position initialPosition){
        this.id=count;
        count++;
        this.map=map;
        this.position=initialPosition;
        this.steps=0;
        this.maxStepAllowed= 1_000_000_000;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id=count;
        count++;
        this.map=map;
        this.position=initialPosition;
        this.steps=0;
        this.maxStepAllowed=maxStepAllowed;
    }
    public boolean move(Direction direction, int steps){
        if (!map.isActive()||this.steps>=maxStepAllowed){
            return false;
        }
        for (int i = 0; i < steps; i++) {
            if (this.steps==maxStepAllowed)return false;
            try {

                switch (direction) {
                    case UP -> position.setRow(position.getRow() -1);
                    case DOWN -> position.setRow(position.getRow() + 1);
                    case LEFT -> position.setCol(position.getCol() - 1);
                    case RIGHT -> position.setCol(position.getCol() + 1);
                }

                if (position.getCol() >= map.getColumns() || position.getRow() >= map.getRows() || position.getCol() < 0 || position.getRow() < 0) {
                    throw new OutException("Out of bound!!!!!");
                }
            } catch (OutException e) {
                switch (direction) {
                    case UP -> position.setRow(position.getRow() + 1);
                    case DOWN -> position.setRow(position.getRow() - 1);
                    case LEFT -> position.setCol(position.getCol() + 1);
                    case RIGHT -> position.setCol(position.getCol() - 1);
                }
                return false;

            }
            this.steps++;

            if (map.hasTreasure(position)>0){
                score+=map.hasTreasure(position);
                map.update(position);
            }
            if (!map.isActive())return false;

        }


            //todo:player get score
        return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return p.getId()==this.id;
    }
}

class OutException extends Exception {
    public OutException(String message) {
        super(message);
    }
}
