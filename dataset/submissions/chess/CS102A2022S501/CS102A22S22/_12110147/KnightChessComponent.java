import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent() {
        super();
    }

    @Override
    public char getName() {
        if (getChessColor() == ChessColor.WHITE) {
            return 'n';
        }
        return 'N';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() != getChessColor()) {
                    if (((i - getSource().getX() == 2 || i - getSource().getX() == -2) && (j - getSource().getY() == 1 || j - getSource().getY() == -1)) || ((i - getSource().getX() == 1 || i - getSource().getX() == -1) && (j - getSource().getY() == 2 || j - getSource().getY() == -2))) {
                        a.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return a;
    }
}