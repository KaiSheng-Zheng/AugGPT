import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}

