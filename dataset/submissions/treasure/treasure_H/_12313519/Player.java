public class Player {
    private static int playerCnt=0;
    private final int id;
    private int score=0;
    private int steps=0;
    private int maxStep=237868;
    private boolean infiniteSteps = false;
    private Position position;
    private Map map;
    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.id=++playerCnt;
        infiniteSteps = true;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStep = maxStepAllowed;
        this.id=++playerCnt;
    }
    public boolean move(Direction direction, int steps){
        if(!map.isActive()) return false;
        int diffSteps=maxStep-steps;
        boolean maxFlag=true;
        if(infiniteSteps) maxStep=327868;
        if(diffSteps<0&&!infiniteSteps){
            maxFlag=false;
            if(maxStep<0) maxStep=0;
            steps=maxStep;
        }
        switch(direction) {
            case UP: {
                int row1 = position.getRow();
                int row2 = row1 - steps;
                if (row2 >= 0) {
                    for(int i=row1-1;i>=row2;i--){
                        if(!map.isActive()) break;
                        position.setRow(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return true && maxFlag;
                } else {
                    row2=0;
                    for(int i=row1-1;i>=row2;i--){
                        if(!map.isActive()) break;
                        position.setRow(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return false;
                }
            }
            case DOWN: {
                int row1 = position.getRow();
                int row2 = row1 + steps;
                if (row2 < map.getRows()) {
                    for(int i=row1+1;i<=row2;i++){
                        if(!map.isActive()) break;
                        position.setRow(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return true && maxFlag;
                } else {
                    row2=map.getRows()-1;
                    for(int i=row1+1;i<=row2;i++){
                        if(!map.isActive()) break;
                        position.setRow(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return false;
                }
            }
            case LEFT: {
                int col1 = position.getCol();
                int col2 = col1 - steps;
                if (col2 >= 0) {
                    for(int i=col1-1;i>=col2;i--){
                        if(!map.isActive()) break;
                        position.setCol(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return true && maxFlag;
                } else {
                    col2=0;
                    for(int i=col1-1;i>=col2;i--){
                        if(!map.isActive()) break;
                        position.setCol(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return false;
                }
            }
            case RIGHT: {
                int col1 = position.getCol();
                int col2 = col1 + steps;
                if (col2 < map.getColumns()) {
                    for(int i=col1+1;i<=col2;i++){
                        if(!map.isActive()) break;
                        position.setCol(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }

                    return true && maxFlag;
                } else {
                    col2=map.getColumns()-1;
                    for(int i=col1+1;i<=col2;i++){
                        if(!map.isActive()) break;
                        position.setCol(i);
                        score += map.hasTreasure(position);
                        map.update(position);
                        this.steps += 1;
                        maxStep -= 1;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        if(this.id==p.id) return true;
        else return false;
    }
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
}