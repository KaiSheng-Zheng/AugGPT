import java.util.ArrayList;

public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private ArrayList<Integer> havefind=new ArrayList<Integer>();  //treasuresIndex
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        this.treasures=new Treasure[treasures.length];
        for (int i = 0; i <treasures.length ; i++) {
            this.treasures[i]=new Treasure(treasures[i].getScore(),treasures[i].getPosition());
        }
        isActive=true;
    }
    public int hasTreasure(Position position){
        int score=0;
        for (int i = 0; i <treasures.length ; i++) {
            if (isHaveFind(i)){
                continue;
            }else {
                if (treasures[i].getPosition().equals(position)){
                    score=treasures[i].getScore();
                    break;
                }
            }

        }
        return score;
    }
    public void update(Position position){ //isActiveUpdate
        for (int i = 0; i <treasures.length ; i++) {
            if (isHaveFind(i)){
                continue;
            }else {
                if (treasures[i].getPosition().equals(position)){

                    havefind.add(i);
                    break;
                }
            }

        }
        if (treasures.length==havefind.size()){
            isActive=false;
        }
    }
    public boolean isHaveFind(int index){
        boolean f=false;
        for (int i = 0; i < havefind.size(); i++) {
            if (index==havefind.get(i)){
                f=true;
                break;
            }
        }
        return f;
    }
    public boolean getIsActive(){
        return isActive;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public boolean isActive(){
        return isActive;
    }
    public Treasure[] getTreasure(){
        return treasures;
    }
}