public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy){
        if(getX()+dx<0||getX()+dx>7||getY()+dy<0||getY()+dy>7){
            return null;
        }
        else {
            return new ChessboardPoint(x+dx,y+dy);
        }
    }
}