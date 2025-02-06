public class ChessboardPoint {
    
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    
    public ChessboardPoint(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7){
            this.x = x;
            this.y = y;
        }else{
            this.x = -1;
            this.y = -1;
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    @Override
    public boolean equals(Object obj){
        ChessboardPoint chessboardPoint=(ChessboardPoint) obj;
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        if (x == chessboardPoint.x && y == chessboardPoint.y){
            return true;  
        }else{
            return false;
        }
    }
    public ChessboardPoint offset(int dx, int dy) {
        int x1 = getX() + dx;
        int y1 = getY() + dy;
        if (x1 > 7 || x1 < 0 || y1 < 0 || y1 > 7) {
            return null;
        }else{
            ChessboardPoint chessboardPoint = new ChessboardPoint(x1, y1);
            return chessboardPoint;
        }
    }
}
