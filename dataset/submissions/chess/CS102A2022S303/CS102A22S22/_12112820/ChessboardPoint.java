public class ChessboardPoint {
    private int x,y;
    private boolean validCoordinates(int x,int y){
        return x>=0&&x<=7&&y>=0&&y<=7;
    }
    public ChessboardPoint(int x,int y){
        if(validCoordinates(x,y)){
            this.x=x;
            this.y=y;
        }
        else{
            this.x=this.y=-1;
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
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }
    public ChessboardPoint offset(int dx, int dy){
        return validCoordinates(x+dx,y+dy)?new ChessboardPoint(x+dx,y+dy):null;
    }
}
