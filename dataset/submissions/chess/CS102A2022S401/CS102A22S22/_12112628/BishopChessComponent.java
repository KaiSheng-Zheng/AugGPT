import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        PtList ptList = new PtList(this, chessboard);
        ptList.checkSlash();
        return ptList.getList();
    }
}
