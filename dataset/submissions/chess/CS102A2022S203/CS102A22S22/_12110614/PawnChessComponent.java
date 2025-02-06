import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private final ChessComponent[][] Chess = getChess();

    public PawnChessComponent(ChessboardPoint chessboardPoint, char c, ChessColor colour) {
        name = c;
        setChessColor(colour);
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BlackPawn = new ArrayList();
        ArrayList<ChessboardPoint> WhitePawn = new ArrayList();
        int x = getSource().getX();
        int y = getSource().getY();

        

        if (name == 'P') {
            return BlackPawn;
        } else if (name == 'p') {
            return WhitePawn;
        } else {
            return new ArrayList<>();
        }
    }
}
