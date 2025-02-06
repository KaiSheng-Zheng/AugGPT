import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected static char name;
    private ChessComponent[][] chessComponents;

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor chessColor = super.getChessColor();
        for (int i = 0; i < 8; i++) {
            if (!super.getSource().canMoveTo(i, i)) break;
            ChessboardPoint chessboardPoint1 = super.getSource().offset(i, i);
            if (super.chessboard[chessboardPoint1.getX()][chessboardPoint1.getY()].getChessColor().equals(chessColor))
                break;
            if (!super.chessboard[chessboardPoint1.getX()][chessboardPoint1.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMoveTo.add(chessboardPoint1);
                break;
            }
            canMoveTo.add(chessboardPoint1);
        }
        super.ComparecanMoveTo(canMoveTo);
        return canMoveTo;
    }

    public void RookChessComponent(ChessboardPoint source,ChessColor chessColor) {
        this.chessColor = chessColor;
        this.source = source;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (source.getX() == targetX) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), targetY) + 1;
                 col < Math.max(source.getY(), targetY); col++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == targetY) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), targetX) + 1;
                 row < Math.max(source.getX(), targetX); row++) {
                if (!(chessComponents[row][col] instanceof EmptyChessComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}