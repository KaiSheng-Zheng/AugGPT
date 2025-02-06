import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessColor color;
    private ChessComponent[][] chessComponents;
    public EmptySlotComponent(ChessComponent[][] chessComponents){
        this.name='_';
        this.color=ChessColor.NONE;
        this.chessComponents=chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
