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
    public String toString(){
        return "(" + x + "," + y + ")";
        //System.out.printf("(%d,%d)", getX(), getY());
    }
    public ChessboardPoint offset(int dx, int dy){
        int Dx = x + dx;
        int Dy = y + dy;
        if ((Dx < 0 || Dx > 7)||(Dy < 0 || Dy > 7)){
            return null;
        }
        else {return new ChessboardPoint(Dx, Dy);}
    }
}