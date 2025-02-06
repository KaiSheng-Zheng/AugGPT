import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    static int date=8;
    static int Bremain=0;
    static int Wremain=0;
    public PawnChessComponent(char name, ConcreteChessGame game, ChessboardPoint source) {
        super(name, game, source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
