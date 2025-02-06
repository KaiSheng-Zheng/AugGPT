import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    ChessComponent[][]chessComponents;
    ChessColor chessColor;
    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, ChessComponent[][] chessComponents) {
               //super(chessColor);
            name='_';
       

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
