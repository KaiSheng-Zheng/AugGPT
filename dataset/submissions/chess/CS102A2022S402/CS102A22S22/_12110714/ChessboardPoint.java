public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;
    @Override
    public int compareTo(ChessboardPoint o){
        if(this.getX()<o.getX()){
            return -1;
        }else if(this.getX()==o.getX()){
            if(this.getY()<o.getY()){
                return -1;
            }else return 1;
        }else return 1;
    }
  public ChessboardPoint(int x, int y) {
      this.x = x;
      this.y = y;
  }
      public int getX(){
          return x;
      }
      public int getY(){
      return y;
  }
    public String toString(){
      return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx, int dy){
      if(getX()+dx>7|getY()+dy>7|getX()+dx<0|getY()+dy<0){
          return null;
      }else {
          return new ChessboardPoint(getX()+dx,getY()+dy);
      }
    }
}
