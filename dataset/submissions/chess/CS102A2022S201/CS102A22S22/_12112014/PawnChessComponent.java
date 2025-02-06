import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    PawnChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
