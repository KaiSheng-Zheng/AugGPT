import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // xiang you shang shang
        if(source.getX() - 2 >= 0 && source.getY() + 1 < 8){
            if(chessComponents[source.getX() - 2][source.getY() + 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 2,source.getY() + 1));
            }
        }
        // xiang zuo shang shang
        if(source.getX() - 2 >= 0 && source.getY() - 1 >= 0){
            if(chessComponents[source.getX() - 2][source.getY() - 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 2,source.getY() - 1));
            }
        }
        // xiang you you shang
        if(source.getX() - 1 >= 0 && source.getY() + 2 < 8){
            if(chessComponents[source.getX() - 1][source.getY() + 2].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1,source.getY() + 2));
            }
        }
        // xiang zuo zuo shang
        if(source.getX() - 1 >= 0 && source.getY() - 2 >= 0){
            if(chessComponents[source.getX() - 1][source.getY() - 2].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1,source.getY() - 2));
            }
        }
        // xiang you xia xia
        if(source.getX() + 2 < 8 && source.getY() + 1 < 8){
            if(chessComponents[source.getX() + 2][source.getY() + 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 2,source.getY() + 1));
            }
        }
        // xiang zuo xia xia
        if(source.getX() + 2 < 8 && source.getY() - 1 >= 0){
            if(chessComponents[source.getX() + 2][source.getY() - 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 2,source.getY() - 1));
            }
        }
        // xiang you you xia
        if(source.getX() + 1 < 8 && source.getY() + 2 < 8){
            if(chessComponents[source.getX() + 1][source.getY() + 2].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1,source.getY() + 2));
            }
        }
        // xiang zuo zuo xia
        if(source.getX() + 1 < 8 && source.getY() - 2 >= 0){
            if(chessComponents[source.getX() + 1][source.getY() - 2].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1,source.getY() - 2));
            }
        }
        return canMoveToPoints;
    }
}

