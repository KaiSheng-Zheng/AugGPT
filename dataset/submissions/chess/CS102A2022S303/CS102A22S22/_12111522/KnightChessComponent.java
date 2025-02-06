import java.util.List;
import java.util.ArrayList;
public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

      @Override
    public List<ChessboardPoint> canMoveTo() {

        return new ArrayList<>();
    }
}
