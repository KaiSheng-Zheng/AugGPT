public class Map {
    private final int rows;
    private final int columns;
    private boolean isActive;
    private Treasure[] treasures;
    public Map(int rows, int columns, Treasure[] treasures){
        this.rows=rows;
        this.columns=columns;
       //for (int i = 0; i < Treasure.getCount(); i++) {
          // treasures[i]=new Treasure();
       }
//       public void setRows(int row)
//       {this.rows=row}

            


    public int hasTreasure(Position position){
        int score =0;
       for (Treasure t:treasures ){
           if (t.getPosition().equals(position)&&t.getValid()){
               score= t.getScore();
           }

       }
       return score;
    }
    public void update(Position pos){
        for (Treasure t:treasures) {
            if(t.getPosition().equals(pos))
                t.setValid();

        }
    }
    public boolean isActive(){
        boolean flag=false;
        for (Treasure t:treasures) {
            if (t.getValid())flag=true;
        }return flag;
    }

    public int getColumns() {
       return columns;
    }

    public int getRows() {
        return rows;
    }

}
