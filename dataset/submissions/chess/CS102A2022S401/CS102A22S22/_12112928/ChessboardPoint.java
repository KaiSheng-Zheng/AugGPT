import java.util.Objects;

public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
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
    public String toString(){
        StringBuilder a=new StringBuilder();
        a.append("(").append(getX()).append(",").append(getY()).append(")");

        return a.toString();
    }
    public ChessboardPoint offset(int dx, int dy){
        if(x+dx>7||x+dx<0||y+dy>7||y+dy<0){
            return null;
        }
        else{
            ChessboardPoint t=new ChessboardPoint(x+dx,y+dy);
        return t;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
