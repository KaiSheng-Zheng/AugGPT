public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    private int length;
    public Map(int rows, int columns, Treasure[] treasures){
        this.columns=columns;
        this.rows=rows;
        this.treasures=new Treasure[treasures.length];
        for(int i =0;i<treasures.length;i++){
            this.treasures[i]=treasures[i];
        }
        this.treasures=treasures;
        isActive = true;

        length=treasures.length;
    }
    public int hasTreasure(Position position){
        int m=0;
        int temp=0;
        for(int i=0;i<length;i++){

            m++;
            if(treasures[i].getPosition().equals(position)){

               temp=treasures[i].getScore();

                break;
            }
        }
        //
            return temp;
    }
    public void update(Position position){
        for(int i=0;i<length;i++){
            if(treasures[i].getPosition().equals(position)){
                for(int j=i;j<length-1;j++){
                    treasures[j]=treasures[j+1];
                }
                length--;
                break;
            }
        }
        if(length==0){
            isActive=false;
        }
    }
    public boolean isActive(){
        return isActive;
    }
    public int getRows(){
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
