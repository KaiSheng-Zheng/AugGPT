import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessComponent[][] chessboard, ChessColor color, ChessboardPoint point) {
        super.chessboard = chessboard;
        super.setChessColor(color);
        super.setChessPoint(point);
        if (color.equals(ChessColor.BLACK)) {
            super.name = 'Q';
        } else {
            super.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
        ChessboardPoint source = super.getChessPoint();
        boolean check = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!chessboard[i][j].getChessColor().equals(getChessColor())) {

                    if (source.getX() - source.getY() == i - j) {
                        if (source.getX() < i) {
                            for (int col = source.getY() + 1, row = source.getX() + 1; col < j; col++, row++) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (source.getX() > i) {
                            for (int col = source.getY() - 1, row = source.getX() - 1; col > j; col--, row--) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (check && chessboard[i][j].getChessColor() != getChessColor()) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    } else if (source.getX() + source.getY() == i + j) {
                        if (source.getX() > i) {
                            for (int col = source.getY() + 1, row = source.getX() - 1; col < j; col++, row--) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (source.getX() < i) {
                            for (int col = source.getY() - 1, row = source.getX() + 1; col > j; col--, row++) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (check && chessboard[i][j].getChessColor() != getChessColor()) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    } else if (source.getX() == i) {
                        int row = source.getX();
                        if (source.getY() < j) {
                            for (int col = source.getY() + 1; col < j; col++) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (source.getY() > j) {
                            for (int col = source.getY() - 1; col > j; col--) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (check && chessboard[i][j].getChessColor() != getChessColor()) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    } else if (source.getY() == j) {
                        int col = source.getY();
                        if (source.getX() < i) {
                            for (int row = source.getX() + 1; row < i; row++) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (source.getX() > i) {
                            for (int row = source.getX() - 1; row > i; row--) {
                                if (!(chessboard[row][col] instanceof EmptySlotComponent)) {
                                    check = false;
                                    break;
                                }
                            }
                        }
                        if (check && chessboard[i][j].getChessColor() != getChessColor()) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    }
                    check = true;
                }
            }
        }
        return list;
    }

}
