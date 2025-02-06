import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    protected char name;
    private ChessboardPoint source;
    private ChessComponent[][] chess;

    public EmptySlotComponent(ChessboardPoint source, char name, ChessComponent[][] chess) {
        this.source = source;
        this.name = name;
        this.chess = chess;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public void moveTo(ChessboardPoint target) {
    }

    public ChessColor getSide() {
        return ChessColor.NONE;
    }

}
