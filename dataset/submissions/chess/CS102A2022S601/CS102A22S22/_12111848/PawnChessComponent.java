import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // zai chu shi wei zhi ( ke yi zou yi ge huo zhe liang ge)
        // hei zi
        if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK && source.getX() == 1){
            // zhi zou
            if(chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                if(chessComponents[source.getX() + 2][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 2, source.getY()));
                }
            }
            // xie chi zi
            // xiang you xia
            if(source.getY() + 1 < 8) {
                if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                }
            }
            // xiang zuo xia
            if(source.getY() - 1 >= 0) {
                if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                }
            }
        }

        // bai zi
        if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE && source.getX() == 6){
            //zhi zou
            if(chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                if(chessComponents[source.getX() - 2][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 2, source.getY()));
                }
            }
            // xie chi zi
            // xiang zuo shang
            if(source.getY() - 1 >= 0) {
                if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                }
            }
            // xiang you shang
            if(source.getY() + 1 < 8) {
                if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                }
            }
        }

        // bu zai chu shi wei zhi
        // hei zi
        if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK && source.getX() != 1){
            // zhi zou
            if(source.getX() + 1 < 8){
                if(chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                }
            }
            // xie chi zi
            // xiang you xia
            if(source.getX() + 1 < 8 && source.getY() + 1 < 8) {
                if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                }
            }
            // xiang zuo xia
            if(source.getX() + 1 < 8 && source.getY() - 1 >= 0) {
                if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                }
            }
        }
        // bai zi
        if(chessComponents[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE && source.getX() != 6){
            // zhi zou
            if(source.getX() - 1 >= 0){
                if(chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                }
            }
            // xie chi zi
            // xiang you shang
            if(source.getX() - 1 >= 0 && source.getY() + 1 < 8) {
                if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                }
            }
            // xiang zuo shang
            if(source.getX() - 1 >= 0 && source.getY() - 1 >= 0) {
                if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveToPoints.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                }
            }
        }
        return canMoveToPoints;
    }
}
