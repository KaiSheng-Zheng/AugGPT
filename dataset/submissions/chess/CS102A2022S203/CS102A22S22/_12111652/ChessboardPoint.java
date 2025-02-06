public class ChessboardPoint {
        private int x;
        private int y;

        public ChessboardPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
public ChessboardPoint(ChessboardPoint chessboardPoint){
            this.x= chessboardPoint.getX();
            this.y= chessboardPoint.getY();
}
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
            String s = "(" + x + "," + y + ")";
            return s;
        }

        public ChessboardPoint offset(int dx, int dy) {
            int h = 0;
            int v = 0;
            h = x + dx;
            v = y + dy;
            if (h <= 7 && h >= 0 && v <= 7 && v >= 0) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(h, v);
                return chessboardPoint;
            } else {
                return null;
            }
        }
    }

