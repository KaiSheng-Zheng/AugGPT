import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    private ChessComponent[][] chessComponents;

    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
//        super();
        setChessboardPoint(chessboardPoint);
        setChessColor(chessColor);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
