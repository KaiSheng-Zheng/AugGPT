public class ChessboardPoint {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.format("("+getX()+","+getY()+")");
    }
    public ChessboardPoint offset(int dx, int dy){
        int nx=x+dx;
        int ny=y+dy;
        if (nx>=0&&nx<=7&&ny>=0&&ny<=7){
            return new ChessboardPoint(nx,ny);
        }
        else return null;
    }
    public ChessboardPoint realoffset(ChessComponent component){
        if (component.getChessColor()!=component.getChessComponents()[x][y].getChessColor()){
            return new ChessboardPoint(x,y);
        }
        else return null;
    }
    public int eatormove(ChessComponent component){
        if (component.getChessColor()!=component.getChessComponents()[x][y].getChessColor()){
            if (component.getChessComponents()[x][y].getChessColor()==ChessColor.NONE) return 0;
            else return 1;//EAT!!!
        }else return 2;}

}
