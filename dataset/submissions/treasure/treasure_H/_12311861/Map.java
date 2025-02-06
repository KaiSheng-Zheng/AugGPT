import java.util.HashSet;

class Map {
    private final int rows;
    private final int columns;

    private Treasure[] treasures;
    private int tmp=0;
    public int trsize(){
        return treasures.length;
    }
    public Map(int rowss, int columnss, Treasure[] treasuress){
        rows=rowss;columns=columnss;treasures=treasuress;
        tmp=treasuress.length;
        isActive = tmp > 0;
    }
    private boolean isActive;
    public boolean isActive(){
        return tmp > 0;
    }
    public int hasTreasure(Position position){
        for(Treasure t:treasures){
            if(t.getPosition().equals(position)&&t.getExit()==1){
                return t.getScore();
            }
        }
        return 0;
    }
    public void update(Position position) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i].getExit() == 0) {
                continue;
            }
            if (treasures[i].getPosition().equals(position)) {
                tmp-=1;
                treasures[i].setExit();
                break;
            }
        }
        isActive = tmp > 0;
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
}
