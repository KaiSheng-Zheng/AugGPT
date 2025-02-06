public class ChessboardPoint {
    private int x,y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof ChessboardPoint)){
            return false;
        }

        if(this == obj){
            return true;
        }

        ChessboardPoint point = (ChessboardPoint) obj;
        return this.x==point.x && this.y==point.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int m;
        int n;
        m=getX();
        n=getY();
        if(x+dx>=0&&x+dx<=7&&y+dy>=0&&y+dy<=7){
            ChessboardPoint second=new ChessboardPoint(m+dx,n+dy);
            return second;
        }
        else{return null;}
    }
}
