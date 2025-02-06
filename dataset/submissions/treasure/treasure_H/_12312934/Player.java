public class Player {
    static int cnt = 0;
    private final boolean lim;
    private int id;
    private int score;
    private int steps;
    private int max;
    private final int[] dx={-1,1,0,0};
    private final int[] dy={0,0,-1,1};
    private Position position;
    private Map map;
    public String toString(){
        return String.format("%d %d %d %d",position.getRow(),position.getCol(),score,steps);
    }
    public Player(Map map, Position initialPosition){
        id = ++cnt;
        this.map = map;
        position = initialPosition;
        score = 0;
        steps = 0;
        max = 0;lim = false;
    }
    public int getId(){
        return id;
    }
    public Player(Map map, Position initialPosition, int maxStepAllowed){
        id = ++cnt;
        this.map = map;
        position = initialPosition;
        score = 0;
        steps =0 ;
        max = maxStepAllowed;lim = true;
    }
    private boolean check(int x,int y){
        if(x<0 || x>=map.getRows()) return false;
        if(y<0 || y>=map.getColumns()) return false;
        return true;
    }
    public boolean move(Direction direction, int steps){
        boolean f = true;
        if(!map.getIsActive()) return false;
        if(steps+this.steps>max && lim){
            f = false;
            steps = max - this.steps;
        }
        int ans = 0;
        int d = direction.getD();
        while (check(position.getRow() + dx[d], position.getCol() + dy[d]) && ans<steps) {
            position.setRow(position.getRow() + dx[d]);
            position.setCol(position.getCol() + dy[d]);
            ++ans;this.steps++;
            score += map.hasTreasure(position);
            map.update(position);
            if(!map.getIsActive()) return false;
        }
        if(ans<steps) f = false;
        return f;
    }
    public int getSteps(){
        return steps;
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
    public boolean equals(Object player){
        Player p = (Player) player;
        return p.id==id;
    }
}
