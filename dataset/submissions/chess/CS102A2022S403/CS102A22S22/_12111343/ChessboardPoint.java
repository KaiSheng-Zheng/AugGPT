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
        return "("+x+","+y+")";
    }

    @Override
    public boolean equals(Object o){
        if(o==null){
            return false; }
        if(o.getClass()!=this.getClass()){
            return false; }
        ChessboardPoint p=(ChessboardPoint)o;
        return x==p.x&&y==p.y;
    }
}