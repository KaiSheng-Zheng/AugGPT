public class ChessboardPoint {
    private int x;
    private int y;

    private boolean validCoordinates( int x,int y){
        return x >= 0 && x < 8 && y < 8 && y >= 0;
    }


    public ChessboardPoint(int x,int y){
        if(validCoordinates(x,y)==false){
            this.x = -1;
            this.y = -1;
        }
        else{
            this.x=x;
            this.y=y;
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(o.getClass() != this.getClass()){
            return false;
        }
        if (x != this.x){
            return false;
        }
        if (y != this.y){
            return false;
        }
        ChessboardPoint m = (ChessboardPoint) o;
        return x== m.x  &&  y== m.y;
    }

    public ChessboardPoint offset(int x1, int y1){
        return validCoordinates(x+x1,y+y1)?new ChessboardPoint(x+x1,y+y1):null;
    }
}
