public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;

    public ChessboardPoint(int x, int y ){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public String toString(){
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    public ChessboardPoint offset(int dx, int dy){
        int xt = this.getX() + dx;
        int yt = this.getY() + dy;
        if (xt < 0 || xt > 7 || yt < 0 || yt > 7){
            return null;
        } else
        return new ChessboardPoint(xt,yt);
    }

    @Override
    public int compareTo(ChessboardPoint chessboardPoint) {
        return this.getX()*10 + this.getY() - chessboardPoint.getX()*10 - chessboardPoint.getY();
    }
    @Override
    public boolean equals(Object o){
        ChessboardPoint chessboardPoint = (ChessboardPoint) o;
        return x == chessboardPoint.getX() && y==chessboardPoint.getY();
    }

}
