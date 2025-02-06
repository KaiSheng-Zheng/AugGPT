public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint point=new ChessboardPoint(0,0);

        if(x+dx<=7&&x+dx>=0&&y+dy<=7&&y+dy>=0) {
            point.setX(x+dx);
            point.setY(y+dy);
            return point;
        }
        else return null;
    }

}