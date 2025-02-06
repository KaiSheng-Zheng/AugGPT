import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public void setName(){
        super.name = '_';
    }
}
