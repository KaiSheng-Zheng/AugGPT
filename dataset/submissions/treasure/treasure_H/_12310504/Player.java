public class Player {
    private static int generateID = 1;
    private final int id = generateID++;
    private int score;
    private int steps;
    private Position position;
    private Map map;
    private int maxStep;
    private boolean check;
    public Player(Map map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.steps = 0;
        this.check = false;
        this.maxStep = -1;
        this.score = 0;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        this.map = map;
        this.position = initialPosition;
        this.maxStep = maxStepAllowed;
        this.steps = 0;
        this.check = false;
        this.score = 0;
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
        if (steps <= 0){
            this.check = false;
        }
        if(!map.isActive()){
            this.check = false;
        }
        int col = position.getCol();
        int row = position.getRow();
        if (direction == Direction.UP){
            for (int i = 1; i<=steps; i++){
                if (!map.isActive() || (maxStep !=-1 && this.steps >= maxStep)) {
                    this.check = false;
                    break;
                }
                else{
                    this.check = true;
                }
                row--;
                if(row < 0){
                    this.steps +=0;
                }else {
                    this.steps++;
                }

                if (this.steps >= maxStep){
                    this.check = false;
                }
                if(row < 0){
                    this.check = false;
                }
                else{
                    this.check = true;
                }
                row =Math.max(0, row);
                position.setRow(row);
                int score2 = map.hasTreasure(new Position(row,col));
                if (score2 > 0){
                    this.score += score2;
                    map.update(new Position(row,col));
                }
            }
        }
        if (direction == Direction.DOWN){
            for (int i = 1; i<=steps;i++){
                if (!map.isActive() || (maxStep != -1 && this.steps >= maxStep)) {
                    this.check = false;
                    System.out.println(this.check);
                    break;
                }
                else{
                    this.check = true;
                }
                row++;
                if(row > map.getRows()-1){
                    this.steps +=0;
                }else {
                    this.steps++;
                }
                if (this.steps >= maxStep){
                    this.check = false;
                }
                if(row > map.getRows() -1){
                    this.check = false;
                }
                else{
                    this.check = true;
                }
                row = Math.min(map.getRows()-1, row);
                position.setRow(row);
                int score2 = map.hasTreasure(new Position(row,col));
                if (score2 > 0){
                    this.score += score2;
                    map.update(new Position(row,col));
                }
            }
        }
        if (direction == Direction.LEFT){
            for(int i = 1; i<=steps; i++){
                if (!map.isActive() || (maxStep != -1 && this.steps >= maxStep)) {
                    this.check = false;
                    break;
                }
                else{
                    this.check = true;
                }
                col--;
                if(col< 0){
                    this.steps +=0;
                }else {
                    this.steps++;
                }
                if (this.steps >= maxStep){
                    this.check = false;
                }
                if(col < 0){
                    this.check = false;
                }
                else{
                    this.check = true;
                }
                col = Math.max(0, col);
                position.setCol(col);
                int score2 = map.hasTreasure(new Position(row,col));
                if (score2 > 0){
                    this.score += score2;
                    map.update(new Position(row,col));
                }
            }

        }
        if (direction == Direction.RIGHT){
            for (int i = 1; i<=steps;i++){
                if (!map.isActive() || (maxStep != -1 && this.steps >=maxStep)) {
                    this.check = false;
                    break;
                }
                else {
                    this.check = true;
                }
                col++;
                if(col> map.getColumns()-1){
                    this.steps +=0;
                }else {
                    this.steps++;
                }
                if (this.steps >= maxStep){
                    this.check = false;
                }
                if(col > map.getColumns() -1){
                    this.check = false;
                }
                else{
                    this.check = true;
                }
                col = Math.min(map.getColumns()-1, col);
                position.setCol(col);
                int score2 = map.hasTreasure(new Position(row,col));
                if (score2 > 0){
                    this.score += score2;
                    map.update(new Position(row,col));
                }
            }
        }
        return this.check;
    }
    public boolean equals(Object player) {
        Player p = (Player) player;
        return id == p.id && score == p.score && steps == p.steps && maxStep == p.maxStep && check == p.check && map.equals(p.map);
    }
}
