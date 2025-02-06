import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = super.getChessBoard();
        return new ArrayList<>();
    }
    public EmptySlotComponent(int x,int y){
        super(x, y);
    }

    public EmptySlotComponent(){}
}
