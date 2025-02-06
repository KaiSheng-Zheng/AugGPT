    public class ChessboardPoint {
        private int x; // x: Horizontal location of this chess
        private int y; // y: Vertical location of this chess

        public int getX() {
            return x;
        }
        public ChessboardPoint offset(int dx, int dy){
            ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);

            if (chessboardPoint.x>=8||chessboardPoint.y>=8||chessboardPoint.x<0||chessboardPoint.y<0)return null;
            else return chessboardPoint;


        }
        public ChessboardPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)",x,y);
        }
    }
