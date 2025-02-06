import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private ChessComponent[][] chessComponents;


    public KingChessComponent(ChessColor chessColor, ChessboardPoint source,ChessComponent[][] chessComponents) {
        setChessColor(chessColor);
        setSource(source);
        this.chessComponents=chessComponents;
        if (chessColor == ChessColor.WHITE) {
            name = 'k';
        } else if (chessColor == ChessColor.BLACK) {
            name = 'K';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint b = new ChessboardPoint(i, j);
                if (!chessComponents[i][j].getChessColor().equals(getChessColor())) {
                    if ((Math.abs(i - getSource().getX()) == 1 && (Math.abs(j - getSource().getY()) == 1))
                            || ((Math.abs(i - getSource().getX()) == 0 && Math.abs(j - getSource().getY()) == 1))
                            || ((Math.abs(i - getSource().getX()) == 1 && Math.abs(j - getSource().getY()) == 0))) {
                        a.add(b);
                    }
                }
            }
        }
        return a;
    }
}
