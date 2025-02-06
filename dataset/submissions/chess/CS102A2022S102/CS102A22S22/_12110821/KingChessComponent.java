import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
        int a=getSource().getX(); int b=getSource().getY();
        if (a+1>=0&&a+1<=7&&b+1>=0&&b+1<=7){
            temp.add(new ChessboardPoint(a+1,b+1));
        }
        if (a-1>=0&&a-1<=7&&b-1>=0&&b-1<=7){
            temp.add(new ChessboardPoint(a-1,b-1));
        }
        if (a+1>=0&&a+1<=7&&b-1>=0&&b-1<=7){
            temp.add(new ChessboardPoint(a+1,b-1));
        }
        if (a-1>=0&&a-1<=7&&b+1>=0&&b+1<=7){
            temp.add(new ChessboardPoint(a-1,b+1));
        }
        if (a+1>=0&&a+1<=7){
            temp.add(new ChessboardPoint(a+1,b));
        }
        if (a-1>=0&&a-1<=7){
            temp.add(new ChessboardPoint(a-1,b));
        }
        if (b+1>=0&&b+1<=7){
            temp.add(new ChessboardPoint(a,b+1));
        }
        if (b-1>=0&&b-1<=7){
            temp.add(new ChessboardPoint(a,b-1));
        }
        temp.removeIf(dot -> array[getSource().getX()][getSource().getY()].getChessColor() .equals(array[dot.getX()][dot.getY()].getChessColor()) );
        return temp;
    }
}
