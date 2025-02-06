public class Player {
    private final int id;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int capticy;
    static private int num;
    public Player(Map map, Position initialPosition){
        score=0;steps=0;
        position=initialPosition;
        this.map=map;
        num++;id=num;
        capticy=Integer.MAX_VALUE;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        score=0;steps=0;
        position=initialPosition;
        this.map=map;
        num++;id=num;
        capticy=maxStepAllowed;
    }
    public int getId() {return id;}
    public int getScore() {return score;}
    public int getSteps() {return steps;}
    public Position getPosition() {return position;}

    public boolean move(Direction direction, int steps) {
        if(!map.getIsactive()) return false;
        int x=position.getRow();
        int y=position.getCol();
        switch (direction) {
            case UP:
                if(!map.getIsactive()) return false;
                if(x-steps<0) {
                    for(int i=x-1;i>=0;i--) {
                        if(this.steps==capticy) return false;
                        if(!map.getIsactive()) return false;
                        score+=map.hasTreasure(new Position(i,y));
                        map.update(new Position(i,y));
                        this.steps++;
                        position.setRow((position.getRow()-1));
                    }
                    return false;
                }

                for(int i=x-1;i>=x-steps;i--) {
                    if(this.steps==capticy) return false;
                    if(!map.getIsactive()) return false;
                    score+=map.hasTreasure(new Position(i,y));
                    map.update(new Position(i,y));
                    this.steps++;
                    position.setRow((position.getRow()-1));
                }
                return true;
            case DOWN:
                if(!map.getIsactive()) return false;
                if(x+steps>=map.getRows()) {
                    for(int i=x+1;i<map.getRows();i++) {
                        if(this.steps==capticy) return false;
                        if(!map.getIsactive()) return false;
                        score+=map.hasTreasure(new Position(i,y));
                        map.update(new Position(i,y));
                        this.steps++;
                        position.setRow((position.getRow()+1));
                    }
                    return false;
                }

                for(int i=x+1;i<=x+steps;i++) {
                    if(this.steps==capticy) return false;
                    if(!map.getIsactive()) return false;
                    score+=map.hasTreasure(new Position(i,y));
                    map.update(new Position(i,y));
                    this.steps++;
                    position.setRow((position.getRow()+1));
                }
                return true;
            case LEFT:
                if(!map.getIsactive()) return false;
                if(y-steps<0) {
                    for(int i=y-1;i>=0;i--) {
                        if(this.steps==capticy) return false;
                        if(!map.getIsactive()) return false;
                        score+=map.hasTreasure(new Position(x,i));
                        map.update(new Position(x,i));
                        this.steps++;
                        position.setCol((position.getCol()-1));
                    }
                    return false;
                }

                for(int i=y-1;i>=y-steps;i--) {
                    if(this.steps==capticy) return false;
                    if(!map.getIsactive()) return false;
                    score+=map.hasTreasure(new Position(x,i));
                    map.update(new Position(x,i));
                    this.steps++;
                    position.setCol((position.getCol()-1));
                }
                return true;
            case RIGHT:
                if(!map.getIsactive()) return false;
                if(y+steps>=map.getColumns()) {
                    for(int i=y+1;i<map.getColumns();i++) {
                        if(this.steps==capticy) return false;
                        if(!map.getIsactive()) return false;
                        score+=map.hasTreasure(new Position(x,i));
                        map.update(new Position(x,i));
                        this.steps++;
                        position.setCol((position.getCol()+1));
                    }
                    return false;
                }

                for(int i=y+1;i<=y+steps;i++) {
                    if(this.steps==capticy) return false;
                    if(!map.getIsactive()) return false;
                    score+=map.hasTreasure(new Position(x,i));
                    map.update(new Position(x,i));
                    this.steps++;
                    position.setCol((position.getCol()+1));
                }
                return true;
        }
        return true;
    }
    public boolean equals (Object player) {
        if(player==null||!(player instanceof Player)) return false;
        if(this==player) return true;
        Player exa=(Player) player;
        if(this.id!=((Player) player).getId()) return false;
        return true;
    }
    public String toString() {
        return "("+position.getRow()+","+position.getCol()+")";
    }

}
