import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    ChessboardPoint source;  //Where the chess is
    ChessColor chessColor;  // What's the color


    public EmptySlotComponent(int x, int y, char ming) {

        source = new ChessboardPoint(x, y);
        chessColor = ChessColor.NONE;
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
