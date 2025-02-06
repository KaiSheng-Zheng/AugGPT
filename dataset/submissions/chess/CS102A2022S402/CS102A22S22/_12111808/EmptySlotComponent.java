import java.util.List;

public class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

