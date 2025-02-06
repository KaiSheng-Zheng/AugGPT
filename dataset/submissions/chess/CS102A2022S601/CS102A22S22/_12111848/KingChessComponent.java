import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        //heng zou
        //xiang zuo
        if(chessComponents[source.getX()][source.getY() - 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()
                && source.getY() - 1 >= 0 ){
            canMoveToPoints.add(new ChessboardPoint(source.getX(),source.getY() - 1));
        }
        //xiang you
        if(chessComponents[source.getX()][source.getY() + 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()
                 && source.getY() + 1 < 8){
            canMoveToPoints.add(new ChessboardPoint(source.getX(),source.getY() + 1));
        }

        //zong zou
        //xiang xia
        if(source.getX() + 1 < 8) {
            if (chessComponents[source.getX() + 1][source.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY()));
            }
        }
        //xiang shang
        if(source.getX() - 1 >= 0) {
            if (chessComponents[source.getX() - 1][source.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY()));
            }
        }

        //xie zou
        //xiang you shang
        if(source.getX() - 1 >= 0 && source.getY() + 1 < 8) {
            if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
            }
        }
        //xiang zuo shang
        if(source.getX() - 1 >= 0 && source.getY() - 1 >= 0) {
            if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
            }
        }
        //xiang zuo xia
        if(source.getX() + 1 < 8 && source.getY() - 1 >= 0) {
            if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
            }
        }
        //xiang you xia
        if(source.getX() + 1 < 8 && source.getY() + 1 < 8) {
            if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
            }
        }
        return canMoveToPoints;
    }
}
