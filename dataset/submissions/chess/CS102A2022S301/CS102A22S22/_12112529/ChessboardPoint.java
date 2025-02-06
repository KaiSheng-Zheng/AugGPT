public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint( int x, int y ){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy){
        if (getX() + dx <= 7 && this.x + dx >=0 && this.y + dy <=7 && this.y +dy >=0){
        return new ChessboardPoint(getX() + dx, getY() + dy);
        }
        return null;
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
}
