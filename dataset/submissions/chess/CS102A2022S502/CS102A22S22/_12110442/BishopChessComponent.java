import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public BishopChessComponent(char name, int x, int y) {
        super(name, x, y);
        this.name = name;
    }
}
