public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){this.x=x;this.y=y;}

    public int getY() {return y;}

    public int getX() {return x;}

    @Override
    public String toString() {return String.format("(%d,%d)",x,y);}

    public ChessboardPoint offset(int dx, int dy){
        if (x+dx<=7&&x+dx>=0&&y+dy>=0&&y+dy<=7){
            ChessboardPoint result=new ChessboardPoint(x+dx,y+dy);
            return result;
        }else {
            return null;
        }
    }

    public boolean offset(int dx, int dy,int a){
        if (x+dx<=7&&x+dx>=0&&y+dy>=0&&y+dy<=7){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isBounded(ChessboardPoint point){
        int x= point.getX();
        int y= point.getY();
        if (x>=0&&x<=7&&y>0&&y<=7){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isBounded(int x,int y){

        if (x>=0&&x<=7&&y>=0&&y<=7){
            return true;
        }else {
            return false;
        }
    }


}
