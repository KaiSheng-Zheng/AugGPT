public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        String cor = "("+getX()+","+getY()+")";
        return cor;
    }

    public ChessboardPoint offset(int dx, int dy){

        ChessboardPoint shit = new ChessboardPoint(this.x+dx,this.y+dy);
        if(this.x+dx>7||this.x+dx<0||this.y+dy>7||this.y+dy<0){
            return null;
        }else {
            return shit;
        }
    }

}


