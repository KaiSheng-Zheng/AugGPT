import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name,ChessboardPoint source,ChessColor chessColor) {
        setName(name);
        setChessColor(chessColor);
        setSource(source);

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        return chessboardPointList;
    }
}