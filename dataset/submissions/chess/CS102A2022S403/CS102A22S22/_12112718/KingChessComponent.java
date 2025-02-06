import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.BLACK){
            name = 'K';
        }else if (color == ChessColor.WHITE){
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int l =1;
            ChessboardPoint newPoint;
            newPoint = source0.offset(-l,-l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(l,l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(l,-l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(-l,l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(-l,0);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(0,-l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(l,0);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(0,l);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE &
                    chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        return chessboardPointList;
    }
}
