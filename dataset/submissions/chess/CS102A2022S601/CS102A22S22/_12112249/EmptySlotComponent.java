import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        name = '_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
