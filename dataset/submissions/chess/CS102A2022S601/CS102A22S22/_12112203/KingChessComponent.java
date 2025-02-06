import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> targetPoint = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(i - getSource().getX()) <= 1 && Math.abs(j - getSource().getY()) <= 1) && this.chessComponents[i][j].getChessColor() != getChessColor()) {
                    targetPoint.add(new ChessboardPoint(i, j));
                }
            }
        }
        return targetPoint;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.setSource(source);
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'k';
        } else {
            this.name = 'K';
        }
    }
}
