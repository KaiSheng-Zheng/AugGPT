import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> points = new ArrayList<>();

        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] board = chessGame.getChessComponents();


        boolean inPlace = false;
        if (board[x][y].getChessColor().equals(ChessColor.BLACK)) {
            if (x == 1)
                inPlace = true;

            ChessboardPoint point = new ChessboardPoint(x + 1, y);
            if (ChessboardPoint.inChessBoard(point) && isEmptyChess(point))
                points.add(point);

            point = new ChessboardPoint(x + 1, y + 1);
            if (ChessboardPoint.inChessBoard(point) && isOpposite(getSource(), point))
                points.add(point);

            point = new ChessboardPoint(x + 1, y - 1);
            if (ChessboardPoint.inChessBoard(point) && isOpposite(getSource(), point))
                points.add(point);

            if (inPlace) {

                ChessboardPoint p1 = new ChessboardPoint(x + 1, y);
                ChessboardPoint p2 = new ChessboardPoint(x + 2, y);
                if (ChessboardPoint.inChessBoard(p1) && ChessboardPoint.inChessBoard(p2) &&
                        isEmptyChess(p1) && isEmptyChess(p2)) {
                    points.add(p2);
                }
            }
            return points;
        } else {
            if (x == 6)
                inPlace = true;


            ChessboardPoint point = new ChessboardPoint(x - 1, y);
            if (ChessboardPoint.inChessBoard(point) && isEmptyChess(point))
                points.add(point);

            point = new ChessboardPoint(x - 1, y + 1);
            if (ChessboardPoint.inChessBoard(point) && isOpposite(getSource(), point))
                points.add(point);

            point = new ChessboardPoint(x - 1, y - 1);
            if (ChessboardPoint.inChessBoard(point) && isOpposite(getSource(), point))
                points.add(point);

            if (inPlace) {
                ChessboardPoint p1 = new ChessboardPoint(x - 1, y);
                ChessboardPoint p2 = new ChessboardPoint(x - 2, y);
                if (ChessboardPoint.inChessBoard(p1) && ChessboardPoint.inChessBoard(p2) &&
                        isEmptyChess(p1) && isEmptyChess(p2)) {
                    points.add(p2);
                }
            }
            return points;


        }


    }
}
