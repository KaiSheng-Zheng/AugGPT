import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(char name) {super(name);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
