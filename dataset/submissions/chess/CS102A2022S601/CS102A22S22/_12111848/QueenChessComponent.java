import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();

        // Rook
        // xiang shang
        int straightUpX = source.getX() - 1;
        int straightUpY = source.getY();
        for (int i = 0; i < 8; i++) {
            if(straightUpX >= 0) {
                if (chessComponents[straightUpX][straightUpY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()) {
                    break;
                } else if (chessComponents[straightUpX][straightUpY].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(straightUpX, straightUpY));
                } else if (chessComponents[straightUpX][straightUpY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                    canMoveToPoints.add(new ChessboardPoint(straightUpX, straightUpY));
                    break;
                }
            }
            straightUpX --;
        }
        // xiang xia
        int straightDownX = source.getX() + 1;
        int straightDownY = source.getY();
        for (int i = 0; i < 8; i++) {
            if(straightDownX < 8) {
                if (chessComponents[straightDownX][straightDownY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()) {
                    break;
                } else if (chessComponents[straightDownX][straightDownY].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(straightDownX, straightDownY));
                } else if (chessComponents[straightDownX][straightDownY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                    canMoveToPoints.add(new ChessboardPoint(straightDownX, straightDownY));
                    break;
                }
            }
            straightDownX ++;
        }
        // xiang zuo
        int straightLeftX = source.getX();
        int straightLeftY = source.getY() - 1;
        for (int i = 0; i < 8; i++) {
            if(straightLeftY >= 0) {
                if (chessComponents[straightLeftX][straightLeftY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()) {
                    break;
                } else if (chessComponents[straightLeftX][straightLeftY].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(straightLeftX, straightLeftY));
                } else if (chessComponents[straightLeftX][straightLeftY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                    canMoveToPoints.add(new ChessboardPoint(straightLeftX, straightLeftY));
                    break;
                }
            }
            straightLeftY --;
        }
        // xiang you
        int straightRightX = source.getX();
        int straightRightY = source.getY() + 1;
        for (int i = 0; i < 8; i++) {
            if(straightRightY < 8) {
                if (chessComponents[straightRightX][straightRightY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()) {
                    break;
                } else if (chessComponents[straightRightX][straightRightY].getChessColor() == ChessColor.NONE) {
                    canMoveToPoints.add(new ChessboardPoint(straightRightX, straightRightY));
                } else if (chessComponents[straightRightX][straightRightY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
                    canMoveToPoints.add(new ChessboardPoint(straightRightX, straightRightY));
                    break;
                }
            }
            straightRightY ++;
        }

        // Bishop
        // xiang you shang
        int rightUpX = source.getX() - 1;
        int rightUpY = source.getY() + 1;
        for(int i = 0; i < 8; i++){
            if(rightUpX >= 0 && rightUpY < 8){
                if(chessComponents[rightUpX][rightUpY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                    break;
                }else if(chessComponents[rightUpX][rightUpY].getChessColor() == ChessColor.NONE){
                    canMoveToPoints.add(new ChessboardPoint(rightUpX,rightUpY));
                }else if(chessComponents[rightUpX][rightUpY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                    canMoveToPoints.add(new ChessboardPoint(rightUpX,rightUpY));
                    break;
                }
            }
            rightUpX --;
            rightUpY ++;
        }
        // xiang zuo shang
        int leftUpX = source.getX() - 1;
        int leftUpY = source.getY() - 1;
        for(int i = 0; i < 8; i++){
            if(leftUpX >= 0 && leftUpY >= 0){
                if(chessComponents[leftUpX][leftUpY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                    break;
                }else if(chessComponents[leftUpX][leftUpY].getChessColor() == ChessColor.NONE){
                    canMoveToPoints.add(new ChessboardPoint(leftUpX,leftUpY));
                }else if(chessComponents[leftUpX][leftUpY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                    canMoveToPoints.add(new ChessboardPoint(leftUpX,leftUpY));
                    break;
                }
            }
            leftUpX --;
            leftUpY --;
        }
        // xiang you xia
        int rightDownX = source.getX() + 1;
        int rightDownY = source.getY() + 1;
        for(int i = 0; i < 8; i++){
            if(rightDownX < 8 && rightDownY < 8){
                if(chessComponents[rightDownX][rightDownY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                    break;
                }else if(chessComponents[rightDownX][rightDownY].getChessColor() == ChessColor.NONE){
                    canMoveToPoints.add(new ChessboardPoint(rightDownX,rightDownY));
                }else if(chessComponents[rightDownX][rightDownY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                    canMoveToPoints.add(new ChessboardPoint(rightDownX,rightDownY));
                    break;
                }
            }
            rightDownX ++;
            rightDownY ++;
        }
        // xiang zuo xia
        int leftDownX = source.getX() + 1;
        int leftDownY = source.getY() - 1;
        for(int i = 0; i < 8; i++){
            if(leftDownX < 8 && leftDownY >= 0){
                if(chessComponents[leftDownX][leftDownY].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor()){
                    break;
                }else if(chessComponents[leftDownX][leftDownY].getChessColor() == ChessColor.NONE){
                    canMoveToPoints.add(new ChessboardPoint(leftDownX,leftDownY));
                }else if(chessComponents[leftDownX][leftDownY].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()){
                    canMoveToPoints.add(new ChessboardPoint(leftDownX,leftDownY));
                    break;
                }
            }
            leftDownX ++;
            leftDownY --;
        }

        return canMoveToPoints;
    }
}
