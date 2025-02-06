public class Player {
    private final int id;
    private static int count = 1;
    private static int nextId = 1;

    public void showPosition(){
        System.out.println(position.getRow()+" "+ position.getCol());
    }
    private int getTreasure() {
        if (!map.treasureArrayList.isEmpty()){
            map.TemTreasureArrayList_.addAll(map.treasureArrayList);
            map.TemTreasureArrayList_.removeIf(element -> element == null);
        int f = 0;
//        if (!map.TemTreasureArrayList_.isEmpty()){
        for (Treasure trea : map.TemTreasureArrayList_
        ) {
            if (position.equals(trea.getPosition())) {
                f = trea.getScore();
                Position t = trea.getPosition();
                map.update(t);
            }
            }
//        }
        map.TemTreasureArrayList_.clear();
        return f;
    }
        else {return 0;}
    }
//    private final int id = 0;
    private int score =0 ;
    private int steps = 0;
    private Position position;


    private Map map;

    int maxSteps = 99999;


    public Player(Map map, Position initialPosition){
        id = count;
        count++;
        this.map = map;
        position = initialPosition;

    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        id = count;
        count++;
        this.position = initialPosition;
        maxSteps = maxStepAllowed;
    }

    public Position getPosition() {
        return position;
    }

    public void setCount(int newcount) {
        count = newcount;
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


//    public boolean canMove (){
//        return position.getCol() < map.getColumns() && position.getRow() < map.getRows() &&
//                position.getRow() > 0 && position.getCol() > 0 && this.steps < maxSteps;
//    }
    boolean canmove;
    public boolean move(Direction direction, int steps){
        boolean k = false;
        boolean canMove = true;
        if (direction.equals(Direction.UP)) {
            for (int i = 0; i < steps; i++) {
                if (this.steps < maxSteps && position.getRow()>0 && map.isActive()) {
                    position.setRow(position.getRow() - 1);
                    score = score + getTreasure();
                    this.steps ++;
                    if (i == steps-1 && !map.isActive()){
                        k = true;
                    }
                } else {
                    canMove = false;
                    break;
                }
            }
        }

        if (direction.equals(Direction.DOWN)) {
            for (int i = 0; i < steps; i++) {
                if (this.steps < maxSteps && position.getRow()<map.getRows()&& map.isActive()) {
                    position.setRow(position.getRow() + 1);
                    score += getTreasure();
                    this.steps ++;
                    if (i == steps-1 && !map.isActive()){
                        k = true;
                    }
//                    System.out.println("MOVE DOWN");
                } else {
                    canMove = false;
                    break;
                }
            }
        }

        if (direction.equals(Direction.LEFT)) {
            for (int i = 0; i < steps; i++) {
                if (this.steps < maxSteps && position.getCol()>0&& map.isActive()) {

                    position.setCol(position.getCol() - 1);
                    score += getTreasure();
                    this.steps ++;
                    if (i == steps-1 && !map.isActive()){
                        k = true;
                    }
                } else {
                    canMove = false;
                    break;
                }
            }
        }

        if (direction.equals(Direction.RIGHT)) {
            for (int i = 0; i < steps; i++) {
//                a =this.steps < maxSteps;b = position.getCol()<map.getColumns();c = map.isActive();
                if (this.steps < maxSteps && position.getCol()<map.getColumns()&& map.isActive()) {
                    position.setCol(position.getCol() + 1);
                    score += getTreasure();
                    this.steps ++;
                    if (i == steps-1 && !map.isActive()){
                        k = true;
                    }
                } else {
                    canMove = false;
                    break;
                }
            }
        }


        if ((!map.isActive() || steps>= maxSteps || canMove == false)&& !k){
            a=!map.isActive();b=steps>= maxSteps;c=!canMove;
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(Object player){
        Player p = (Player) player;
        if (id == p.getId()){
            return true;
        } else  {return false;}
    }

boolean a,b,c;



}

