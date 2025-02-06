import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame) {
        super(source, name, chessGame);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
