import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    //Variables
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //Constructor
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        name = '_';
    }

    public EmptySlotComponent(ChessboardPoint source, char name) {
        super(source, name);
        chessColor = ChessColor.NONE;

    }

    //Methods
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "_";
    }

    //Methods
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
