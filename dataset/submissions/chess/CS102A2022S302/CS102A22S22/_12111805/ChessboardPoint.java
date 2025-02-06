public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){return x;}
    public int getY(){return y;}

    @Override
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy){
        int x=getX();
        int y=getY();
        x=x+dx;
        y=y+dy;
        if (x>7||y>7||x<0||y<0) return null;
        return new ChessboardPoint(x,y);
    }
}