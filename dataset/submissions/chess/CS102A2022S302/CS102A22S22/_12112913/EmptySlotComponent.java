import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name) {
        this.name = name;
        setSource(chessboardPoint);
        setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<ChessboardPoint>();
    }
}
