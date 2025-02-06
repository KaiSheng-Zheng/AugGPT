import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    private ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        setChessboardPoint(chessboardPoint);
        setChessColor(chessColor);
        setName(name);
        this.chessComponents = chessComponents;
    }

    List<ChessboardPoint> lChessboardPoints = new ArrayList<>();


    @Override
    public List<ChessboardPoint> canMoveTo() {
        lChessboardPoints.clear();
        ChessboardPoint source = getChessboardPoint();
        ChessColor chessColor = getChessColor();
        int row = source.getX();
        int col = source.getY();
        for (int i = 1; i + row < 8; i++) {
            if (source.offset(i, 0) != null) {
                if (chessComponents[row + i][col] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, 0));
                } else {
                    if (chessComponents[row + i][col].getChessColor() != chessColor) {
                        lChessboardPoints.add(source.offset(i, 0));
                    }
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = -1; row + i >= 0; i--) {
            if (source.offset(i, 0) != null) {
                if (chessComponents[row + i][col] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, 0));
                } else {
                    if (chessComponents[row + i][col].getChessColor() != chessColor) {
                        lChessboardPoints.add(source.offset(i, 0));
                    }
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = 1; col + i < 8; i++) {
            if (source.offset(0, i) != null) {
                if (chessComponents[row][col + i] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(0, i));
                } else {
                    if (chessComponents[row][col + i].getChessColor() != chessColor) {
                        lChessboardPoints.add(source.offset(0, i));
                    }
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = -1; col + i >= 0; i--) {
            if (source.offset(0, i) != null) {
                if (chessComponents[row][col + i] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(0, i));
                } else {
                    if (chessComponents[row][col + i].getChessColor() != chessColor) {
                        lChessboardPoints.add(source.offset(0, i));
                    }
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = 1, j = 1; row + i < 8 && col + j < 8; i++, j++) {
            if (source.offset(i, j) != null) {
                if (chessComponents[row + i][col + j] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, j));
                } else {
                    if (chessComponents[row + i][col + j].getChessColor() == getChessColor())
                        break;
                    if (chessComponents[row + i][col + j].getChessColor() != getChessColor()) {
                        lChessboardPoints.add(source.offset(i, j));
                        break;
                    }
                }
            }
        }
        for (int i = -1, j = 1; row + i >= 0 && col + j < 8; i--, j++) {
            if (source.offset(i, j) != null) {
                if (chessComponents[row + i][col + j] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, j));
                } else {
                    if (chessComponents[row + i][col + j].getChessColor() == getChessColor())
                        break;
                    if (chessComponents[row + i][col + j].getChessColor() != getChessColor()) {
                        lChessboardPoints.add(source.offset(i, j));
                        break;
                    }
                }
            }
        }

        for (int i = -1, j = -1; row + i >= 0 && col + j >= 0; i--, j--) {
            if (source.offset(i, j) != null) {
                if (chessComponents[row + i][col + j] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, j));
                } else {
                    if (chessComponents[row + i][col + j].getChessColor() == getChessColor())
                        break;
                    if (chessComponents[row + i][col + j].getChessColor() != getChessColor()) {
                        lChessboardPoints.add(source.offset(i, j));
                        break;
                    }
                }
            }
        }

        for (int i = 1, j = -1; row + i < 8 && col + j >= 0; i++, j--) {
            if (source.offset(i, j) != null) {
                if (chessComponents[row + i][col + j] instanceof EmptySlotComponent) {
                    lChessboardPoints.add(source.offset(i, j));
                } else {
                    if (chessComponents[row + i][col + j].getChessColor() == getChessColor())
                        break;
                    if (chessComponents[row + i][col + j].getChessColor() != getChessColor()) {
                        lChessboardPoints.add(source.offset(i, j));
                        break;
                    }
                }
            }
        }
        lChessboardPoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return lChessboardPoints;
    }

}
