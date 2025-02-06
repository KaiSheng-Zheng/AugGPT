public class Player {
    private final int id=ID;
    private int score;
    private int steps=0;
    private Position position;
    private Map map;
    private static int ID=0;
    private int maxSteps=100000;
    int num=0;
    public Position getPosition() {
        return position;
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

    public Player(Map map, Position initialPosition) {
        ID++;
        this.position = initialPosition;
        this.map = map;
    }

    public Player( Map map,Position initialPosition, int maxStepAllowed) {
        ID++;
        this.position = initialPosition;
        this.map = map;
        this.maxSteps = maxStepAllowed;
    }
    public boolean move(Direction direction,int steps) {
        if (map.isActive()) {
            int steps1=0;
            num=0;
            if (maxSteps- this.steps >=steps) {
                steps1=steps;
            }else if(maxSteps- this.steps <steps&&maxSteps- this.steps >0){
                steps1=maxSteps- this.steps;
                num=1;
            }else {
                return false;
            }
            Position tempPosition=new Position(position.getRow(),position.getCol());
            if (direction.getNum()==1){
                if (this.position.getRow()>=steps1){
                    for (int i =1 ; i <=steps1 ; i++) {
                        tempPosition.setRow(tempPosition.getRow()-1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.position.setRow(this.position.getRow()-steps1);
                        this.steps +=steps1;
                    }else {
                        this.steps+=this.position.getRow()-map.lastTreasure.getPosition().getRow();
                        this.position.setRow(map.lastTreasure.getPosition().getRow());
                        num=1;
                    }
                    if (num==1){
                        return false;
                    }else {return true;}
                }else {
                    for (int i = 1; i <=position.getRow() ; i++) {
                        tempPosition.setRow(tempPosition.getRow()-1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.steps +=this.position.getRow();
                        this.position.setRow(0);
                    }else {
                        this.steps+=this.position.getRow()-map.lastTreasure.getPosition().getRow();
                        this.position.setRow(map.lastTreasure.getPosition().getRow());
                    }
                    return false;
                }
            }
            else if (direction.getNum()==2){
                if (map.getRows()-this.position.getRow()-1>=steps1){
                    for (int i =1 ; i <=steps1 ; i++) {
                        tempPosition.setRow(tempPosition.getRow()+1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.position.setRow(this.position.getRow()+steps1);
                        this.steps +=steps1;
                    }else {
                        this.steps+=map.lastTreasure.getPosition().getRow()-this.position.getRow();
                        this.position.setRow(map.lastTreasure.getPosition().getRow());
                        num=1;
                    }
                    if (num==1){
                        return false;
                    }else {return true;}
                }else {
                    for (int i =1 ; i <=map.getRows()-this.position.getRow()-1; i++) {
                        tempPosition.setRow(tempPosition.getRow()+1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.steps += map.getRows()-this.position.getRow()-1;
                        this.position.setRow(map.getRows()-1);
                    }else {
                        this.steps+=map.lastTreasure.getPosition().getRow()-this.position.getRow();
                        this.position.setRow(map.lastTreasure.getPosition().getRow());
                    }
                    return false;
                }
            }
            else if (direction.getNum()==3){
                if (this.position.getCol()>=steps1){
                    for (int i =1 ; i <=steps1 ; i++) {
                        tempPosition.setCol(tempPosition.getCol()-1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.position.setCol(this.position.getCol()-steps1);
                        this.steps +=steps1;
                    }else {
                        this.steps+=this.position.getCol()-map.lastTreasure.getPosition().getCol();
                        this.position.setCol(map.lastTreasure.getPosition().getCol());
                        num=1;
                    }
                    if (num==1){
                        return false;
                    }else {return true;}
                }else {
                    for (int i =1 ; i <=this.position.getCol() ; i++) {
                        tempPosition.setCol(tempPosition.getCol()-1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.steps +=this.position.getCol();
                        this.position.setCol(0);
                    }else {
                        this.steps+=this.position.getCol()-map.lastTreasure.getPosition().getCol();
                        this.position.setCol(map.lastTreasure.getPosition().getCol());
                    }
                    return false;
                }
            }
            else {
                if (map.getColumns()-this.position.getCol()-1>=steps1){
                    for (int i =1 ; i <=steps1 ; i++) {
                        tempPosition.setCol(tempPosition.getCol()+1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.position.setCol(this.position.getCol()+steps1);
                        this.steps +=steps1;
                    }else {
                        this.steps+=map.lastTreasure.getPosition().getCol()-this.position.getCol();
                        this.position.setCol(map.lastTreasure.getPosition().getCol());
                        num=1;
                    }
                    if (num==1){
                        return false;
                    }else {return true;}
                }else {
                    for (int i =1 ; i <=map.getColumns()-this.position.getCol()-1 ; i++) {
                        tempPosition.setCol(tempPosition.getCol()+1);
                        score+=map.hasTreasure(tempPosition);
                        map.update(tempPosition);
                    }
                    if (map.isActive()) {
                        this.steps += map.getColumns()-this.position.getCol()-1;
                        this.position.setCol(map.getColumns()-1);
                    }else {
                        this.steps+=map.lastTreasure.getPosition().getCol()-this.position.getCol();
                        this.position.setCol(map.lastTreasure.getPosition().getCol());
                    }
                    return false;
                }
            }
        }else {
            return false;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }
}
