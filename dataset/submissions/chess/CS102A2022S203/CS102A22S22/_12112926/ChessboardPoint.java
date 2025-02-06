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

    public String toString(){
        String a = String.valueOf(getX());
        String b = String.valueOf(getY());
        return "(" + a +  "," + b +")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if((getX()+dx>7) || (getY()+dy>7) || (getX()+dx<0) || (getY()+dy<0)){
            return null;
        }
        else{
            return new ChessboardPoint(dx+getX(),dy+getY());
        }
    }
}
