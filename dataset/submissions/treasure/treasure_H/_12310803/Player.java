
public class Player {
    private static int tot;
    private final int id ;
    private int score;
    private int steps;
    private Position position;
    private final Map map;
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

    public Player(Map map, Position initialPosition){
        id = ++ tot;
        this.map = map;
        this.position = new Position(initialPosition.getRow(),initialPosition.getCol());
        this.maxStepAllowed = Integer.MAX_VALUE;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id = ++ tot;
        this.map = map;
        this.position = new Position(initialPosition.getRow(),initialPosition.getCol());
        this.maxStepAllowed = maxStepAllowed;

    }

    public boolean move(Direction direction,int steps) {
        int stepsBeforeMove = this.steps;
        if (!map.isActive()) {
            return false;
        }
        switch (direction) {
            case UP -> {
                for (int i = 0; i < steps; i++) {
                    if (getPosition().getRow() != 0 && this.steps < maxStepAllowed) {
                        getPosition().setRow(getPosition().getRow() - 1);
                        this.steps = this.steps + 1;
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
            case DOWN -> {
                for (int i = 0; i < steps; i++) {
                    if (getPosition().getRow() != map.getRows() - 1&& this.steps < maxStepAllowed) {
                        getPosition().setRow(getPosition().getRow() + 1);
                        this.steps = this.steps + 1;
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
            case LEFT -> {
                for (int i = 0; i < steps; i++) {
                    if (getPosition().getCol() != 0 && this.steps < maxStepAllowed) {
                        getPosition().setCol(getPosition().getCol() - 1);
                        this.steps = this.steps + 1;
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
            case RIGHT -> {
                for (int i = 0; i < steps; i++) {
                    if (getPosition().getCol() != map.getColumns() - 1&& this.steps < maxStepAllowed) {
                        getPosition().setCol(getPosition().getCol() + 1);
                        this.steps = this.steps + 1;
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        if (!map.isActive()) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return this.steps == stepsBeforeMove + steps;
        }


    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.getId();
    }
}
