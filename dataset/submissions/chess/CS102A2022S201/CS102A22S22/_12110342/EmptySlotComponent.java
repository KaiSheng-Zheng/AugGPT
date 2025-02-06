import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    private ChessboardPoint source;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    private ChessColor chessColor=ChessColor.NONE;

    ChessComponent[][] chessComponents;

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}