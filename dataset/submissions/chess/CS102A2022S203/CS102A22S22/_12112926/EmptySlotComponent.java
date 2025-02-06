import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessColor chessColor, char name,ChessboardPoint source) {
            this.name = name;
        setChessColor(chessColor);
        setSource(source);
        }
        @Override
        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
}

