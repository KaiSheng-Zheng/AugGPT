import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo2 = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().offset(2, 1) != null) {
                if (getChessComponents()[getSource().getX() + 2][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() + 2][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1));
                }
            }
            if (getSource().offset(2, -1) != null) {
                if (getChessComponents()[getSource().getX() + 2][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() + 2][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1));
                }
            }
            if (getSource().offset(-2, 1) != null) {
                if (getChessComponents()[getSource().getX() - 2][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() - 2][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1));
                }
            }
            if (getSource().offset(-2, -1) != null) {
                if (getChessComponents()[getSource().getX() - 2][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() - 2][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1));
                }
            }
            if (getSource().offset(1, 2) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 2].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2));
                }
            }
            if (getSource().offset(1, -2) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 2].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2));
                }
            }
            if (getSource().offset(-1, 2) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 2].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2));
                }
            }
            if (getSource().offset(-1, -2) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 2].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
                }
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            if (getSource().offset(2, 1) != null) {
                if (getChessComponents()[getSource().getX() + 2][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() + 2][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1));
                }
            }
            if (getSource().offset(2, -1) != null) {
                if (getChessComponents()[getSource().getX() + 2][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() + 2][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1));
                }
            }
            if (getSource().offset(-2, 1) != null) {
                if (getChessComponents()[getSource().getX() - 2][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() - 2][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1));
                }
            }
            if (getSource().offset(-2, -1) != null) {
                if (getChessComponents()[getSource().getX() - 2][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() - 2][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1));
                }
            }
            if (getSource().offset(1, 2) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 2].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2));
                }
            }
            if (getSource().offset(1, -2) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 2].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2));
                }
            }
            if (getSource().offset(-1, 2) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 2].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2));
                }
            }
            if (getSource().offset(-1, -2) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 2] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 2].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
                }
            }
        }
        return canMoveTo2;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {
            super.name = 'n';
        } else if (chessColor == ChessColor.BLACK) {
            super.name = 'N';
        }
    }
}
