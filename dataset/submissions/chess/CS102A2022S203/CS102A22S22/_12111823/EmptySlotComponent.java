import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(char name, int x, int y) {
        this.name = name;
        this.setSource(x, y);
        this.setChessColor(ChessColor.NONE);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
