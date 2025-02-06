import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.BLACK){
            name = 'R';
        }else if (color == ChessColor.WHITE){
            name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        for (int l =1;l<8;l++){
            ChessboardPoint newPoint = source0.offset(-l,0);
            if(newPoint == null){
                break;
            }else if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE){
                chessboardPointList.add(newPoint);
            }else if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
                break;
            }else break;
        }
        for (int l =1;l<8;l++){
            ChessboardPoint newPoint = source0.offset(l,0);
            if(newPoint == null){
                break;
            }else if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE){
                chessboardPointList.add(newPoint);
            }else if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
                break;
            }else break;
        }
        for (int l =1;l<8;l++){
            ChessboardPoint newPoint = source0.offset(0,-l);
            if(newPoint == null){
                break;
            }else if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE){
                chessboardPointList.add(newPoint);
            }else if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
                break;
            }else break;
        }
        for (int l =1;l<8;l++){
            ChessboardPoint newPoint = source0.offset(0,l);
            if(newPoint == null){
                break;
            }else if(chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 == ChessColor.NONE){
                chessboardPointList.add(newPoint);
            }else if (chessBoard[newPoint.getX()][newPoint.getY()].chessColor0 != chessColor0){
                chessboardPointList.add(newPoint);
                break;
            }else break;
        }
        return chessboardPointList;
    }
}
