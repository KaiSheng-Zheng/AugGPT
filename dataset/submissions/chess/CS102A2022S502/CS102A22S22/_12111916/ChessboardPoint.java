public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x; this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        if(getX()+dx>=0 && getX()+dx<=7 &&getY()+dy>=0 && getY()+dy<=7){
            return new ChessboardPoint(getX()+dx,getY()+dy);
        }else {
            return null;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
