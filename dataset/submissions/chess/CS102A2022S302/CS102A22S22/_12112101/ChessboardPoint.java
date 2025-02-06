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
        return "("+ getX() +","+ getY() +")";
    }

    public ChessboardPoint offset(int dx,int dy){
        if (dx+x>7||x+dx<0||y+dy>7||y+dy<0)
            return null;
        else {
            return new ChessboardPoint(x+dx,y+dy);
        }
    }
}
