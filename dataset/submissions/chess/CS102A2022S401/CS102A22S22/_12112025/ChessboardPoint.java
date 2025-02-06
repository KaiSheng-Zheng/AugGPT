public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;this.y=y;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        StringBuilder S=new StringBuilder();
        S.append("(");
        S.append(x);
        S.append(",");
        S.append(y);
        S.append(")");
        String toString=S.toString();
        return toString;
    }
    public ChessboardPoint offset(int dx, int dy){
        if (dx+getX()<0|dx+getX()>7|dy+getY()<0|dy+getY()>7){
            return null;
        }else{
            return new ChessboardPoint(x+dx,y+dy);
        }

    }
}