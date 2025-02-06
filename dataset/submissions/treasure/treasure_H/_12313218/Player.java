public class Player {
    private final int id;
    private int score = 0;
    private int steps = 0;
    private Position position;
    private Map map;
    static int number = 0;
    private int maxStepAllowed = -1;

    public Player(Map map,Position position) {
        number++;
        this.position = position;
        this.map = map;
        this.id = number;
    }
    public Player(Map map,Position position,int maxStepAllowed){
        number++;
        this.position = position;
        this.map = map;
        this.id = number;
        this.maxStepAllowed = maxStepAllowed;
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

    public boolean move(Direction direction, int steps){
        if (!(this.map.isActive())){
            return false;
        }
        boolean temp = true;
        if (steps>this.maxStepAllowed-this.steps&&maxStepAllowed>=0){
            temp = false;
            steps=this.maxStepAllowed-this.steps;
        }
        if(direction==Direction.UP){
            for (int i=0;i<steps;i++){
                if (this.position.getRow()>0&&this.map.isActive()){
                    this.position.setRow(this.position.getRow()-1);
                    this.steps++;
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                }else {
                    temp=false;
                    break;
                }
            }
        }else if (direction==Direction.DOWN){
            for (int i=0;i<steps;i++){
                if (this.position.getRow()<this.map.getRows()-1&&this.map.isActive()){
                    this.position.setRow(this.position.getRow()+1);
                    this.steps++;
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                }else {
                    temp=false;
                    break;
                }
            }
        }else if (direction==Direction.LEFT){
            for (int i=0;i<steps;i++){
                if (this.position.getCol()>0&&this.map.isActive()){
                    this.position.setCol(this.position.getCol()-1);
                    this.steps++;
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                }else {
                    temp=false;
                    break;
                }
            }
        }else if (direction==Direction.RIGHT){
            for (int i=0;i<steps;i++){
                if (this.position.getCol()<this.map.getColumns()-1&&this.map.isActive()){
                    this.position.setCol(this.position.getCol()+1);
                    this.steps++;
                    this.score+=this.map.hasTreasure(this.position);
                    this.map.update(this.position);
                }else {
                    temp=false;
                    break;
                }
            }
        }
        return temp;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return (this.id==p.id);
    }
}
