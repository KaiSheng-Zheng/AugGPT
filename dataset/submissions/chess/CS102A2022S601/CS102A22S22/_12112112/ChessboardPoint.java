public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        int a=0;
        int b=0;
        a=this.x+dx;
        b=this.y+dy;
        ChessboardPoint c=new ChessboardPoint(a, b);
        if (a>=0 && a<=7 && b>=0 && b<=7){
            return c;
        }else {
            return null;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x-o.x==0){
            return this.y-o.y;
        }
        return this.x-o.x;
    }
}
