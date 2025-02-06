public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStep;

    public Player(Map map,Position initialPosition){
        this.map = map;
        position = initialPosition;
        maxStep = 10000;
        id = GameSystem.updatePlayerNumber();
    }
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        this.map = map;
        position = initialPosition;
        maxStep = maxStepAllowed;
        id = GameSystem.updatePlayerNumber();
    }
    public boolean move(Direction direction,int steps){
        boolean mon = true;
            if (direction == Direction.UP) {
                for (int i = steps; i > 0; i--) {
                    if(map.isActive() == false){
                        mon = false;
                        break;
                    }
                    else if (maxStep == 0) {
                        mon = false;
                        break;
                    } else if (position.getRow() == 0) {
                        mon = false;
                        break;
                    } else {
                        position.setRow(position.getRow() - 1);
                        maxStep = maxStep - 1;
                        this.steps = this.steps + 1;
                        GameSystem.scores[id] = GameSystem.scores[id] - 1;
                        if(map.hasTreasure(position) != 0){
                            score = score + Map.map[position.getRow()][position.getCol()];
                            GameSystem.scores[id] = GameSystem.scores[id] + Map.map[position.getRow()][position.getCol()] * 100;
                            map.update(position);
                            map.isActive();
                        }
                    }
                }
            }
            if (direction == Direction.DOWN) {
                for (int i = steps; i > 0; i--) {
                    if(map.isActive() == false){
                        mon = false;
                        break;
                    }
                    else if (maxStep == 0) {
                        mon = false;
                        break;
                    } else if (position.getRow() == Map.n - 1) {
                        mon = false;
                        break;
                    } else {
                        position.setRow(position.getRow() + 1);
                        maxStep = maxStep - 1;
                        this.steps = this.steps + 1;
                        GameSystem.scores[id] = GameSystem.scores[id] - 1;
                        if(map.hasTreasure(position) != 0){
                            score = score + Map.map[position.getRow()][position.getCol()];
                            GameSystem.scores[id] = GameSystem.scores[id] + Map.map[position.getRow()][position.getCol()] * 100;
                            map.update(position);
                            map.isActive();
                        }
                    }
                }
            }
            if (direction == Direction.LEFT) {
                for (int i = steps; i > 0; i--) {
                    if(map.isActive() == false){
                        mon = false;
                        break;
                    }
                    else if (maxStep == 0) {
                        mon = false;
                        break;
                    } else if (position.getCol() == 0) {
                        mon = false;
                        break;
                    } else {
                        position.setCol(position.getCol() - 1);
                        maxStep = maxStep - 1;
                        this.steps = this.steps + 1;
                        GameSystem.scores[id] = GameSystem.scores[id] - 1;
                        if(map.hasTreasure(position) != 0){
                            score = score + Map.map[position.getRow()][position.getCol()];
                            GameSystem.scores[id] = GameSystem.scores[id] + Map.map[position.getRow()][position.getCol()] * 100;
                            map.update(position);
                            map.isActive();
                        }
                    }
                }
            }
            if (direction == Direction.RIGHT) {
                for (int i = steps; i > 0; i--) {
                    if(map.isActive() == false){
                        mon = false;
                        break;
                    }
                    else if (maxStep == 0) {
                        mon = false;
                        break;
                    } else if (position.getCol() == Map.m - 1) {
                        mon = false;
                        break;
                    } else {
                        position.setCol(position.getCol() + 1);
                        maxStep = maxStep - 1;
                        this.steps = this.steps + 1;
                        GameSystem.scores[id] = GameSystem.scores[id] - 1;
                        if(map.hasTreasure(position) != 0){
                            score = score + Map.map[position.getRow()][position.getCol()];
                            GameSystem.scores[id] = GameSystem.scores[id] + Map.map[position.getRow()][position.getCol()] * 100;
                            map.update(position);
                            map.isActive();
                        }
                    }
                }
            }
        return mon;
    }
    public boolean equals(Object player){
        boolean tof = false;
        Player p = (Player)player;
        if(this.id == p.id){
            tof = true;
        }
        if(player == null){
            tof = false;
        }
        return tof;
    }
    public int getScore(){
        return score;
    }
    public int getId(){
        return id;
    }
    public int getSteps(){
        return this.steps;
    }
    public Position getPosition(){
        return position;
    }
}