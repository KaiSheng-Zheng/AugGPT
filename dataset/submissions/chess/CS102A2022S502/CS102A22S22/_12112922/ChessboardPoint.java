public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public String toString(){
        StringBuilder position = new StringBuilder("(");
        position.append(x);
        position.append(",");
        position.append(y);
        position.append(")");
        return position.toString();
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint newPoint = new ChessboardPoint(x + dx,y + dy);
        if(newPoint.getX() < 0 || newPoint.getX() > 7 || newPoint.getY() < 0 || newPoint.getY() > 7){
            return null;
        }else{
            return newPoint;
        }
    }
}
