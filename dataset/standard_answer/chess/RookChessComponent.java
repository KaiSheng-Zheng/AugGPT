import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo2 = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() != 7) {
                for (int i = getSource().getX() + 1; i < 8; i++) {
                    if (getChessComponents()[i][getSource().getY()] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                        break;
                    }
                }
            }
            if (getSource().getX() != 0) {
                for (int i = getSource().getX() - 1; i >= 0; i--) {
                    if (getChessComponents()[i][getSource().getY()] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                        break;
                    }
                }
            }
            if (getSource().getY() != 7) {
                for (int i = getSource().getY() + 1; i < 8; i++) {
                    if (getChessComponents()[getSource().getX()][i] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.WHITE) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.BLACK) {
                        break;
                    }
                }
            }
            if (getSource().getX() != 0) {
                for (int i = getSource().getY() - 1; i >= 0; i--) {
                    if (getChessComponents()[getSource().getX()][i] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.WHITE) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.BLACK) {
                        break;
                    }
                }
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() != 7) {
                for (int i = getSource().getX() + 1; i < 8; i++) {
                    if (getChessComponents()[i][getSource().getY()] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }
            }
            if (getSource().getX() != 0) {
                for (int i = getSource().getX() - 1; i >= 0; i--) {
                    if (getChessComponents()[i][getSource().getY()] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                        canMoveTo2.add(new ChessboardPoint(i, getSource().getY()));
                        break;
                    } else if (getChessComponents()[i][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }
            }
            if (getSource().getY() != 7) {
                for (int i = getSource().getY() + 1; i < 8; i++) {
                    if (getChessComponents()[getSource().getX()][i] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.BLACK) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }
            }
            if (getSource().getX() != 0) {
                for (int i = getSource().getY() - 1; i >= 0; i--) {
                    if (getChessComponents()[getSource().getX()][i] instanceof EmptySlotComponent) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.BLACK) {
                        canMoveTo2.add(new ChessboardPoint(getSource().getX(), i));
                        break;
                    } else if (getChessComponents()[getSource().getX()][i].getChessColor() == ChessColor.WHITE) {
                        break;
                    }
                }
            }
        }
        return canMoveTo2;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
// ERROR: constructor ChessComponent in class ChessComponent cannot be applied to given types;
//  required: no arguments
//  found:    ChessboardPoint,ChessColor
//  reason: actual and formal argument lists differ in length
//         super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {
            super.name = 'r';
        } else if (chessColor == ChessColor.BLACK) {
            super.name = 'R';
        }
    }

    public RookChessComponent() {
    }
}
