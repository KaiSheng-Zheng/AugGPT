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
    public String toString() {
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy) {
        int x=getX()+dx;if(0>x||x>7){return null;}
        int y=getY()+dy;if(0>y||y>7){return null;}
        return new ChessboardPoint(x,y);
    }
}
