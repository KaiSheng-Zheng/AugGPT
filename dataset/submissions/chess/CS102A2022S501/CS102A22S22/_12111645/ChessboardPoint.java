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
        String string;
        string="("+x+","+y+")";
        return string;
    }



    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint store = null;
        if(dx+x<=7 && dy+y<=7 && dx+x>=0 && dy+y>=0){
            store=new ChessboardPoint (dx+x,dy+y);
        }

        return store;
    }
}
