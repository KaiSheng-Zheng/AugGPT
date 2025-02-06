import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name){super(name);}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
