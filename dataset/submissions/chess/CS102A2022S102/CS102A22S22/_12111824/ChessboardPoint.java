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

    @Override
    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx,int dy){
        x+=dx;y+=dy;
        if(x>7||x<0||y>7||y<0){
            x-=dx;y-=dy;
            return null;
        }
        else {
            ChessboardPoint i=new ChessboardPoint(x,y);
            x-=dx;y-=dy;
            return i;
        }
    }

}