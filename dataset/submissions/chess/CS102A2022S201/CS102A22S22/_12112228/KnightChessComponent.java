import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e) {
        super( x, y , chessColor, name,e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints =   new ArrayList<ChessboardPoint>();
        int x = source.getX(); int y = source.getY();
        if(source.offset(1,2)!= null) {
            if (chessComponents[x + 1][y + 2].chessColor != chessColor) chessboardPoints.add(source.offset(1, 2));
        }
        if(source.offset(1,-2)!= null) {
            if (chessComponents[x + 1][y - 2].chessColor != chessColor) chessboardPoints.add(source.offset(1, -2));
        }
        if(source.offset(-1,2)!= null) {
            if (chessComponents[x - 1][y + 2].chessColor != chessColor) chessboardPoints.add(source.offset(-1, 2));
        }
        if(source.offset(-1,-2)!= null) {
            if (chessComponents[x - 1][y - 2].chessColor != chessColor) chessboardPoints.add(source.offset(-1, -2));
        }
        if(source.offset(2,1)!= null) {
            if (chessComponents[x + 2][y + 1].chessColor != chessColor) chessboardPoints.add(source.offset(2, 1));
        }
        if(source.offset(-2,1)!= null) {
            if (chessComponents[x - 2][y + 1].chessColor != chessColor) chessboardPoints.add(source.offset(-2, 1));
        }
        if(source.offset(2,-1)!= null) {
            if (chessComponents[x + 2][y - 1].chessColor != chessColor) chessboardPoints.add(source.offset(2, -1));
        }
        if(source.offset(-2,-1)!= null) {
            if (chessComponents[x - 2][y - 1].chessColor != chessColor) chessboardPoints.add(source.offset(-2, -1));
        }
        return chessboardPoints;
    }
}
