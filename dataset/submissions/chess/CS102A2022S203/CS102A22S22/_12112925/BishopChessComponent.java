import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor,char name)
    {
        super(source, chessColor, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(ChessComponent[][] chessComponents)
    {
        return new ArrayList<>();
    }
}
