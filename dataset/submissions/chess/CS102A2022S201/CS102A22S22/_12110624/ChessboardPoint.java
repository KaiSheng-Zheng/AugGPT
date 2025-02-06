public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = (x>=0 && x<=7)? x : 0;
        this.y = (y>=0 && y<=7)? y : 0;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString(){
        return String.format("(%d,%d)", x, y);
    }
    public ChessboardPoint offset(int x, int y){
        int xo = this.x + x;
        int yo = this.y + y;
        ChessboardPoint p = new ChessboardPoint(xo,yo);
        if(xo>=0 && xo<=7 && yo>=0 && yo<=7)
            return p;
        else
            return null;

    }
}
