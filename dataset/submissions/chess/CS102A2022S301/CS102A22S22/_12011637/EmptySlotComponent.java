import java.util.List;

/**
 * @author KaiXin on 2022-05-12
 * @version 1.8
 * @since1.5
 */
public class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        super(chessColor, chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
