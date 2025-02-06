import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {


    // Constructors
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


}