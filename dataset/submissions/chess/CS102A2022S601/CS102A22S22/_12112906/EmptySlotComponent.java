import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        super(chessColor,chessComponents);
        this.name='_';
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
