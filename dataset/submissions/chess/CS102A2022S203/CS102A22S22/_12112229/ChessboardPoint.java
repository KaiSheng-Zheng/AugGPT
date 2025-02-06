import java.text.Format;

public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }


    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint cbp= new ChessboardPoint(this.x,this.y);
        int newX=cbp.getX()+dx;
        int newY=cbp.getY()+dy;
        if (newX>=0&&newX<=7&&newY>=0&&newY<=7){
            cbp.setX(newX);
            cbp.setY(newY);
            return cbp;
        }else return null;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
