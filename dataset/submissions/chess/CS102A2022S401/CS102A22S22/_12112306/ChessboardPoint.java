import java.util.ArrayList;
import java.util.List;

public class ChessboardPoint {
    private int x;//horizontal-
    private int y;//vertical|

    public ChessboardPoint(int x,int y){
        this.x = x;
        this.y = y;
    }//constructor

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
@Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(getX());
        str.append(",");
        str.append(getY());
        str.append(")");
        str.insert(0,"(");
        return str.toString();
    }

    public ChessboardPoint offset(int dx,int dy){
        if(x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8){
            return new ChessboardPoint(x + dx,y + dy);
        }else{
            return null;
        }
    }
}
