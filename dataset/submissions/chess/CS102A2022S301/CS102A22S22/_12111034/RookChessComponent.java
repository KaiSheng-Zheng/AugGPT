import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTOPoint = new ArrayList<ChessboardPoint>();
        ConcreteChessGame rook = new ConcreteChessGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (getSource().getX() == i) {
                    int row = getSource().getX();
                    for (int col = Math.min(getSource().getY(), j) + 1; col < Math.max(getSource().getY(), j); col++) {
                        if (rook.getChess(row, col).getChessColor() !=
                                rook.getChess(getSource().getX(),getSource().getY()).getChessColor()) {
                            canMoveTOPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                } else if (getSource().getY() == j) {
                    int col = getSource().getY();
                    for (int row = Math.min(getSource().getX(), i) + 1;
                         row < Math.max(getSource().getX(), i); row++) {
                        if (rook.getChess(row, col).getChessColor() !=
                                rook.getChess(getSource().getX(),getSource().getY()).getChessColor()) {
                            canMoveTOPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                }

            }
        }
        return canMoveTOPoint;
    }



}
