public class Map {

        private final int rows;
        private final int columns;
        private boolean isActive = true ;
        private Treasure[] treasures;
        private int sum = 0;

        public Map(int rows, int columns, Treasure[] treasures){
            this.rows = rows;
            this.columns = columns;
            this.treasures = treasures;
        }
        public int hasTreasure(Position position){
            for (int i = 0; i < this.treasures.length ; i++) {
                if (treasures[i] != null) {
                    if ((position.getRow() == this.treasures[i].getPosition().getRow()) && (position.getCol() == this.treasures[i].getPosition().getCol())) {
                        return this.treasures[i].getScore();
                    }
                }
            }
            return 0;
        }
        public void update(Position position){
            for (int i = 0; i < treasures.length ; i++) {
                if (treasures[i] != null) {
                    if ((position.getCol() == treasures[i].getPosition().getCol()) && (position.getRow() == treasures[i].getPosition().getRow())){
                        treasures[i] = null;
                        this.sum++;
                    }
                }
            }
            if(this.getSum() == treasures.length){
                isActive = false;
            }
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

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }
    }


