public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
        if (this.x>=8|this.y<0|this.x<0|this.y>=8) {

        }
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "("+getX()+","+getY()+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        dx +=this.x;
        dy += this.y;
        if (dx>=8|dy<0|dx<0|dy>=8){
            return null;
        }else {
            return new ChessboardPoint(dx,dy);
        }
    }


    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x<o.getX()){
            return -1;
        }else if (this.x == o.getX()&&this.y<o.getY()){
            return -1;
        }else {
            return 1;
        }

    }
}
