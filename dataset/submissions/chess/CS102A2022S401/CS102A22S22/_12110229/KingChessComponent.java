import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> tmp = new ArrayList<>();
        int tmpX = getSource().getY();
        int tmpY = getSource().getX();
        if (boundary(tmpY-1,tmpX-1) && checkChess(tmpY-1,tmpX-1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY-1,tmpX-1));
        }
        if (boundary(tmpY-1,tmpX) && checkChess(tmpY-1,tmpX,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY-1,tmpX));
        }
        if (boundary(tmpY-1,tmpX+1) && checkChess(tmpY-1,tmpX+1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY-1,tmpX+1));
        }
        if (boundary(tmpY,tmpX-1) && checkChess(tmpY,tmpX-1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY,tmpX-1));
        }
        if (boundary(tmpY,tmpX+1) && checkChess(tmpY,tmpX+1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY,tmpX+1));
        }
        if (boundary(tmpY+1,tmpX-1) && checkChess(tmpY+1,tmpX-1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY+1,tmpX-1));
        }
        if (boundary(tmpY+1,tmpX) && checkChess(tmpY+1,tmpX,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY+1,tmpX));
        }
        if (boundary(tmpY+1,tmpX+1) && checkChess(tmpY+1,tmpX+1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpY+1,tmpX+1));
        }
        tmp.sort(Comparator.comparingInt(ChessboardPoint::getY));
        tmp.sort(Comparator.comparingInt(ChessboardPoint::getX));
        if (tmp.isEmpty()){
            ArrayList out = new ArrayList();
            return out;
        }
        return tmp;
    }


}
