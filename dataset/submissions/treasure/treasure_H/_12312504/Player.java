public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    int allowedStep=20000;
    private Position position;
    private Map map;
    int num=0;
    public Player(Map map, Position initialPosition){
        this.map=map;
        this.position=initialPosition;
        num++;
        this.id=num;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map=map;
        this.position=initialPosition;
        this.allowedStep=maxStepAllowed;
        num++;
        this.id=num;
    }
    public boolean move(Direction direction, int steps){
        int a=1;
        if (!map.isActive()){
            a=0;
        }else {
            for (int i=1;i<=steps;i++){
                if (allowedStep==0){
                    a=0;
                    break;
                }
                if (direction==Direction.LEFT){
                    if (position.getCol()>0){
                        allowedStep--;
                        this.steps++;
                        position.setCol(position.getCol()-1);
                        if (map.hasTreasure(getPosition())>0){
                            score+=map.hasTreasure(getPosition());
                            map.update(getPosition());
                        }
                    }else {
                        a=0;
                        break;
                    }
                }
                if (direction==Direction.RIGHT){
                    if (position.getCol()<map.getColumns()-1){
                        allowedStep--;
                        this.steps++;
                        position.setCol(position.getCol()+1);
                        if (map.hasTreasure(getPosition())>0){
                            score+=map.hasTreasure(getPosition());
                            map.update(getPosition());
                        }
                    }else {
                        a=0;
                        break;
                    }
                }
                if (direction==Direction.UP){
                    if (position.getRow()>0){
                        allowedStep--;
                        this.steps++;
                        position.setRow(position.getRow()-1);
                        if (map.hasTreasure(getPosition())>0){
                            score+=map.hasTreasure(getPosition());
                            map.update(getPosition());
                        }
                    }else {
                        a=0;
                        break;
                    }
                }
                if (direction==Direction.DOWN){
                    if (position.getRow()<map.getRows()-1){
                        allowedStep--;
                        this.steps++;
                        position.setRow(position.getRow()+1);
                        if (map.hasTreasure(getPosition())>0){
                            score+=map.hasTreasure(getPosition());
                            map.update(getPosition());
                        }
                    }else {
                        a=0;
                        break;
                    }
                }
            }
        }
        if (a==0){
            return false;
        }else return true;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return this.id==p.id;
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