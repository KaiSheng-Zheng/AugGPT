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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx,int dy){
        int newX = x + dx;
        int newY = y + dy;
        if ((newX >= 0 && newX <= 7) && (newY >= 0 && newY<= 7)){
            return new ChessboardPoint(newX,newY);
        }else{
            return null;
        }
    }
}