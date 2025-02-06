import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor chessColor){
        super(chessboardPoint,chessColor);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
