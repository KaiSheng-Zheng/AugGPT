public class ChessboardPoint {
    private int x, y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint(){};

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint offset(int dx, int dy){
        if((this.getX()+dx)<8&&(this.getX()+dx)>=0&&
                (this.getY()+dy)<8&&(this.getY()+dy)>=0)
        { ChessboardPoint a=new ChessboardPoint(this.x+dx,this.y+dy);
        return a;}
        else return null;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
