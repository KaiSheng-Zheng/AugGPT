public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxstep;
    public static int numberofplayer = 1;

    public Player(Map map, Position initialPosition) {
        this.id = numberofplayer;
        score = 0;
        steps = 0;
        this.map = map;
        maxstep = 10000;
        position = initialPosition;
        numberofplayer++;
    }

    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        id = numberofplayer;
        score = 0;
        steps = 0;
        this.map = map;
        position = initialPosition;
        maxstep = maxStepAllowed;
        numberofplayer++;
    }

    public Position getPosition() {
        return position;
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

    public boolean move(Direction direction, int step) {
        boolean flag = true;
        for (int i = 0; i < step; i++) {
            if ( maxstep==0) {
                flag = false;
                break;
            } else {
                if (!map.isActive()) {
                    flag = false;
                    break;
                } else {
                    moving(direction);
                        if (out(map.getRows(), map.getColumns())) {
                        flag = false;
                        break;}
                        else{
                        score = score + map.hasTreasure(position);
                        map.update(position);
                        steps++;
                        maxstep--;
                        }
                    }
                }
            }
        return flag;
    }


    public boolean equals(Object player) {
        Player p = (Player) player;
        if (id == p.getId()) {
            return true;
        } else {
            return false;
        }
    }

    public void moving(Direction direction) {
        switch (direction) {
            case UP:
                position.setRow(position.getRow() - 1);
                break;
            case DOWN:
                position.setRow(position.getRow() + 1);
                break;
            case LEFT:
                position.setCol(position.getCol() - 1);
                break;
            case RIGHT:
                position.setCol(position.getCol() + 1);
                break;
        }
    }

    public boolean out(int Maprow, int Mapcol) {
        if (position.getRow() < 0 || position.getRow() > Maprow-1 || position.getCol() < 0 || position.getCol() > Mapcol-1) {
            if (position.getRow() < 0) {
                position.setRow(0)  ;
            }
            if (position.getRow() > Maprow-1) {
                position.setRow(Maprow-1);
            }
            if (position.getCol() < 0) {
                position.setCol(0);
            }
            if (position.getCol() > Mapcol-1) {
                position.setCol(Mapcol-1);
            }
            return true;
        } else {
            return false;
        }
    }
}
enum Direction
{
    UP, DOWN, LEFT, RIGHT;
}


