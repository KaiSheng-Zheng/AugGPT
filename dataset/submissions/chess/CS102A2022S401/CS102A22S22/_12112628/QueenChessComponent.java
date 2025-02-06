import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        PtList ptList = new PtList(this, chessboard);
        ptList.checkSlash();
        ptList.checkCross();
        return ptList.getList();
    }
}
