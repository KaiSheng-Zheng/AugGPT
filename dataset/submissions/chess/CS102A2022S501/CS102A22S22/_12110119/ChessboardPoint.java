public class ChessboardPoint {
    private int x;
    private int y;

  public ChessboardPoint(int x, int y){
      this.x=x;
      this.y=y;
  }
    public int getX(){return x;}
    public int getY(){return y;}
    public String toString(){

      return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
      int newX=x+dx;
      int newY=y+dy;
      if(newX>=0&&newY>=0&&newX<=7&&newY<=7){return new ChessboardPoint(newX,newY);}else return null;
    }

    public boolean equals(ChessboardPoint i){
      if(x==i.getX()&&y==i.getY()){return true;}
      else return false;
    }
}
