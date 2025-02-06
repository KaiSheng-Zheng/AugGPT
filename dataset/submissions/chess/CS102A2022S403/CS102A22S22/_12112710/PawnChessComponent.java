import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessColor color, char name) {
        setChessColor(color);
        setName(name);
    }

    private ChessColor checkBoardPosition(int x, int y) {
        ChessComponent chess = game.getChess(x, y);
        if (chess.getChessColor() == ChessColor.NONE) {
            return ChessColor.NONE;
        }
        return chess.getChessColor();
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() == 6) {
                if (checkBoardPosition(getSource().getX() - 1, getSource().getY()) == ChessColor.NONE) {
                    result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                    if (checkBoardPosition(getSource().getX() - 2, getSource().getY()) == ChessColor.NONE) {
                        result.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY()));
                    }
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                } else {
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }
            } else {
                if (checkBoardPosition(getSource().getX() - 1, getSource().getY()) == ChessColor.NONE) {
                    result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                } else {
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() + 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() - 1, getSource().getY() - 1) == ChessColor.BLACK) {
                        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }
            }
        } else if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() == 1) {
                if (checkBoardPosition(getSource().getX() + 1, getSource().getY()) == ChessColor.NONE) {
                    result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    if (checkBoardPosition(getSource().getX() + 2, getSource().getY()) == ChessColor.NONE) {
                        result.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()));
                    }
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                } else {
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
            } else {
                if (checkBoardPosition(getSource().getX() + 1, getSource().getY()) == ChessColor.NONE) {
                    result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    if (checkBoardPosition(getSource().getX() + 2, getSource().getY()) == ChessColor.NONE) {
                        result.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY()));
                    }
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                } else {
                    if (getSource().getY() == 0 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() == 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() + 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                    if (getSource().getY() != 0 && getSource().getY() != 7 && checkBoardPosition(getSource().getX() + 1, getSource().getY() - 1) == ChessColor.WHITE) {
                        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
            }
        }
        result.removeIf(p -> p.getX() < 0 || p.getX() >= 8 || p.getY() < 0 || p.getY() >= 8);
        result.removeIf(p -> checkBoardPosition(p.getX(), p.getY()) == getChessColor());
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
