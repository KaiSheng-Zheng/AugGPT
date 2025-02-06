import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(char name) {super(name);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
