import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        super(source, color, name, chessComponents);
    }

    List<ChessboardPoint> target=new ArrayList<>();

    public List<ChessboardPoint> canMoveTo() {
        return target;
    }
}
