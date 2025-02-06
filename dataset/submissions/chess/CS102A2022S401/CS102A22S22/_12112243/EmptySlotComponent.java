import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint  source ,ChessColor chessColor, char name,ChessComponent[][] chessComponents ){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }
        @Override
        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
}
