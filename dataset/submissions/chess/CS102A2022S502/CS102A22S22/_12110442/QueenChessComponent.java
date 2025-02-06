import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public QueenChessComponent(char name, int x, int y) {
        super(name, x, y);
    }
}