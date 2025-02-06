    public class ChessboardPoint {
        private int x;
        private int y;
        public ChessboardPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            String s = new String();
            s = "(" + getX() + "," + getY() + ")";
            return s;
        }

        public ChessboardPoint offset(int dx, int dy) {
            ChessboardPoint coordinate = new ChessboardPoint(getX() + dx,getY() + dy);
            if (getX() + dx > 7 || getX() + dx < 0 || getY() + dy > 7 || getY() + dy < 0){
                return null;
            }
            else {
              return coordinate;
            }
        }
    }
