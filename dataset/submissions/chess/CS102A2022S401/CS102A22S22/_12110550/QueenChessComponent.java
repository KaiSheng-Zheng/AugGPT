import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        move.addAll(BioCanMoveTo(getChess(getSource().getX(),getSource().getY())));
        move.addAll(RookCanMoveTo(getChess(getSource().getX(),getSource().getY())));

        return move;
    }
}
