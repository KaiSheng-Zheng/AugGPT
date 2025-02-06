public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "("+getX()+","+getY()+")";
    }

    public ChessboardPoint offset(int dx,int dy){
        if(dx+x>7||dy+y>7||dx+x<0||dy+y<0){
            return null;
        }
        else {
        return new ChessboardPoint(dx+x,dy+y);
    }
    }
}