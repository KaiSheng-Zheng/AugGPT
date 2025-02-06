import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(char name) {super(name);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
