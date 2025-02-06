
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, ChessComponent[][] chessComponents,ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


}
