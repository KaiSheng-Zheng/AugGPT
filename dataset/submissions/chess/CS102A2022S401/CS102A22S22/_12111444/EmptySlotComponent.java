import java.util.List;
import java.util.ArrayList;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor){
        setChessColor(chessColor);
        setName();
    }
    @Override
    public void setName() {
        name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}