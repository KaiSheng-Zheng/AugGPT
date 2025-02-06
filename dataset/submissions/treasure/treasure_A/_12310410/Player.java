public class Player {
    private final int id;
    public static int n=0;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;

    public Player(){
        n+=1;
        id=n;
    }
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        n+=1;
        id=n;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        score=0;
        steps=0;
        n+=1;
        id=n;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Player{id = " + id + ", score = " + score + ", steps = " + steps + ", position = " + position + ", map = " + map + "}";
    }

    public boolean move(Direction direction, int steps) {
        if (!map.isActive()) {
            return false;
        }
        if(maxStepAllowed==0){
            return false;
        }

        for (int i = 0; i < steps; i++) {
            int newRow = position.getRow();
            int newCol = position.getCol();

            switch (direction) {
                case UP:
                    newRow--;
                    break;
                case DOWN:
                    newRow++;
                    break;
                case LEFT:
                    newCol--;
                    break;
                case RIGHT:
                    newCol++;
                    break;
            }

            if (newRow < 0 || newRow >= map.getRows() || newCol < 0 || newCol >= map.getColumns()) {
                return false;
            }

            position.setRow(newRow);
            position.setCol(newCol);
            this.steps++;

            int treasureScore = map.hasTreasure(position);
            if (treasureScore > 0) {
                this.score += treasureScore;
                map.update(position);
            }
            if(maxStepAllowed!=-1 && this.steps==maxStepAllowed){
                if(i!=steps-1){
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public boolean equals(Object player){
        Player tempplayer=(Player)player;
        return (tempplayer.getId()==id);
    }
}