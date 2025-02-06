import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
//    protected char name;

//    public EmptySlotComponent(ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
//    public EmptySlotComponent(ChessColor chessColor, char name) {
//        this.chessColor = chessColor;
//        this.name = name;
//    }

    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(ChessColor.NONE);
        this.setName('_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
