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


    @Override
    public String toString(){

        return "("+getX()+","+getY()+")";
    }


    public ChessboardPoint offset(int dx, int dy) {
        if (dx+getX()>7||dy+getY()>7||dx+getX()<0||dy+getY()<0){
            return null;
        }else {
            ChessboardPoint newpoint = new ChessboardPoint(this.x+dx,this.y+dy);
            return newpoint;
        }
    }
}
