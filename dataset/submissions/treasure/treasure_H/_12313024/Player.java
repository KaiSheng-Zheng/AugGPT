public class Player {
    private int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    public int maxsteps = 1000000000;
    public Player (Map m, Position inipos) {
        map = m;
        position = inipos;
        id = (int)(Math.random() * (1000000000 - 0 + 1) + 0);
    }
    public Player (Map m, Position inipos, int mxstp) {
        map = m;
        position = inipos;
        maxsteps = mxstp;
        id = (int)(Math.random() * (1000000000 - 0 + 1) + 0);
    }
    public void setId (int s) {
        id = s;
    }
    public int getId () {
        return id;
    }
    public int getScore () {
        return score;
    }
    public int getSteps () {
        return steps;
    }
    public Position getPosition () {
        return position;
    }
    public boolean move (Direction direction, int steps) {
        int cnt = 0;
        switch (direction) {
            case UP :
                while (position.getRow() > 0 && cnt < steps && this.steps < maxsteps) {
                    if (!map.isActive())
                        break;
                    position.setRow(position.getRow() - 1);
                    cnt++;
                    this.steps++;
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }
                }
                if (cnt == steps)
                    return true;
                else
                    return false;
            case DOWN :
                while (position.getRow() < map.getRows() && cnt < steps && this.steps < maxsteps) {
                    if (!map.isActive())
                        break;
                    position.setRow(position.getRow() + 1);
                    cnt++;
                    this.steps++;
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }
                }
                if (cnt == steps)
                    return true;
                else
                    return false;
            case LEFT :
                while (position.getCol()> 0 && cnt < steps && this.steps < maxsteps) {
                    if (!map.isActive())
                        break;
                    position.setCol(position.getCol() - 1);
                    cnt++;
                    this.steps++;
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }
                }
                if (cnt == steps)
                    return true;
                else
                    return false;
            case RIGHT :
                while (position.getCol() < map.getColumns() && cnt < steps && this.steps < maxsteps) {
                    if (!map.isActive())
                        break;
                    position.setCol(position.getCol() + 1);
                    cnt++;
                    this.steps++;
                    if (map.hasTreasure(position) != 0) {
                        score += map.hasTreasure(position);
                        map.update(position);
                    }
                }
                if (cnt == steps)
                    return true;
                else
                    return false;
        }
        return false;
    }
    public boolean equals (Object player) {
        Player plyr = (Player) player;
        return plyr.getId() == id;
    }
}
