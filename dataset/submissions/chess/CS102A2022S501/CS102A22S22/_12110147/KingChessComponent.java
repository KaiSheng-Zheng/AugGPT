import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'k';
        }
        return 'K';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean bx = false;
                boolean by = false;
                if (i - getSource().getX() >= -1 && i - getSource().getX() <= 1) {
                    bx = true;
                }
                if (j - getSource().getY() >= -1 && j - getSource().getY() <= 1) {
                    by = true;
                }
                if (bx && by && !(i == getSource().getX() && j == getSource().getY()) && chessComponents[i][j].getChessColor() != getChessColor()) {
                    a.add(new ChessboardPoint(i,j));
                }
            }
        }
        return a;
    }
}