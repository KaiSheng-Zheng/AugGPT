import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
@Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = source;
        this.chessColor = chessColor;

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
