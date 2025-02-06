public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
        }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public ChessboardPoint offset(int dx, int dy){
        if (x+dx>=0&&x+dx<=7){
            if (y+dy>=0&&y+dy<=7){
                this.x+=dx;
                this.y+=dy;
                return new ChessboardPoint(this.x,this.y);
            }else return null;
        }return null;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChessboardPoint){
            return this.equals((ChessboardPoint)obj);
        }else return false;
    }

    public boolean equals(ChessboardPoint chessboardPoint) {
        if (this.x==chessboardPoint.x&&this.y==chessboardPoint.y){
            return true;
        }else return false;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x<o.x){
            return -1;
        }else if (this.x==o.x){
            if (this.y<o.y){
                return -1;
            }else if (this.y==o.y){
                return 0;
            }else {
                return 1;
            }
        }else return 1;
    }
}

