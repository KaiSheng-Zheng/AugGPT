import java.util.ArrayList;
import java.util.List;

public class PtList {
    private final ArrayList<ChessboardPoint> ptList = new ArrayList<>();
    private final ChessComponent chess;
    private final ChessComponent[][] chessboard;

    public PtList(ChessComponent chess, ChessComponent[][] chessboard) {
        this.chess = chess;
        this.chessboard = chessboard;
    }
    public List<ChessboardPoint> getList() {
        return ptList;
    }

    //false means stop searching
    private boolean checkPtBoolean(ChessboardPoint pt) {
        if (pt == null)
            return false;

        ChessColor color = chessboard[pt.getX()][pt.getY()].getChessColor();
        //no chess
        if (color == ChessColor.NONE) {
            ptList.add(pt);
            return true;
        }
        //different color
        if (color != chess.getChessColor())
            ptList.add(pt);
        return false;
    }

    public boolean checkPtNoChess(ChessboardPoint pt) {
        if (pt == null)
            return false;
        if (chessboard[pt.getX()][pt.getY()] instanceof EmptySlotComponent) {
            ptList.add(pt);
            return true;
        }
        return false;
    }

    public void checkPtEnemy(ChessboardPoint pt) {
        if (pt == null)
            return;
        ChessComponent cc = chessboard[pt.getX()][pt.getY()];
        if (!(cc instanceof EmptySlotComponent) &&
                cc.getChessColor() != chess.getChessColor())
            ptList.add(pt);
    }

    public void checkPt(ChessboardPoint pt) {
        checkPtNoChess(pt);
        checkPtEnemy(pt);
    }

    public void checkCross() {
        ChessboardPoint pos = chess.getSource();
        ChessboardPoint p = pos;
        while (checkPtBoolean(p.offset(1, 0)))
            p = p.offset(1, 0);
        p = pos;
        while (checkPtBoolean(p.offset(0, 1)))
            p = p.offset(0, 1);
        p = pos;
        while (checkPtBoolean(p.offset(-1, 0)))
            p = p.offset(-1, 0);
        p = pos;
        while (checkPtBoolean(p.offset(0, -1)))
            p = p.offset(0, -1);
    }

    public void checkSlash() {
        ChessboardPoint pos = chess.getSource();
        ChessboardPoint p = pos;
        while (checkPtBoolean(p.offset(1, 1)))
            p = p.offset(1, 1);
        p = pos;
        while (checkPtBoolean(p.offset(1, -1)))
            p = p.offset(1, -1);
        p = pos;
        while (checkPtBoolean(p.offset(-1, 1)))
            p = p.offset(-1, 1);
        p = pos;
        while (checkPtBoolean(p.offset(-1, -1)))
            p = p.offset(-1, -1);
    }
}
