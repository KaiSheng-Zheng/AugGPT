import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public ChessboardPoint source;
    private final ChessColor chessColor;

    public EmptySlotComponent(ChessboardPoint source){
        super();
        this.source=source;
        chessColor=ChessColor.NONE;
        name='_';
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return this.source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}