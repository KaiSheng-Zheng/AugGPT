import java.util.ArrayList;import java.util.List;


public class Map {

        private final int rows;
        private final int columns;
        private boolean isActive;
        private Treasure[] treasures;


        public Map(int rows, int columns, Treasure[] treasures) {
            this.rows = rows;        this.columns = columns;
            this.treasures = treasures;
            this.isActive = true;
            if (treasures == null || treasures.length == 0){
                this.isActive=false;
            }
        }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

        public int hasTreasure(Position position) {
            boolean sdts=true;
            if(treasures.length==0){
                sdts=false;
            }
            if(sdts==true){
            for (Treasure treasure : treasures) {
                if (treasure.getPosition().equals(position)) {
                    return treasure.getScore();
                }
            }}
            return 0;
        }
    List<Treasure> treasures1 = new ArrayList<>();
        public void alter(Treasure[] treasures){

            for (int i = 0; i < treasures.length; i++){
                treasures1.add(treasures[i]);
            }
        }

        public void update(Position position) {
            for (int i = 0; i < treasures.length; i++) {
                if (treasures[i].getPosition().equals(position)) {
                    treasures1.remove(i);
                    for(int j=0;j<treasures1.size();j++){
                        treasures[j]=treasures1.get(j);
                    }
                    break;
                }
            }
            if (treasures1.isEmpty()) {
                isActive = false;
            }
        }

        public boolean isActive() {
            return isActive;
        }
    }
