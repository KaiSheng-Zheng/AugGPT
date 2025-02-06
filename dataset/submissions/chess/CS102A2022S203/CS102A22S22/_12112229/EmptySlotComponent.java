import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {


    public EmptySlotComponent(int x,int y) {
        super.setChessColor(ChessColor.NONE);
        name = '_';
        super.setSource(new ChessboardPoint(x,y));
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
