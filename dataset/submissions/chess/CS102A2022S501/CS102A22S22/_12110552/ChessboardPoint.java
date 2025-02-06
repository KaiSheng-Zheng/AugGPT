public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
       return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        ChessboardPoint chessboardpoint = (ChessboardPoint) o;
        return x == chessboardpoint.x && y == chessboardpoint.y;
    }
    public ChessboardPoint offset(int dx, int dy){
        int x1 = this.x + dx;
        int y1 = this.y + dy;
        if(0 <= x1 && x1 <= 7 && 0 <= y1 && y1 <= 7) {
            return new ChessboardPoint(x1, y1);
        }
        else return null;
    }


}
