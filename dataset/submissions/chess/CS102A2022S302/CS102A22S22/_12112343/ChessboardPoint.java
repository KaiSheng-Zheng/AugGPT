public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "("+getX()+","+getY()+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if((getX() + dx) < 0 || (getX() + dx) > 7 || (getY() + dy) < 0 || (getY() + dy) > 7 ){
            return null;
        }
        return new ChessboardPoint(getX()+dx,getY()+dy);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        ChessboardPoint chessboardPoint = (ChessboardPoint) obj;
        if(getX() != chessboardPoint.getX()){
            return false;
        }
        if(getY() != chessboardPoint.getY()){
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX() > o.getX()){
            return 1;
        }
        if(this.getX() < o.getX()){
            return -1;
        }
        return this.compareY(o);
    }

    public int compareY(ChessboardPoint o){
        if(this.getY() > o.getY()){
            return 1;
        }
        else if(this.getY() < o.getY()){
            return -1;
        }
        return 0;
    }
}
