public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        String output="";
        output=output.concat("("+getX()+","+getY()+")");
        return output;
    }
    public ChessboardPoint offset(int dx, int dy){
        if(x+dx>=0&&x+dx<=7&&y+dy>=0&&y+dy<=7){
            this.x=x+dx;
            this.y=y+dy;
        }else {
            return null;
        }
        return new ChessboardPoint(this.x,this.y);
    }
}