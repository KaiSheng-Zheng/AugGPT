public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    public int getId(){
        return this.id;
    }
    public int getScore(){
        return this.score;
    }
    public int getSteps(){
        return this.steps;
    }
    public Position getPosition(){
        return this.position;
    }

    static int Cnt=0;

    public Player(Map map,Position initialPosition){
        Cnt++;
//        map.hasTreasure()
        this.map = map;
        position=initialPosition;
        maxStepAllowed = -1;
        id = Cnt;
    }
    int maxStepAllowed;
    public Player(Map map,Position initialPosition,int maxStepAllowed){
        Cnt++;
        this.map = map;
        position=initialPosition;
        this.maxStepAllowed = maxStepAllowed;
        id = Cnt;
    }
    public boolean move(Direction direction,int steps) {
//            boolean init = true;
            for (int i = 0; i < steps; i++) {
                if (!map.isActive()) {
                    return false;
                }
                if (maxStepAllowed >= 0) {
                    if (this.steps == maxStepAllowed) {
                        return false;
                    }
                }
//                if (init) {
//                    if (direction.equals(Direction.UP)&&position.getRow()==0) {
//                        return false;
//                    } else if (direction.equals(Direction.DOWN)&&position.getRow()==map.getRows()-1) {
//                        return false;
//                    } else if (direction.equals(Direction.RIGHT)&&position.getCol()==0) {
//                        return false;
//                    }else if (direction.equals(Direction.LEFT)&&position.getRow()==map.getColumns()-1) {
//                        return false;
//                    }
//                }
//                init = false;
                if (direction.equals(Direction.UP) && position.getRow() - 1 >= 0) {
                    position.setRow(position.getRow() - 1);
                    this.steps++;
                } else if (direction.equals(Direction.DOWN) && position.getRow() + 1 < map.getRows()) {
                    position.setRow(position.getRow() + 1);
                    this.steps++;
                } else if (direction.equals(Direction.LEFT) && position.getCol() - 1 >= 0) {
                    position.setCol(position.getCol() - 1);
                    this.steps++;
                } else if (direction.equals(Direction.RIGHT) && position.getCol() + 1 < map.getColumns()) {
                    position.setCol(position.getCol() + 1);
                    this.steps++;
                } else {
                    return false;
                }
                score += map.hasTreasure(position);
                map.update(position);
//                System.out.println(i);
//                System.out.println(position);
            }
        
        return true;
    }
    public boolean equals(Object player){
        if (this == player){return true;}
        if (player==null||getClass()!=player.getClass()) {return false;}
        Player p = (Player) player;
        return id==p.id;
    }


}
