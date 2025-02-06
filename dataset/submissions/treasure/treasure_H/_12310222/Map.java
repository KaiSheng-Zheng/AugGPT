public class Map {
    public int cnt=0;
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
        cnt=treasures.length;
        this.treasures=treasures.clone();
        this.isActive=true;

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(hasTreasure(new Position(i,j))+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
    public int hasTreasure(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getPosition().equals(position)){
                return treasures[i].getScore();
            }
        }return 0;
    }
    public void update(Position position){
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i].getScore()>0&&treasures[i].getPosition().equals(position)){
                treasures[i]=new Treasure(0,treasures[i].getPosition());
                cnt-=1;
                break;
            }
        }
        if(cnt==0){
            this.isActive=false;
        }
    }
    public void getTreasures(){
        for (int i = 0; i < treasures.length; i++) {
            System.out.println(treasures[i]);
        }
    }
    public int getColumns() {return columns;}
    public int getRows() {return rows;}
    public boolean isActive() {return isActive;}
}
