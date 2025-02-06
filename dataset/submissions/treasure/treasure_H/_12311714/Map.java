    public class Map {
        private final int rows;
        private final int columns;

        private boolean isActive;
        private Treasure[] treasures;

        private int[][] mp;
        public Map(int rows, int columns, Treasure[] treasures) {
            this.rows = rows;
            this.columns = columns;
            this.treasures = treasures;
            isActive=true;
            mp=new int[rows+100][columns+100];
            for(int i=0;i<treasures.length;i++)
                mp[treasures[i].getPosition().getRow()][treasures[i].getPosition().getCol()]=treasures[i].getScore();
        }
        public int hasTreasure(Position position){
            return mp[position.getRow()][position.getCol()];
        }
        public void update(Position position){
            mp[position.getRow()][position.getCol()]=0;
            for(int i=0;i<rows;i++)
                for(int j=0;j<columns;j++){
                    if(mp[i][j]!=0){
                        isActive=true;
                        return;
                    }
                }
            isActive=false;
        }

        public boolean isActive() {
            return isActive;
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
    }
