import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {


    // Constructor
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


}
