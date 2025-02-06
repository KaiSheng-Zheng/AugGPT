import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    private final ChessComponent[][] Chess = getChess();


    public KingChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackKing = new ArrayList();
        ArrayList<ChessboardPoint> WhiteKing = new ArrayList();

        int x = getSource().getX();
        int y = getSource().getY();
        
        if (name == 'K') {
            return BlackKing;
        } else if (name == 'k') {
            return WhiteKing;
        } else {
            return new ArrayList<>();
        }
    }
}
