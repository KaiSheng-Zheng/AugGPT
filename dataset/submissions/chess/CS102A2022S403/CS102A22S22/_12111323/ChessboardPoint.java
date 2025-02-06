public class ChessboardPoint {
    private int x;
    private int y;

 @Override
    public boolean equals(Object obj) {
  
        ChessboardPoint that =(ChessboardPoint) obj;
        return x == that.x&& y== that.y;

    }
    
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

        return"("+x+","+y+")";
    }



    public ChessboardPoint offset(int dx, int dy) {
       if(this.x+dx>=0 && this.y+dy>=0 && this.x+dx<=7 && this.y+dy<=7) {
           return new ChessboardPoint(this.x + dx,
                   this.y + dy);
       }
       else {
           return null;
       }

    }
}
