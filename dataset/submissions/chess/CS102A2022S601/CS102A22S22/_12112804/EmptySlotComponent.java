import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public List<ChessboardPoint> canMoveTo()
    {
        return null;
    }
    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        super.name='_';
    }

}
