import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
        setSource(source);
        setChessColor(chessColor);
        setName((char) 95);
    }
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}