public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public String toString(){
        return String.format("(%s,%s)", getX(), getY());
    }

    public ChessboardPoint offset(int dx, int dy){

            int newX = this.x+dx;
            int newY = this.y+dy;
            if((newX<8 &&newX>=0)&&(newY<8&&newY>=0)){
                return new ChessboardPoint(newX,newY);
            }else {
                return null;
            }
        }

}