import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
