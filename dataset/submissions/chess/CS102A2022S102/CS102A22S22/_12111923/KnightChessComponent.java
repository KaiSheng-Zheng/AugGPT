import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
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
        public void KnightChessComponent(ChessboardPoint source,ChessColor chessColor) {
            this.chessColor = chessColor;
            this.source = source;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int dx=Math.abs(sourceX-targetX);
        int dy=Math.abs(sourceY-targetY);
        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }
}