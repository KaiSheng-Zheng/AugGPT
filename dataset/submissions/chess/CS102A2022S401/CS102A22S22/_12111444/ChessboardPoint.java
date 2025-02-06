public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint output = new ChessboardPoint(x+dx,y+dy);
        if(0<=(x+dx) && (x+dx)<=7 && 0<=(y+dy) && (y+dy)<=7){
            return output;
        }else{
            return null;
        }
    }
}