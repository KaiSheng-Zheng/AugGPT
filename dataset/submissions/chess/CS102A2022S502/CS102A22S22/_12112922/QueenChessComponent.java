import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,ChessComponent[][] chessComponents){
//        super(source,chessColor);
        super.setChessColor(chessColor);
        super.setSource(source);
        this.chessComponents = chessComponents;
        if(chessColor == ChessColor.BLACK){
            super.name = 'Q';
        }else{
            super.name = 'q';
        }
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(i, i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(-i, -i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(-i, i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(i, -i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(0, i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(0, -i);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(i, 0);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint newPoint = super.getSource().offset(-i, 0);
            if (newPoint == null) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()==super.getChessColor()) {
                break;
            }
            if(chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=super.getChessColor()&&chessComponents[newPoint.getX()][newPoint.getY()].getChessColor()!=ChessColor.NONE) {
                canMoveTo.add(newPoint);
                break;
            }
            canMoveTo.add(newPoint);
        }
        return canMoveTo;
    }
    public void updateBoard(ChessComponent[][] newBoard){
        this.chessComponents = newBoard;
    }
}
