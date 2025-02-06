import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent
{
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private  ChessColor chessColor = ChessColor.NONE;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public EmptySlotComponent(ChessComponent[][] chessComponents, int x, int y)
    {
        source.setY(y);
        source.setX(x);
        super.name = '_';
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
