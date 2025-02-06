public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx,int dy){
        ChessboardPoint point=new ChessboardPoint(x+dx,y+dy);
        if(point.getX()>=8||point.getY()>=8||point.getX()<0||point.getY()<0){
            return null;
        }else {
            return point;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        return 0;
    }
}
