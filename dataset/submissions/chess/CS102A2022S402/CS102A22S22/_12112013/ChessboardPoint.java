public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {return x;}
    public int getY() {return y;}

    @Override
    public String toString(){
        String str=String.format("(%s,%s)",this.getX(),this.getY());
        return str;
    }
    public ChessboardPoint offset(int dx,int dy){
        if (x+dx<=7 && y+dy<=7 &&x+dx>=0 && y+dy>=0){
            ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);
            return chessboardPoint;
        }else return null;
    }
}
