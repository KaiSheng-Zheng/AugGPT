public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ChessboardPoint(){}

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", getX(), getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (0 <= getX() + dx && getX() + dx <= 7) {
            if (0 <= getY() + dy && getY() + dy <= 7) {
                return new ChessboardPoint(getX() + dx, getY() + dy);
            }
            return null;
        }
        return null;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) {return true;}
        if (o == null || !(o instanceof ChessboardPoint)){return false;}
        ChessboardPoint point = (ChessboardPoint) o;
        if((this.getX() == ((ChessboardPoint) o).getX()) & (this.getY() == ((ChessboardPoint) o).getY())){
            return true;
        }else return false;
    }
}
