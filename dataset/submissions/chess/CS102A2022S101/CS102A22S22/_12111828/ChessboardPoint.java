public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy){
        if(x+dx<=7&&x+dx>=0&&y+dy<=7&&y+dy>=0){
            ChessboardPoint offset=new ChessboardPoint(getX()+dx,getY()+dy);return offset;
        }else {
            return null;
        }
    }
}