import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        PtList ptList = new PtList(this, chessboard);
        for (ChessboardPoint pt : getSource().getKnightPoints()) {
            ptList.checkPt(pt);
        }
        return ptList.getList();
    }
}
