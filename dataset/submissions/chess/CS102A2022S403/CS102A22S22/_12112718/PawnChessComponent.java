import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.BLACK){
            name = 'P';
        }else if (color == ChessColor.WHITE){
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        ChessboardPoint newPoint;
        if (chessColor0 == ChessColor.BLACK) {
            if (source0.getX() == 1) {
                newPoint = source0.offset(1, 0);
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                    chessboardPointList.add(newPoint);
                }
                newPoint = source0.offset(2, 0);
                if (chessBoard[newPoint.getX()-1][newPoint.getY()].chessColor0 == ChessColor.NONE &
                        chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                    chessboardPointList.add(newPoint);
                }
                newPoint = source0.offset(1, 1);
                if (newPoint!=null){
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.WHITE) {
                    chessboardPointList.add(newPoint);
                }}
                newPoint = source0.offset(1, -1);
                if (newPoint!=null){
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.WHITE) {
                    chessboardPointList.add(newPoint);
                }}
            }else {
                newPoint = source0.offset(1, 0);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                        chessboardPointList.add(newPoint);
                    }
                }
                newPoint = source0.offset(1, 1);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.WHITE) {
                        chessboardPointList.add(newPoint);
                    }
                }
                newPoint = source0.offset(1, -1);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.WHITE) {
                        chessboardPointList.add(newPoint);
                    }
                }
            }
        }
        if (chessColor0 == ChessColor.WHITE) {
            if (source0.getX() == 6) {
                newPoint = source0.offset(-1, 0);
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                    chessboardPointList.add(newPoint);
                }
                newPoint = source0.offset(-2, 0);
                if (chessBoard[newPoint.getX()+1][newPoint.getY()].chessColor0 == ChessColor.NONE &
                        chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                    chessboardPointList.add(newPoint);
                }
                newPoint = source0.offset(-1, 1);
                if (newPoint!=null){
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.BLACK) {
                    chessboardPointList.add(newPoint);
                }}
                newPoint = source0.offset(-1, -1);
                if (newPoint!=null){
                if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.BLACK) {
                    chessboardPointList.add(newPoint);
                }}
            }else {
                newPoint = source0.offset(-1, 0);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE) {
                        chessboardPointList.add(newPoint);
                    }
                }
                newPoint = source0.offset(-1, 1);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.BLACK) {
                        chessboardPointList.add(newPoint);
                    }
                }
                newPoint = source0.offset(-1, -1);
                if(newPoint != null){
                    if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.BLACK) {
                        chessboardPointList.add(newPoint);
                    }
                }
            }
        }
        return chessboardPointList;
    }
}
