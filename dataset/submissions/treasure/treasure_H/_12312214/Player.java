public class Player {
    private final int id;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
    private  int maxStep;
    private static int count=0;
    public Player(Map map, Position initialPosition){
        id=count;
        count++;
        this.position=new Position(initialPosition.getRow(),initialPosition.getCol());
        this.map=map;
        maxStep=Integer.MAX_VALUE;
        score=0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id=count;
        count++;
        /*
        Treasure []T=new Treasure[map.getTreasures().length];
        for (int i=0; i<map.getTreasures().length;i++){
            T[i]=new Treasure(map.getTreasures()[i].getScore(),new Position(map.getTreasures()[i].getPosition().getRow(),map.getTreasures()[i].getPosition().getCol()));
        }
        this.map=new Map(map.getRows(),map.getColumns(),T);

         */
        this.map=map;
        this.position=new Position(initialPosition.getRow(),initialPosition.getCol());
        maxStep=maxStepAllowed;
        score=0;

    }
    public boolean move(Direction direction, int steps){
        boolean sMove = true;
        A:
        for(int j=0;j<steps;j++) {
            if (!map.isActive() || maxStep <= this.steps) {
                return false;
            }
            else {
                    if (direction.equals(Direction.UP)) {
                        if (position.getRow() == 0) {
                            sMove = false;
                            break A;
                        } else {
                            this.steps++;
                            position.setRow(position.getRow() - 1);
                            score = score + map.updateTresure(position);
                        }

                    }
                    else if (direction.equals(Direction.DOWN)) {
                        if ( position.getRow() == map.getRows() - 1) {
                            sMove = false;
                            break A;
                        } else {
                            this.steps++;
                            position.setRow(position.getRow() + 1);
                            score = score + map.updateTresure(position);
                        }
                    } else if (direction.equals(Direction.LEFT)) {
                        if (position.getCol() == 0) {
                            sMove = false;
                            break A;
                        } else {
                            this.steps++;
                            position.setCol(position.getCol() - 1);
                            score = score + map.updateTresure(position);
                        }
                    } else if (direction.equals(Direction.RIGHT)) {
                        if (position.getCol() == map.getColumns() - 1) {
                            sMove = false;
                            break A;
                        } else {
                            this.steps++;
                            position.setCol(position.getCol() + 1);
                            score = score + map.updateTresure(position);
                        }


                }
            }
        }
        return sMove;
    }

    public boolean equals(Object player) {
        Player P = (Player) player;
        if (P == null)
            return false;
        else {
            return id == P.getId();
        }
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

