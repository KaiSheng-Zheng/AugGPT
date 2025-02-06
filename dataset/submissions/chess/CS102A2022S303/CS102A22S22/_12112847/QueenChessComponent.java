import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    static int date=1;
    static int Bremain=0;
    static int Wremain=0;

    public QueenChessComponent(char name, ConcreteChessGame game, ChessboardPoint source) {
        super(name, game, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
