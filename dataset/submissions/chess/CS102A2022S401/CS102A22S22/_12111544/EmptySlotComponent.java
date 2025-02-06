import java.util.List;
import java.util.ArrayList;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}