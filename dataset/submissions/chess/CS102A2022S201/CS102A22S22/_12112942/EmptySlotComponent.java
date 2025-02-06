import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public ChessColor chessColor=ChessColor.NONE;
    public ChessboardPoint source;
    public EmptySlotComponent(ChessboardPoint source){
        this.source=source;
        name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

}
