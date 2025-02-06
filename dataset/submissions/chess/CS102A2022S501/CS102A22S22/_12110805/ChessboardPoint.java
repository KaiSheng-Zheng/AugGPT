public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y;
    public ChessboardPoint(int x, int y){
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
        String f=String.format("(%d,%d)",x,y);
        return f;
    }
    public ChessboardPoint offset(int dx, int dy){
        int z=x+dx;
        int h=y+dy;
        ChessboardPoint f=new ChessboardPoint(z,h);
        if(z<0||z>7||h<0||h>7){
            return null;
        }else {
            return f;
        }
    }

}
