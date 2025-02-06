public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
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
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint Chessboardpoint =new ChessboardPoint(this.x+dx,this.y+dy);
        if (Chessboardpoint.getX()>=0 && Chessboardpoint.getY()>=0 && Chessboardpoint.getX()<=7 && Chessboardpoint.getY()<=7){
            return Chessboardpoint;
        }
        else return null;
    }

    public boolean Check(){
        if (x>=0 && y>=0 && x<=7 && y<=7){
            return true;
        }
        else return false;
    }

    public int Calculate(){
        return x*10+y;
    }

}
