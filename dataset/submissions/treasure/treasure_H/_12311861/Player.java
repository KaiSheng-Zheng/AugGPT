class Player {
    private final int id;
    private static int tmp=0;
    private int score;
    private int steps;
    private int maxst=(int)1e9;
    private Position position;
    private Map map;
    public Player(Map ma, Position initialPositio){
        map=ma;position=initialPositio;steps=0;
        tmp+=1;id=tmp;
        score=0;
    }
    public Player(Map ma, Position initialPosition, int maxStepAllowed){
        map=ma;position=initialPosition;maxst=maxStepAllowed;
        tmp+=1;id=tmp;
        score=0;steps=0;
    }
    public boolean move(Direction direction, int st) {
        int rem=maxst-steps;

        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        int dx=dir[direction.ordinal()][0], dy=dir[direction.ordinal()][1];
        for(int i=0; i<st; ++i) {
            int tx = position.getRow() + dx, ty = position.getCol() + dy;
            if (!map.isActive() || steps == maxst || tx < 0 || tx >= map.getRows() || ty < 0 || ty >= map.getColumns()) {
                return false;
            }
            steps++;
            position.setRow(tx);
            position.setCol(ty);
            int tt = map.hasTreasure(position);
            if(tt > 0) {
                score += tt;
                map.update(position);
            }
        }
        return true;


//        if(direction==Direction.UP){
//            if(position.getRow()-st>=0&&rem>=st){
//                position.setRow((position.getRow()-st));
//                steps+=st;
//                return true;
//            }else{
//                int yy=Math.min(st,Math.min(rem,position.getRow()));
//                position.setRow(position.getRow()-yy);
//                steps+=yy;
//                return false;
//            }
//
//        }
//        if(direction==Direction.DOWN){
//            boolean re;
//            if(position.getRow()+st<map.getRows()&&rem>=st){
//                position.setRow(position.getRow()+st);
//                this.steps-=steps;
//                re= true;
//            }else{
//                int yy=Math.min(steps,Math.min(this.steps,map.getRows()-position.getRow()));
//                position.setRow(position.getRow()+yy);
//                this.steps-=yy;
//                re= false;
//            }
//            return re;
//        }
//        if(direction==Direction.LEFT){
//            if(position.getCol()-steps>=0&&this.steps>=steps){
//                position.setCol(position.getCol()-steps);
//                this.steps-=steps;
//                return true;
//            }else{
//                int yy=Math.min(steps,Math.min(this.steps,position.getCol()));
//                position.setRow(position.getCol()-yy);
//                this.steps-=yy;
//                return false;
//            }
//        }
//        if(direction==Direction.RIGHT) {
//            if (position.getCol() + steps < map.getColumns() && this.steps >= steps) {
//                position.setCol(position.getCol() + steps);
//                this.steps -= steps;
//                return true;
//            } else {
//                int yy = Math.min(steps, Math.min(this.steps, map.getColumns() - position.getCol()));
//                position.setRow(position.getCol() + yy);
//                this.steps -= yy;
//                return false;
//            }
//        }
//        return false;
    }
    public boolean equals(Object player){
        Player p=(Player) player;
        if(this.id==p.id){
            return true;
        }
        return false;
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

    public int getId() {
        return id;
    }
}

