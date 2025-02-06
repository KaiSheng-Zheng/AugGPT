public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    int maxStepAllowed=100000;
    private static int iiii=1;
    public Player(Map map, Position initialPosition){
        id=iiii;
        this.map=map;
        this.position=initialPosition;
        score=0;
        steps=0;
        iiii++;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id=iiii;
        this.map=map;
        this.position=initialPosition;
        this.maxStepAllowed=maxStepAllowed;
        score=0;
        steps=0;
        iiii++;
    }

    public Position getPosition() {
        return position;
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
    public boolean move(Direction direction, int stepppp) {
        switch (direction) {
            case UP -> {
                if (map.isActive() && this.position.getRow() > 0 && this.steps < maxStepAllowed) {
                    for (int i = 0; i < stepppp; i++) {
                        if ((this.position.getRow() == 0  )|| this.steps == maxStepAllowed || !map.isActive()) {
                            return false;
                        }
                        position.setRow(position.getRow() - 1);
                        setScore(getScore()+map.hasTreasure(position));
                        this.steps++;
                        map.update(position);

                    }
                } else return false;
                return true;
            }
            case DOWN -> {
                if (map.isActive() && this.position.getRow() < map.getRows() - 1 && this.steps < maxStepAllowed) {
                    for (int i = 0; i < stepppp; i++) {
                        if ((this.position.getRow() == map.getRows() - 1 )|| this.steps == maxStepAllowed || !map.isActive()) {
                            return false;
                        }
                        position.setRow(position.getRow() + 1);
                        setScore(getScore()+map.hasTreasure(position));
                        this.steps++;
                        map.update(position);

                    }
                } else return false;
                return true;
            }
            case LEFT -> {
                if (map.isActive() && this.position.getCol() > 0 && this.steps < maxStepAllowed ) {
                    for (int i = 0; i < stepppp; i++) {
                        if ((this.position.getCol() == 0 )|| this.steps == maxStepAllowed || !map.isActive()) {
                            return false;
                        }
                        position.setCol(position.getCol() - 1);
                        setScore(getScore()+map.hasTreasure(position));
                        this.steps++;
                        map.update(position);
                    }
                } else return false;
                return true;
            }
            case RIGHT -> {
                if (map.isActive() && this.position.getCol() < map.getColumns() - 1 && this.steps < maxStepAllowed) {
                    for (int i = 0; i < stepppp; i++) {
                        if ((this.position.getCol() == map.getColumns() - 1 ) || this.steps == maxStepAllowed || !map.isActive()) {
                            return false;
                        }
                        position.setCol(position.getCol() + 1);
                        setScore(getScore()+map.hasTreasure(position));
                        this.steps++;
                        map.update(position);

                    }
                } else return false;
                return true;
            }
        }
      return false;
    }
    public boolean equals(Object player){
        Player p = (Player)player;
        return this.id==p.id;
    }

    public void setScore(int score) {
        this.score = score;
    }
}