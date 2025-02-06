import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }

    public EmptySlotComponent(ChessColor chessColor) {
        if (chessColor == ChessColor.NONE) {
            name = '_';
        }
    }
    @Override
    public String toString(){
        return String.valueOf(name);
    }
}
