import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ConcreteChessGame board,ChessColor chessColor,ChessboardPoint source) {
//        this.name = '_';
//        setChessColor(ChessColor.NONE);
//        this.board = board;
//        this.setSource(source);
        super(source,chessColor,'_',board);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }

}
