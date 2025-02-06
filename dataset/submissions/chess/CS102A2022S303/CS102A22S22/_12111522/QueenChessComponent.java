import java.util.List;
import java.util.ArrayList;
public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

      @Override
    public List<ChessboardPoint> canMoveTo() {

        return new ArrayList<>();
    }
}