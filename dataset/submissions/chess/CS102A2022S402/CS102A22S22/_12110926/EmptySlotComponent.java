import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public EmptySlotComponent(char c, ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        super(c, chessComponents, chessboardPoint);
        this.chessComponents=chessComponents;
        this.name=c;
        this.source=chessboardPoint;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}