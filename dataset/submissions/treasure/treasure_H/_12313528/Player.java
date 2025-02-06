public class Player {
    private final int id;
    private int score=0;
    private int steps=0;
    private Position position;
    private Map map;
    private int maxStepAllowed=-1;
    private static int num;

    public Player(Map map, Position initialPosition) {
        this.position = initialPosition;
        this.map = map;

        id=++num;
    }


    public Player(Map map, Position initialPosition, int maxStepAllowed) {
        this.position = initialPosition;
        this.map = map;
        this.maxStepAllowed = maxStepAllowed;
        id=++num;
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
        int l = 0;
        if (!map.isActive()||maxStepAllowed==0){
            return false;
        }

        if (maxStepAllowed>0){
            l=Math.min (maxStepAllowed,steps);}
        else l=steps;
        int k=l;

        int n=position.getCol();
        int m=position.getRow();
        switch (direction){
            case LEFT:
                for (int i = n-l; i <=n ; i++) {
                    position.setCol(i);
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        l=i-(n-l);
                        break;}

                }
                position.setCol(n-l);
                break;
            case RIGHT:
                for (int i = n; i <=n+l ; i++) {
                    position.setCol(i);
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        l=i-(n);
                        break;}
                }
                position.setCol(n+l);
                break;
            case UP:
                for (int i = m-l; i <=m ; i++) {
                    position.setRow(i);
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        l=i-(m-l);
                        break;}
                }
                position.setRow(m-l);
                break;
            case DOWN:
                for (int i = m; i <=m+l ; i++) {
                    position.setRow(i);
                    this.score+=map.hasTreasure(position);
                    map.update(position);
                    if (!map.isActive()) {
                        l=i-(m);
                        break;}
                }
                position.setRow(m+l);
                break;
        }
        if (position.getCol()<0){
            if (n==0){
                position.setCol(0);
                return false;}
            this.steps+=position.getCol()+l;
            maxStepAllowed=maxStepAllowed-(position.getCol()+l);
            position.setCol(0);
            return false;
        }
        else if (position.getCol()>map.getColumns()-1){
            if (n==map.getColumns()-1){
                position.setCol(map.getColumns()-1);
                return false;}
            this.steps+=map.getColumns()-1-(position.getCol()-l);
            maxStepAllowed=maxStepAllowed-(map.getColumns()-1-(position.getCol()-l));
            position.setCol(map.getColumns()-1);
            return false;
        }
        else if (position.getRow()>map.getRows()-1){
            if (m==map.getRows()-1){
                position.setRow(map.getRows()-1);
                return false;}
            this.steps+=map.getRows()-1-(position.getRow()-l);
            maxStepAllowed=maxStepAllowed-(map.getRows()-1-(position.getRow()-l));
            position.setRow(map.getRows()-1);
            return false;
        }
        else if (position.getRow()<0){
            if (m==0){return false;}
            this.steps+=position.getRow()+l;
            maxStepAllowed=maxStepAllowed-(position.getRow()+l);
            position.setRow(0);
            return false;
        }
        else {


            if (steps<=maxStepAllowed&&k==l||maxStepAllowed<0&&k==l){
                this.steps+=l;
                maxStepAllowed-=l;
                return true;
            }
            else {
                this.steps+=l;
                maxStepAllowed-=l;
                return false;}
            }
    }
    public boolean equals(Object player){
        Player a= (Player) player;
        return this.id == a.id;
    }
}
