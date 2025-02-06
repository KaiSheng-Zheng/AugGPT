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
    public int getY() {
        return y;
    }
    public String toString(){
        String a = "("+getX()+","+getY()+")";
        return a;
    }
    public ChessboardPoint offset(int dx, int dy){
        if ((getX()+dx>=0)&&(getX() +dx<=7)&&(getY()+dy>=0)&&(getY()+dy<=7)){
            return new ChessboardPoint(getX()+dx,getY()+dy);
        }
        else {
            return null;
        }
    }
}
