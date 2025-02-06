import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){

        super(source,ChessColor.NONE);
      this.name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
