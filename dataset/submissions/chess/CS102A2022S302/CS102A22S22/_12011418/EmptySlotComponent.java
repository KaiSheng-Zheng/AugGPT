import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x, int y, ChessColor chessColor, char name) {
        this.setSource(x, y);
        this.setChessColor(chessColor);
        this.setName(name);
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.setChessboard(chessComponents); // construct a chessComponents of 8*8
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
