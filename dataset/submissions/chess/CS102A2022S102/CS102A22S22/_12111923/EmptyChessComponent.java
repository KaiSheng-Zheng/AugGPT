import java.util.ArrayList;
import java.util.List;

public class EmptyChessComponent extends ChessComponent {
    private ChessboardPoint source;
    protected char name;
    private ChessComponent[][] chessComponents;

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
        public void EmptyChessComponent(ChessboardPoint source) {
            this.source = source;
    }

}