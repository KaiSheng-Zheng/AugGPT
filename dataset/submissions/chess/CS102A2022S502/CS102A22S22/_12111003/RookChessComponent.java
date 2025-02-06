import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name) {super(name);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
