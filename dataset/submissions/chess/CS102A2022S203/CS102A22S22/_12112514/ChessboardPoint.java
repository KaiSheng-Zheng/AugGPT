public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
      this.x=x;
      this.y=y;
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
    public String toString(){
        String a = "("+String.valueOf(x)+","+String.valueOf(y)+ ")";
        return a;
    }
    public ChessboardPoint offset(int dx, int dy){
        int nx=x+dx;
        int ny=y+dy;
        ChessboardPoint np  = new ChessboardPoint(nx,ny);
        if(ny>=0 && ny<=7 && nx>=0 && nx<=7){
            return  np;
        }
        else{
            return  null;
        }
    }
}

