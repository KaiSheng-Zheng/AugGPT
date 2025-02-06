public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
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
        return String.format("(%d,%d)",this.x,this.y) ;
    }

    public ChessboardPoint offset(int dx, int dy){
        int x1 = this.x + dx ;
        int y1 = this.y + dy ;
        ChessboardPoint result = new ChessboardPoint(x1,y1) ;
        if(x1 >= 0 && x1 <= 7){
            if(y1 >= 0 && y1 <= 7){
                return result ;
            }
            else{
                return null ;
            }
        }
        else{
            return null;
        }
    }

}
