import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessColor currentPlayer;

    public EmptySlotComponent(int x, int y) {
        this.x=x;
        this.y=y;
        getSource().setX(x);
        getSource().setY(y);
        this.currentPlayer=ChessColor.NONE;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
