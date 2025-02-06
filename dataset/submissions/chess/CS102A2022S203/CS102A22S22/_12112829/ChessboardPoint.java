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
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx,int dy){
        int newX=getX()+dx;
        int newY=getY()+dy;
        boolean x =newX>=0&&newX<=7;
        boolean y =newY>=0&&newY<=7;
        if (x && y){
            return new ChessboardPoint(newX,newY);
        }else {
            return null;
        }
    }
}
