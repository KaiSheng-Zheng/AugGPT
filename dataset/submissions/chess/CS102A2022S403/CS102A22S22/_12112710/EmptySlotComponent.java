import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {


    public EmptySlotComponent(ChessColor color, char name){
        setChessColor(color);
        setName(name);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>(0);
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
