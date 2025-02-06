public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public int[] arr1=new int[1000];
    int a1=0;
    public Treasure[] getTreasures() {
        return treasures;
    }

    public Map(int rows, int columns, Treasure[] treasures){
        this.rows =rows;
this.columns =columns;
this.treasures =treasures;
        for(int i=1;i<=treasures.length;i++){
            arr1[i-1]=treasures[i-1].getScore();
        }
    }
    public int getRows(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }
    public int hasTreasure(Position position){
        int a=0;
for(int i=1;i<=treasures.length;i++){
    if(treasures[i-1].getPosition().getRow()==position.getRow()&treasures[i-1].getPosition().getCol()==position.getCol()){
        a=arr1[i-1];
    }
}
return a;
    }
    public int hasTreasure1(Position position){
        int a=0;
        for(int i=1;i<=treasures.length;i++){
            if(treasures[i-1].getPosition().getRow()==position.getRow()&treasures[i-1].getPosition().getCol()==position.getCol()){
                if(arr1[i-1]>0){
                    a1++;
                }
                a=arr1[i-1];
                arr1[i-1]=0;

            }
        }
        return a;
    }
    public int a2() {
        return treasures.length;
    }
    public void update(Position position){
        int a=0;
        for(int i=1;i<=treasures.length;i++){
            if(treasures[i-1].getPosition().getRow()==position.getRow()&treasures[i-1].getPosition().getCol()==position.getCol()){
                a=arr1[i-1];
                arr1[i-1]=0;
                a1++;
            }
        }
    }
    public boolean isActive(){
if(a1==treasures.length){
    return false;
}
else{
    return true;
}
    }
}
