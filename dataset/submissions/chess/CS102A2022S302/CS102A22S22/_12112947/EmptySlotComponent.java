import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessComponent[][] chessComponents; 
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,ChessColor.NONE);
        this.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
