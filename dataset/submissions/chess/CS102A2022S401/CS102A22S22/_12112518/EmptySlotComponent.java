import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(){};

    public EmptySlotComponent(char name, ChessboardPoint where, ChessColor chessColor){
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
