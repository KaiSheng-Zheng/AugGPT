import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessColor color;
    private char name;
    private ChessboardPoint point;

    public EmptySlotComponent(ChessboardPoint point, ChessColor color, char name) {
        this.color = color;
        this.point = point;
        this.name = name;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();

        return canmove;
    }
    public ChessColor getChessColor() {
        return color;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
