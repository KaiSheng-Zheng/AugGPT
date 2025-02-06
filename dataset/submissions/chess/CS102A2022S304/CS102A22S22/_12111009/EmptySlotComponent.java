import java.util.ArrayList;
import java.util.List;


public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint chessboardPoint) {
        this.setSource(chessboardPoint);
        this.setChessColor(ChessColor.NONE);
        this.setName('_') ;
        chessboard[chessboardPoint.getX()][chessboardPoint.getY()]=this;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}