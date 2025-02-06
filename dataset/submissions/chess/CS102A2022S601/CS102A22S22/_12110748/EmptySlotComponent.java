import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);this.source=source;this.name=name;this.chessColor=chessColor;this.chessComponents=chessComponents;

    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}