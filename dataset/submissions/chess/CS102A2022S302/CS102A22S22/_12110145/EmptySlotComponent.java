import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    int x; int y;
    public EmptySlotComponent(int x, int y, char name) {
        super(x,y,name);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
