public class Player {
    private int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int count;
    private final int maxStep;

    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.id = ++count;
        this.maxStep = Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.score = 0;
        this.steps = 0;
        this.maxStep = maxStepAllowed;
        this.id = ++count;
    }


    public boolean move(Direction direction, int steps){
        if(map.isActive()){

            if(this.steps + steps > maxStep){
                int lastSteps = maxStep - this.steps;
                if(direction == Direction.UP){
                    if(this.position.getRow() - lastSteps < 0){
                        this.steps = this.steps + this.position.getRow();
                        int lastPositionRow = this.position.getRow();
                        this.position.setRow(0);
                        for (int i = 0; i <= lastPositionRow - this.position.getRow(); i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() + i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() + i, this.position.getCol()));
                        }
                        return false;
                    }else{
                        this.position.setRow(this.position.getRow() - lastSteps);
                        this.steps = this.steps + lastSteps;
                        for (int i = 0; i <= lastSteps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() + i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() + i, this.position.getCol()));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.DOWN){
                    if(this.position.getRow() + lastSteps > this.map.getRows()){
                        this.steps = this.steps + this.map.getRows() - this.position.getRow();
                        int lastPositionRow = this.position.getRow();
                        this.position.setRow(this.map.getRows());
                        for (int i = 0; i <= this.position.getRow() - lastPositionRow; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() - i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() - i, this.position.getCol()));
                        }
                        return false;
                    }else{
                        this.position.setRow(this.position.getRow() + lastSteps);
                        this.steps = this.steps + lastSteps;
                        for (int i = 0; i <= lastSteps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() - i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() - i, this.position.getCol()));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.LEFT){
                    if(this.position.getCol() - lastSteps < 0){
                        this.steps = this.steps + this.position.getCol();
                        int lastPositionCol = this.position.getCol();
                        this.position.setCol(0);
                        for (int i = 0; i <= lastPositionCol - this.position.getCol(); i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() + i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() + i));
                        }
                        return false;
                    }else{
                        this.position.setCol(this.position.getCol() - lastSteps);
                        this.steps = this.steps + lastSteps;
                        for (int i = 0; i <= lastSteps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() + i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() + i));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.RIGHT){
                    if(this.position.getCol() + lastSteps > this.map.getColumns()){
                        this.steps = this.steps + this.map.getColumns() - this.position.getCol();
                        int lastPositionCol = this.position.getCol();
                        this.position.setCol(this.map.getColumns());
                        for (int i = 0; i <= this.position.getCol() - lastPositionCol; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() - i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() - i));
                        }
                        return false;
                    }else{
                        this.position.setCol(this.position.getCol() + lastSteps);
                        this.steps = this.steps + lastSteps;
                        for (int i = 0; i <= lastSteps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() - i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() - i));
                        }
                        return true;
                    }
                }


            }else{
                if(direction == Direction.UP){
                    if(this.position.getRow() - steps < 0){
                        this.steps = this.steps + this.position.getRow();
                        int lastPositionRow = this.position.getRow();
                        this.position.setRow(0);
                        for (int i = 0; i <= lastPositionRow - this.position.getRow(); i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() + i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() + i, this.position.getCol()));
                        }
                        return false;
                    }else{
                        this.position.setRow(this.position.getRow() - steps);
                        this.steps = this.steps + steps;
                        for (int i = 0; i <= steps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() + i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() + i, this.position.getCol()));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.DOWN){
                    if(this.position.getRow() + steps > this.map.getRows()){
                        this.steps = this.steps + this.map.getRows() - this.position.getRow();
                        int lastPositionRow = this.position.getRow();
                        this.position.setRow(this.map.getRows());
                        for (int i = 0; i <= this.position.getRow() - lastPositionRow; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() - i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() - i, this.position.getCol()));
                        }
                        return false;
                    }else{
                        this.position.setRow(this.position.getRow() + steps);
                        this.steps = this.steps + steps;
                        for (int i = 0; i <= steps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow() - i, this.position.getCol()));
                            map.update(new Position(this.position.getRow() - i, this.position.getCol()));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.LEFT){
                    if(this.position.getCol() - steps < 0){
                        this.steps = this.steps + this.position.getCol();
                        int lastPositionCol = this.position.getCol();
                        this.position.setCol(0);
                        for (int i = 0; i <= lastPositionCol - this.position.getCol(); i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() + i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() + i));
                        }
                        return false;
                    }else{
                        this.position.setCol(this.position.getCol() - steps);
                        this.steps = this.steps + steps;
                        for (int i = 0; i <= steps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() + i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() + i));
                        }
                        return true;
                    }
                }

                else if(direction == Direction.RIGHT){
                    if(this.position.getCol() + steps > this.map.getColumns()){
                        this.steps = this.steps + this.map.getColumns() - this.position.getCol();
                        int lastPositionCol = this.position.getCol();
                        this.position.setCol(this.map.getColumns());
                        for (int i = 0; i <= this.position.getCol() - lastPositionCol; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() - i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() - i));
                        }
                        return false;
                    }else{
                        this.position.setCol(this.position.getCol() + steps);
                        this.steps = this.steps + steps;
                        for (int i = 0; i <= steps; i++) {
                            score = score + map.hasTreasure(new Position(this.position.getRow(), this.position.getCol() - i));
                            map.update(new Position(this.position.getRow(), this.position.getCol() - i));
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean equals(Player player){
        return(this.id == player.getId());
    }
    public int getId(){return id;}
    public int getScore() {return score;}
    public int getSteps() {return steps;}
    public Position getPosition() {return position;}
}