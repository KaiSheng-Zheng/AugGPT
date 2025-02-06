import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name,List<String> ChessList) {
        super(source,chessColor,name,ChessList);
    }
}