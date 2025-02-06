import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    static int date=2;
    static int Bremain=0;
    static int Wremain=0;
    public RookChessComponent(char name, ConcreteChessGame game, ChessboardPoint source) {
        super(name, game, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
