import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
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
