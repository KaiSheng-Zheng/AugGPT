import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> tmp = new ArrayList<>();
        int tmpY = getSource().getY();
        int tmpX = getSource().getX();
        if (boundary(tmpX-2,tmpY-1) && checkChess(tmpX-2,tmpY-1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX-2,tmpY-1));
        }
        if (boundary(tmpX-2,tmpY+1) && checkChess(tmpX-2,tmpY+1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX-2,tmpY+1));
        }
        if (boundary(tmpX+2,tmpY-1) && checkChess(tmpX+2,tmpY-1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX+2,tmpY-1));
        }
        if (boundary(tmpX+2,tmpY+1) && checkChess(tmpX+2,tmpY+1,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX+2,tmpY+1));
        }
        if (boundary(tmpX-1,tmpY-2) && checkChess(tmpX-1,tmpY-2,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX-1,tmpY-2));
        }
        if (boundary(tmpX-1,tmpY+2) && checkChess(tmpX-1,tmpY+2,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX-1,tmpY+2));
        }
        if (boundary(tmpX+1,tmpY-2) && checkChess(tmpX+1,tmpY-2,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX+1,tmpY-2));
        }
        if (boundary(tmpX+1,tmpY+2) && checkChess(tmpX+1,tmpY+2,getChessColor())){
            tmp.add(new ChessboardPoint(tmpX + 1,tmpY + 2));
        }

        tmp.sort(Comparator.comparingInt(ChessboardPoint::getY));
        tmp.sort(Comparator.comparingInt(ChessboardPoint::getX));
        return tmp;
    }

}
