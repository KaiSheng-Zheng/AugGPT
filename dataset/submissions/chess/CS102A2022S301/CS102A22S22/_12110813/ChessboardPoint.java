public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        if((0<=this.x+dx&&this.x+dx<=7)&&(0<=this.y+dy&&this.y+dy<=7)){
            return new ChessboardPoint(this.x+dx,this.y+dy);
        }else {
            return null;
        }
    }
}
