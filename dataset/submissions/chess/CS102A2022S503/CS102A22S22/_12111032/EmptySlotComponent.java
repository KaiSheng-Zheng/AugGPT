import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public  EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name){
        setSource(source);
        setChessColor(chessColor);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}