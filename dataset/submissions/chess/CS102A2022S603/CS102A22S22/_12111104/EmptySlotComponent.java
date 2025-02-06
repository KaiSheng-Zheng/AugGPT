import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint chessboardPoint;
    private ChessColor chessColor;
    public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        chessboardPoint=source;
        this.name=name;
        this.chessColor=chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        
        return new ArrayList<>();
    }
}