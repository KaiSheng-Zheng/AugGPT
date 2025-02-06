import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    ChessColor chessColor;

    public EmptySlotComponent(ChessColor none, ChessboardPoint chessboardPoint) {
       this.chessColor=ChessColor.NONE;
       setSource ( chessboardPoint );
       this.name='_';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf ( this.name );
    }
}
