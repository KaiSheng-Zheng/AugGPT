public class Player implements Comparable<Player> {
    private final int id;
    public static int number;
    private int score;
    private int steps;

    private Map map;
    private Position position;
    private int maxStepAllowed = -1;

    public Player(Map map, Position position) {
        this.map = map;
        this.position = position;
        number++;
        this.id = number;

    }

    public Player(Map map, Position position, int maxStepAllowed) {
        this.map = map;
        this.position = position;
        this.maxStepAllowed = maxStepAllowed;
        number++;
        this.id = number;

    }

    public static void setNumber(int number) {
        Player.number = number;
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

    public int[] walk(Direction direction) {
        int[] dir = new int[2];
        switch (direction) {
            case UP:
                dir[0] = -1;
                break;
            case DOWN:
                dir[0] = 1;
                break;
            case LEFT:
                dir[1] = -1;
                break;
            default:
                dir[1] = 1;

        }
        return dir;
    }

    public boolean move(Direction direction, int steps) {
        int st = this.steps + steps;
        //if (!map.isActive()) {
        //  return false;
        //} else if (!(position.getRow() + steps * walk(direction)[0] < map.getRows() && position.getRow() + steps * walk(direction)[0] >= 0 && position.getCol() + steps * walk(direction)[1] < map.getColumns() && position.getCol() + steps * walk(direction)[1] >= 0)) {
        //return false;}
        //else if (maxStepAllowed > 0 && st > maxStepAllowed) {
        //   return false;}

        int i = 0;
        for (; i < steps; i++) {
            int r = position.getRow();
            r += walk(direction)[0];
            int c = position.getCol();
            c += walk(direction)[1];
            if (!map.isActive()) {
                break;
            }
            if (!(r < map.getRows() && r >= 0 && c < map.getColumns() && c >= 0)) {
                break;
            }
            if (maxStepAllowed >= 0 && this.steps + i + 1 > maxStepAllowed) {
                break;
            }
            position.setRow(r);
            position.setCol(c);
            int s = map.hasTreasure(position);
            if (map.hasTreasure(position) != 0) {
                map.update(position);
            }
            this.score += s;
        }
        this.steps += i;
        if (i == steps) {
            return true;
        } else
            return false;

    }

    public boolean equals(Object player) {
        Player p = (Player) (player);
        if (this.id == p.getId()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Player o) {
        if (this.score == o.score) {
            if (this.steps - o.steps == 0) {
                return 0;
            } else if (this.steps - o.steps < 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (score - o.score > 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
