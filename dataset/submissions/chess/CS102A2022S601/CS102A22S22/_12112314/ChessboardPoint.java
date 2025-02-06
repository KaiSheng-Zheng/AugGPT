public class ChessboardPoint {
    private int x;private int y;
    public ChessboardPoint(int x, int y){
        setX(x);setY(y);
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
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy){
        if (getX()+dx>7||getY()+dy>7||getX()+dx<0||getY()+dy<0){return null;}
        else {return new ChessboardPoint(getX()+dx,getY()+dy);}
    }
}