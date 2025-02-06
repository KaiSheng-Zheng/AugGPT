import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    boolean twoBlock = true;

    public PawnChessComponent(ChessComponent[][] chessboard, ChessColor color, ChessboardPoint point) {
        super.chessboard = chessboard;
        super.setChessColor(color);
        super.setChessPoint(point);
        if (color.equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else {
            super.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        ChessboardPoint source = super.getChessPoint();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!chessboard[i][j].getChessColor().equals(getChessColor())) {

                    if (source.getY() == j) {
                        if ((i - source.getX() == 1 && getChessColor() == ChessColor.BLACK ||
                                source.getX() - i == 1 && getChessColor() == ChessColor.WHITE) &&
                                chessboard[i][j] instanceof EmptySlotComponent) {
                            list.add(new ChessboardPoint(i, j));

                        } else if (twoBlock && i - source.getX() == 2 && getChessColor() == ChessColor.BLACK &&
                                chessboard[i - 1][j] instanceof EmptySlotComponent &&
                                chessboard[i][j] instanceof EmptySlotComponent) {
                            list.add(new ChessboardPoint(i, j));

                        } else if (twoBlock && i - source.getX() == -2 && getChessColor() == ChessColor.WHITE &&
                                chessboard[i + 1][j] instanceof EmptySlotComponent &&
                                chessboard[i][j] instanceof EmptySlotComponent) {
                            list.add(new ChessboardPoint(i, j));

                        } else {
                            continue;
                        }
                    } else if (Math.abs(source.getY() - j) == 1 &&
                            ((i - source.getX() == 1 && getChessColor() == ChessColor.BLACK) ||
                                    (source.getX() - i == 1 && getChessColor() == ChessColor.WHITE))) {
                        if (chessboard[i][j] instanceof EmptySlotComponent) {
                        } else {
                            list.add(new ChessboardPoint(i, j));

                        }
                    }
                }
            }
        }
        return list;
    }

    public void setTwoBlock() {
        twoBlock = false;
    }

}
