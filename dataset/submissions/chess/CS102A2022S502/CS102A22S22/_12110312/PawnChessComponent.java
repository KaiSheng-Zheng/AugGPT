import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint point, ChessColor color) {
        super(point, color);
        if (color == ChessColor.BLACK) {
            this.name = 'P';
        } else {
            this.name = 'p';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = this.getPoint();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (chessBoard[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
            }
            if (chessBoard[source.getX()+1][source.getY()] instanceof EmptySlotComponent) {
                canMoveTo.add(new ChessboardPoint(source.getX()+1, source.getY()));
            }
            if (chessBoard[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                canMoveTo.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
            }
            if (source.getX() == 1) {
                if (chessBoard[2][source.getY()] instanceof EmptySlotComponent && chessBoard[3][source.getY()] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(3, source.getY()));
                }
            }
        }

        if (this.getChessColor() == ChessColor.WHITE) {
            if (source.getY() == 6) {
                if (chessBoard[5][source.getY()] instanceof EmptySlotComponent && chessBoard[4][source.getY()] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(4, source.getY()));
                }
            }
            if (chessBoard[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
            }
            if (chessBoard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {
                canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY()));
            }
            if (chessBoard[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                canMoveTo.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
            }
        }
        return canMoveTo;
    };
}
