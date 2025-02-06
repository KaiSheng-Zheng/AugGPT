import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        if (getChessColor() == ChessColor.BLACK) name = 'N';
        else name = 'n';
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    private void checkChess(List<ChessboardPoint> canMovePoints, ChessComponent cc){
        if (!(cc instanceof EmptySlotComponent)){
            if (cc.getChessColor() != this.getChessColor())
                canMovePoints.add(cc.getChessboardPoint());
        }else{
            canMovePoints.add(cc.getChessboardPoint());
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint point = getChessboardPoint();
        ChessComponent[][] temp = concreteChessGame.getChessComponents();
        int row = point.getX(), col = point.getY();
        if ((++row) <= 7){
            if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
            if ((col -= 4) >= 0) checkChess(canMovePoints, temp[row][col]);
            if ((++row) <= 7){
                if ((col += 1) >= 0) checkChess(canMovePoints, temp[row][col]);
                if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
            }
        }
        row = point.getX();
        col = point.getY();
        if ((--row) >= 0){
            if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
            if ((col -= 4) >= 0) checkChess(canMovePoints, temp[row][col]);
            if ((--row) >= 0){
                if ((col += 1) >= 0) checkChess(canMovePoints, temp[row][col]);
                if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
            }
        }
        return canMovePoints;
    }
}
