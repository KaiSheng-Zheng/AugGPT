import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent  {

    public EmptySlotComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        source = new ChessboardPoint(x, y);
        super.name = name;
        chessColor = ChessColor.NONE;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
