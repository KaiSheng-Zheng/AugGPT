public class Player{
    private final int id;
    int c = 1;
    private int score;
    private int steps;
    private int rSteps;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        this.map = map;
        position = initialPosition;
        steps = 0;
        rSteps = -1;
        score = 0;
        id = c;
        c++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        position = initialPosition;
        steps = 0;
        rSteps = maxStepAllowed;
        score = 0;
        id = c;
        c++;
    }
    public int getScore() {
        return score;
    }
    public int getId() {
        return id;
    }
    public int getSteps() {
        return steps;
    }
    public Map getMap() {
        return map;
    }

    public Position getPosition() {return position;}
    public boolean move(Direction direction, int steps){
        if (steps > 0){
            if (!getMap().isActive()){
                return false;
            }
            if (rSteps == 0){
                return false;
            }
            int r = position.getRow();
            int c = position.getCol();
            switch (direction){
                case UP :
                    if (r == 0){
                        return false;
                    }else {
                        position.setRow(r - 1);
                        break;
                    }
                case DOWN:
                    if (r == getMap().getRows() - 1){
                        return false;
                    }else {
                        position.setRow(r + 1);
                        break;
                    }
                case LEFT:
                    if (c == 0){
                        return false;
                    }else {
                        position.setCol(c - 1);
                        break;
                    }
                case RIGHT:
                    if (c == getMap().getColumns() - 1){
                        return false;
                    }else {
                        position.setCol(c + 1);
                        break;
                    }
            }
            if (getMap().hasTreasure(position) != 0){
                score += getMap().hasTreasure(position);
                getMap().update(position);
            }
            this.steps++;
            rSteps--;
            steps--;
            return move(direction,steps);
        }else {
            return false;
        }
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if (p.getId() == id){
            return true;
        }else {
            return false;
        }
    }
}