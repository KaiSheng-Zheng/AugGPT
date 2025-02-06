import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        PtList ptList = new PtList(this, chessboard);
        ChessboardPoint source = getSource();
        if (getChessColor() == ChessColor.WHITE) {
            ptList.checkPtEnemy(source.offset(-1, 1));
            ptList.checkPtEnemy(source.offset(-1, -1));
            if (ptList.checkPtNoChess(source.offset(-1, 0)) &&
                    source.getX() == 6)
                ptList.checkPtNoChess(source.offset(-2, 0));
        }
        else if (getChessColor() == ChessColor.BLACK){
            ptList.checkPtEnemy(source.offset(1, 1));
            ptList.checkPtEnemy(source.offset(1, -1));
            if (ptList.checkPtNoChess(source.offset(1, 0)) &&
                    source.getX() == 1)
                ptList.checkPtNoChess(source.offset(2, 0));
        }
        return ptList.getList();
    }
}
