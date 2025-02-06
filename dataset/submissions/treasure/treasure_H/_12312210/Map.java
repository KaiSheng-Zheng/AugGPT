//package class_task_6_2;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive=true;
    private Treasure[] treasures;
    private int vis[]=new int[505];
    private int cnt;
    public Map(int rows,int columns,Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=treasures;
        cnt=treasures.length;
    }
    public int hasTreasure(Position position){
        //maybe do it in the codetest
        for (int i = 0; i < treasures.length; i++) {
            if(vis[i]==1)continue;
            if(position.equals(treasures[i].getPosition())){
                //cnt--;
                //update(position);
                return treasures[i].getScore();
            }
        }
        return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(vis[i]==1)continue;
            if(position.equals(treasures[i].getPosition())){
                vis[i]=1;
                break;
            }
        }
        if(cnt==0)isActive=false;
    }

    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public int[] getVis() {
        return vis;
    }

    public void setVis(int[] vis) {
        this.vis = vis;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
