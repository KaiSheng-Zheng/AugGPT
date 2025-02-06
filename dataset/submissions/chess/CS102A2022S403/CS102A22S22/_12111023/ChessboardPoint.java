public class ChessboardPoint {
    private int x;
    private int y;


    public ChessboardPoint(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    public String toString(){
        return "("+this.x + "," +this.y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        if ((dx + this.x < 0) || (dx + this.x > 7)||(dy+this.y<0)||(dy+this.y>7)){
            return null;
        }
        else {
            return new ChessboardPoint(dx+this.x,dy+this.y);
        }

    }
}
