import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, char name, ChessComponent[][] chessComponents) {
        super(source, name,chessComponents);
    }

    public EmptySlotComponent(ChessboardPoint source){
        super(source, '_', null);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points = new ArrayList<>();
        return points;
    }
}
