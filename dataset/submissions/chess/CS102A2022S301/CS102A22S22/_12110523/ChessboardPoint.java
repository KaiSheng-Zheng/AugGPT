public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        if (x>=0&&x<=7&&y>=0&&y<=7){
        this.x = x;
        this.y = y;
        }
        else {this.x=-996;
        this.y=-996;
        }


    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){

        String s=String.format("(%d,%d)",x,y);
        return s;

    }
    public ChessboardPoint offset(int dx, int dy){
        int a=x,b=y;
        a+=dx;
        b+=dy;
        ChessboardPoint cp=new ChessboardPoint(a,b);
        if (a<=7&&a>=0&&b>=0&&b<=7) return cp;
        return null;
    }
}

