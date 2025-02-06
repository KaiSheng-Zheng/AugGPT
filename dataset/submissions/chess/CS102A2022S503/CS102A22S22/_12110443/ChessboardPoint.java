public class ChessboardPoint {
    private int x;
    private int y;


    public ChessboardPoint(int x,int y){

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
        String sc = "("+getX()+","+getY()+")";
        return sc;
    }

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y = y;
    }

    public ChessboardPoint offset(int dx,int dy){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x+dx,y+dy);
        if(x+dx<0||x+dx>7||y+dy<0||y+dy>7){
            return null;
        }else {
            return chessboardPoint;
        }
    }


}
