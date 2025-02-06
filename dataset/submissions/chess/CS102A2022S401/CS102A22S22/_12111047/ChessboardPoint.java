public class ChessboardPoint {
    private int x;
    private int y;
    private int X;
    private int Y;

    public ChessboardPoint(int x, int y){
        X = x;
        Y = y;
    }

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }

    public String toString(){
        return String.format("(%d,%d)",X,Y);
    }

    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint eg = new ChessboardPoint(X + dx , Y + dy);
        if(X + dx > 8 || X + dx < 1 || Y +  dy > 8 || Y +dy < 1)
            return null;
        else
            return eg;
    }
}
