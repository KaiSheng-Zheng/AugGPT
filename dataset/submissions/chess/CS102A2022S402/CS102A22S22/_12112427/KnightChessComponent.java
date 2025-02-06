import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source,ChessComponent[][] chessComponents) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            name = 'n';
        } else if (chessColor == ChessColor.BLACK) {
            name = 'N';
        }
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint b = new ChessboardPoint(i, j);
                if (!chessComponents[i][j].getChessColor().equals(getChessColor())) {
                    if ((Math.abs(i - getSource().getX()) == 1 && (Math.abs(j - getSource().getY()) == 2))
                            || ((Math.abs(i - getSource().getX()) == 2 && Math.abs(j - getSource().getY()) == 1))) {
                        a.add(b);
                    }
                }
            }
        }
        return a;
    }
}

