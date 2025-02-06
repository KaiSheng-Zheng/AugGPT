import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, ChessColor.NONE);
        this.name='_';
    }

    public EmptySlotComponent() {
        super(null,ChessColor.NONE);
        this.name='_';
    }

    public EmptySlotComponent(ChessboardPoint source){
        super(source,ChessColor.NONE);
        this.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> legalpoints = new ArrayList<>();
        return legalpoints;
    }
}
