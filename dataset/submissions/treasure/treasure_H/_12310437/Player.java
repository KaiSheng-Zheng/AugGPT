public class Player {
    static int count = 0;
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    private int maxStepAllowed;

    public static int getCount() {
        return count;
    }


    public int getId() {
        return id;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getMaxStepAllowed() {
        return maxStepAllowed;
    }

    public void setMaxStepAllowed(int maxStepAllowed) {
        this.maxStepAllowed = maxStepAllowed;
    }

    public Player(Map map, Position initialPosition){
        this.id = ++count;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.id = ++count;
        this.map = map;
        this.position = initialPosition;
        this.maxStepAllowed = maxStepAllowed;
    }

    public boolean move(Direction direction, int steps) {
        int[] dirRow = {1, -1, 0, 0};
        int[] dirCol = {0, 0, -1, 1};
        int ableStep = 0;
        int dirIndex = -1;
        boolean finishAll = false;
        switch (direction) {
            case DOWN:
                dirIndex = 0;
                break;
            case UP:
                dirIndex = 1;
                break;
            case LEFT:
                dirIndex = 2;
                break;
            case RIGHT:
                dirIndex = 3;
                break;
        }
        if(!this.getMap().isActive()){
            return false;
        }else{
            for (int i = 1; i <= steps ; i++) {
                if(!this.getMap().isActive()){
                    break;
                }
                if(this.getSteps() + 1 <= this.getMaxStepAllowed()) {
                    if (this.getPosition().getRow() + dirRow[dirIndex]  > this.getMap().getRows() - 1 ||
                            this.getPosition().getRow() + dirRow[dirIndex]  < 0 ||
                            this.getPosition().getCol() + dirCol[dirIndex]  > this.getMap().getColumns() - 1 ||
                            this.getPosition().getCol() + dirCol[dirIndex]  < 0) {
                        ableStep = i - 1;
                        break;
                    } else {
                        Position p = new Position(this.getPosition().getRow() + dirRow[dirIndex] , this.getPosition().getCol() + dirCol[dirIndex] );
                        this.setScore(this.getScore() + this.getMap().hasTreasure(p));
                        this.setPosition(p);
                        this.getMap().update(p);
                        this.setSteps(this.getSteps() + 1);
                        ableStep = i;
                    }
                }else{
                    this.setSteps(this.getMaxStepAllowed());
                    break;
                }

            }
            if(ableStep == steps){
                finishAll = true;
            }
        }
        return finishAll;
    }

        public boolean equals (Object player){
            Player p = (Player) player;
            return this.getId() == p.getId();
        }
    }
