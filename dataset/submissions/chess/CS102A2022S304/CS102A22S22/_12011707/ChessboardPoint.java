public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;

    }
    public boolean equals(ChessboardPoint c){
        if(this.x==c.getX()&&this.y==c.y){
            return true;
        }else{
            return false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder sc=new StringBuilder();
        sc.append("(");
        sc.append(getX());
        sc.append(",");
        sc.append(getY());
        sc.append(")");
        return sc.toString();
    }

    public ChessboardPoint offset(int dx, int dy) {
            int outputx=this.x+dx;
            int outputy=this.y+dy;
            if(outputx>=0&&outputx<=7&&outputy>=0&&outputy<=7){
                return new ChessboardPoint(outputx,outputy);
            }else {
                return null;
            }
    }
}
