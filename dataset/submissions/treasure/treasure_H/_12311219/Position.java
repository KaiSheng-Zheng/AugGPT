 public class Position {
      
        private int row;
        private int col;

       
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

       
        public boolean equals(Object pos) {


            Position otherPos = (Position) pos;
           
            return row == otherPos.row && col == otherPos.col;
        }

        
        public int getRow() {
            return row;
        }

       
        public int getCol() {
            return col;
        }
    }

