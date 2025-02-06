
public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        if(0<=x && x<8 && 0<=y && y<8){
        this.x=x;
        this.y=y;}
        else{this.x=this.y=-1;}
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }


   @Override
   public boolean equals(Object obj){
        if(obj==this){return true;}
        if(obj==null){return false;}
       if(obj.getClass()!=this.getClass()){
           return false;
       }
       ChessboardPoint p=(ChessboardPoint) obj;
       return x==p.x&&y==p.y;
   }

    public ChessboardPoint offset(int dx, int dy){
ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);
if(x+dx<0 || x+dx>=8 || y+dy<0 || y+dy>=8){return null;}
return chessboardPoint;
    }
}