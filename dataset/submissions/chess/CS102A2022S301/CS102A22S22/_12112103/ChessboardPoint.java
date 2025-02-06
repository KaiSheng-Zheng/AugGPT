public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        boolean t=true;
        if(x+dx>7||x+dx<0)t=false;
        if(y+dy>7||y+dy<0)t=false;
        if(t){
            ChessboardPoint nCBP=new ChessboardPoint(x+dx,y+dy);
            return nCBP;
        }else return null;
    }

    public boolean onBoard(ChessboardPoint chessboardPoint){
        if (chessboardPoint.getX()<8&&chessboardPoint.getX()>=0&&chessboardPoint.getY()<8&&chessboardPoint.getY()>=0){
            return true;
        }else return false;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX()>o.getX()){
            return 1;
        }else if(this.getX()==o.getX()){
            if(this.getY()>o.getY()) {
                return 1;
            }else if(this.getY()==o.getY()) {
                return 0;
            }else return -1;
        }else return -1;
    }
}
