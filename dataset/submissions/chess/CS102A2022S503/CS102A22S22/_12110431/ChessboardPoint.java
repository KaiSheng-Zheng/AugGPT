public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    public String toString(){
        String coordinate;
        coordinate="("+x+","+y+")";
        return coordinate;
    }

    public ChessboardPoint offset(int dx, int dy){
        int X=x+dx;
        int Y=y+dy;
        if (X<8&&Y<8&&X>=0&&Y>=0){
            return new ChessboardPoint(X,Y);
        }else return null;
    }
}