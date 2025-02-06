import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public KingChessComponent(char name, int x, int y) {
        super(name, x, y);
    }
}