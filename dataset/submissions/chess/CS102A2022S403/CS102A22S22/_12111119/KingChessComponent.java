import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint point, ChessColor color, ConcreteChessGame concreteChessGame) {
        super(point, color, concreteChessGame);
        if (getChessColor() == ChessColor.BLACK) name = 'K';
        else name = 'k';
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint point = getChessboardPoint();
        ChessComponent[][] temp = concreteChessGame.getChessComponents();
        int row = point.getX(), col = point.getY();
        if ((--col) >= 0) checkChess(canMovePoints, temp[row][col]);
        if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
        if ((++row) <= 7){
            col--;
            checkChess(canMovePoints, temp[row][col]);
            if ((--col) >= 0) checkChess(canMovePoints, temp[row][col]);
            if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
        }
        if ((row -= 2) >= 0){
            col--;
            checkChess(canMovePoints, temp[row][col]);
            if ((--col) >= 0) checkChess(canMovePoints, temp[row][col]);
            if ((col += 2) <= 7) checkChess(canMovePoints, temp[row][col]);
        }
        return canMovePoints;
    }

    private void checkChess(List<ChessboardPoint> canMovePoints, ChessComponent cc){
        if (!(cc instanceof EmptySlotComponent)){
            if (cc.getChessColor() != this.getChessColor())
                canMovePoints.add(cc.getChessboardPoint());
        }else{
            canMovePoints.add(cc.getChessboardPoint());
        }
    }
}
