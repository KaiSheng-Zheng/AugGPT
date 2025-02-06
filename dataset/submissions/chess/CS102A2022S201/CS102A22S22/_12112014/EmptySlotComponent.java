import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    EmptySlotComponent( ChessboardPoint source ,ChessColor chessColor){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
