public class ChessboardPoint extends ConcreteChessGame {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ")";
    }
    public ChessboardPoint offset(int dx, int dy){
       // System.out.println(new ChessboardPoint(x,y));
        int xx,yy;
        xx=x+dx;
        yy=y+dy;
       //System.out.println(new ChessboardPoint(xx,yy));
        if(xx<0||xx>7||yy<0||yy>7||(board[xx][yy].name!='_')) return null;
        else {
            return new ChessboardPoint(xx,yy);
        }
    }
}

