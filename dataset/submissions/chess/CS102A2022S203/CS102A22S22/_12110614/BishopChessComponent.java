import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public BishopChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackBishop = new ArrayList();
        ArrayList<ChessboardPoint> WhiteBishop = new ArrayList();


        if (name == 'B') {
            return BlackBishop;
        } else if (name == 'b') {
            return WhiteBishop;
        } else {
            return new ArrayList<>();
        }
    }
}
