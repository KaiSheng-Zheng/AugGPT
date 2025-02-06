public class ChessboardPoint {
    private int x ;
    private int y ;

    public ChessboardPoint(int x, int y){
        this.x = x ;
        this.y = y ;
    }

    public int getX(){
        return this.x ;
    }

    public int getY(){
        return this.y ;
    }

    public void transformX(int dx){ //???
        this.x += dx ;
    }

    public void transformY(int dy){ //???
        this.y += dy ;
    }
    public String toString(){
        return String.format("(%d,%d)", this.getX(), this.getY());
    }

    public ChessboardPoint offset(int dx, int dy){ //???
        if ( getX() + dx > 7 && getY() + dy > 7){
            return null ;
        } else {
            return new ChessboardPoint(dx+getX(), dy+getY());
        }
    }
}
