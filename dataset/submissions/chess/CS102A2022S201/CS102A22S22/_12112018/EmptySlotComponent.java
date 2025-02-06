import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    EmptySlotComponent( ChessboardPoint source ,ChessColor chessColor ){
       super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
