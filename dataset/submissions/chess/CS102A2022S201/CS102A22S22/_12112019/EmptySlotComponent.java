import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponent) {
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponent;

        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);

    }
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}