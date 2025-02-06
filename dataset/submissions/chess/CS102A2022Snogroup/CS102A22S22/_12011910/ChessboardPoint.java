

public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX()==o.getX()) return this.getY()-o.getY();
        return this.getX()-o.getX();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        String ret="";
        ret+='(';
        ret+=getX();
        ret+=',';
        ret+=getY();
        ret+=')';
        return ret;
    }



    public ChessboardPoint offset(int dx, int dy) {
        if(x+dx>=8||x+dx<0||y+dy>=8||y+dy<0) return null;
        ChessboardPoint a =new ChessboardPoint(x+dx,y+dy);
        return a;
    }
}
