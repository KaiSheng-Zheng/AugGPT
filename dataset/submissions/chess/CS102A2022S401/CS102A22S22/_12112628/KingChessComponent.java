import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        PtList ptList = new PtList(this, chessboard);
        for (ChessboardPoint pt : getSource().getAround()) {
            ptList.checkPt(pt);
        }
        return ptList.getList();
    }
}
