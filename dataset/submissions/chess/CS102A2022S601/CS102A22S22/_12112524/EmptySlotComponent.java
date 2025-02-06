import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    @Override
    public String toString() {
        return super.toString();
    }

    public EmptySlotComponent(char name, int x, int y) {
        super(name, x, y);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}