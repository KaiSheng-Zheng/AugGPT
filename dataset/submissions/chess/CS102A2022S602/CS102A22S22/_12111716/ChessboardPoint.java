public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public String toString(){
        return String.format("(%d,%d)",this.x,this.y);
    }
    public ChessboardPoint offset(int dx, int dy){
       int x=getX()+dx;
       int y=getY()+dy;
        if((x>7||x<0)||((y>7||y<0))){
            return null;
        }else {
            return new ChessboardPoint(x,y);
        }
    }
}
