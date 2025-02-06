import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public void setChessColor(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
