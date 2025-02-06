public class Player {
    private final int id;  
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private static int idCount = 1;
    private int maxStep;

    public Player(Map map, Position initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.id = idCount++;
        this.steps = 0;
        this.maxStep = 9999999;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.map = map;
        this.position = initialPosition;
        this.maxStep = maxStepAllowed;
        this.id = idCount++;
        this.steps = 0;
    }

    // GETTER
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

    // METHODS
    public boolean move(Direction direction, int steps) {
        // CONDITIONS FOR FALSE
        if (map.isActive() == false) {
            return false;
        }
        if (this.steps >= this.maxStep) {
            return false;
        }

        // MOVE WITH RESTRICTION - hitWall
        int excessSteps;
        int score;
        // down
        if (direction == Direction.DOWN && (steps + position.getRow() >= this.map.getRows() || this.steps + steps > this.maxStep)){
            
            excessSteps = this.map.getRows() - position.getRow() - 1;

            if ((this.steps + steps) > this.maxStep && (this.maxStep - this.steps) < excessSteps) {
                excessSteps = this.maxStep - this.steps;
            }
            for(; excessSteps > 0; excessSteps--) {
                position.setRow(position.getRow() + 1);
                this.steps++;
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
            return false;
        }
        
        // up
        if (direction == Direction.UP && (position.getRow() - steps < 0 || this.steps + steps > this.maxStep)) {
            
            excessSteps = position.getRow();

            if ((this.steps + steps) > this.maxStep && (this.maxStep - this.steps) < excessSteps) {
                excessSteps = this.maxStep - this.steps;
            }

            for(; excessSteps > 0; excessSteps--) {
                position.setRow(position.getRow() - 1);
                this.steps++;
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
            return false;
        }
        // right
        if (direction == Direction.RIGHT && (steps + position.getCol() >= this.map.getCols() || this.steps + steps > this.maxStep)) {
            
            excessSteps = this.map.getCols() - position.getCol() - 1;
            if((this.steps + steps) > this.maxStep && (this.maxStep - this.steps) < excessSteps){
                excessSteps = this.maxStep - this.steps;
            }

            for(; excessSteps > 0; excessSteps--) {
                position.setCol(position.getCol() + 1);
                this.steps++;
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
            
            return false;
        }
        // left
        if (direction == Direction.LEFT && (position.getCol() - steps < 0 || this.steps + steps > this.maxStep)) {
            
            excessSteps = position.getCol();

            if((this.steps + steps) > this.maxStep && (this.maxStep - this.steps) < excessSteps){
                excessSteps = this.maxStep - this.steps;
            }

            for(; excessSteps > 0; excessSteps--) {
                position.setCol(position.getCol() - 1);
                this.steps++;
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
            return false;
        }

        // MOVE WITHOUT RESTRICTION
        if (direction == Direction.LEFT) {
            for (; steps > 0; steps--) {
                position.setCol(position.getCol() - 1);
                this.steps ++;
                
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
        }
        if (direction == Direction.RIGHT) {
            for (; steps > 0; steps--) {
                position.setCol(position.getCol() + 1);
                this.steps ++;
                
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
        }
        if (direction == Direction.UP) {
            for (; steps > 0; steps--) {
                position.setRow(position.getRow() - 1);
                this.steps ++;
                
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }
        }
        if (direction == Direction.DOWN) {
            for (; steps > 0; steps--) {
                position.setRow(position.getRow() + 1);
                this.steps ++;
                
                score = this.map.hasTreasure(position);

                if(score > 0){
                    this.map.update(position);
                }
                this.score += score;

                if(!this.map.isActive() && steps > 1){
                    return false;
                }
            }

        }

        return true;

    }

    public boolean equals(Object player) {
        Player p = (Player)player;
        if (p.id == this.id) {
            return true;
        }
        return false;
    }

}