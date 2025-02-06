import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.BLACK){
            name = 'N';
        }else if (color == ChessColor.WHITE){
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        ChessboardPoint newPoint;
        newPoint = source0.offset(-2,-1);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(2,1);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(2,-1);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(-2,1);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(-1,2);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(1,-2);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(1,2);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        newPoint = source0.offset(-1,-2);
        if(newPoint != null){
            if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
            }
        }
        return chessboardPointList;
    }
}
