import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo2 = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().offset(1, 1) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                }
            }
            if (getSource().offset(1, -1) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                }
            }
            if (getSource().offset(-1, 1) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                }
            }
            if (getSource().offset(-1, -1) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                }
            }
            if (getSource().offset(1, 0) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                }
            }
            if (getSource().offset(-1, 0) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                }
            }
            if (getSource().offset(0, -1) != null) {
                if (getChessComponents()[getSource().getX()][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX()][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
                }
            }
            if (getSource().offset(0, 1) != null) {
                if (getChessComponents()[getSource().getX()][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX()][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
                }
            }
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getChessComponents()[i][j].getChessColor() == ChessColor.WHITE) {
//                        for (int k = 0; k < canMoveTo2.size(); k++) {
//                            for (int l = 0; l < getChessComponents()[i][j].canMoveTo().size(); l++) {
//                                if (canMoveTo2.get(k).toString().equals(getChessComponents()[i][j].canMoveTo().get(l).toString())) {
//                                    canMoveTo2.remove(k);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
        } else if (getChessColor() == ChessColor.WHITE) {
            if (getSource().offset(1, 1) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                }
            }
            if (getSource().offset(1, -1) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                }
            }
            if (getSource().offset(-1, 1) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                }
            }
            if (getSource().offset(-1, -1) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                }
            }
            if (getSource().offset(1, 0) != null) {
                if (getChessComponents()[getSource().getX() + 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                } else if (getChessComponents()[getSource().getX() + 1][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                }
            }
            if (getSource().offset(-1, 0) != null) {
                if (getChessComponents()[getSource().getX() - 1][getSource().getY()] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                } else if (getChessComponents()[getSource().getX() - 1][getSource().getY()].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY()));
                }
            }
            if (getSource().offset(0, -1) != null) {
                if (getChessComponents()[getSource().getX()][getSource().getY() - 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
                } else if (getChessComponents()[getSource().getX()][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() - 1));
                }
            }
            if (getSource().offset(0, 1) != null) {
                if (getChessComponents()[getSource().getX()][getSource().getY() + 1] instanceof EmptySlotComponent) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
                } else if (getChessComponents()[getSource().getX()][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    canMoveTo2.add(new ChessboardPoint(getSource().getX(), getSource().getY() + 1));
                }
            }
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (getChessComponents()[i][j].getChessColor() == ChessColor.BLACK) {
//                        for (int k = 0; k < canMoveTo2.size(); k++) {
//                            for (int l = 0; l < getChessComponents()[i][j].canMoveTo().size(); l++) {
//                                if (canMoveTo2.get(k).toString().equals(getChessComponents()[i][j].canMoveTo().get(l).toString())) {
//                                    canMoveTo2.remove(k);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
        }
        return canMoveTo2;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {
            super.name = 'k';
        } else if (chessColor == ChessColor.BLACK) {
            super.name = 'K';
        }
    }
}
