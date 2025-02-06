import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo2 = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() >= getSource().getY()) {
                if (getSource().getX() != 7) {
                    for (int i = 1; i <= 7 - getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
                if (getSource().getY() != 0) {
                    for (int i = 1; i <= getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
            } else {
                if (getSource().getY() != 7) {
                    for (int i = 1; i <= 7 - getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
                if (getSource().getX() != 0) {
                    for (int i = 1; i <= getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
            }
            if (getSource().getX() + getSource().getY() >= 7) {
                if (getSource().getX() != 7) {
                    for (int i = 1; i <= 7 - getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
                if (getSource().getY() != 7) {
                    for (int i = 1; i <= 7 - getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
            } else {
                if (getSource().getY() != 0) {
                    for (int i = 1; i <= getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
                if (getSource().getX() != 0) {
                    for (int i = 1; i <= getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            break;
                        }
                    }
                }
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            if (getSource().getX() >= getSource().getY()) {
                if (getSource().getX() != 7) {
                    for (int i = 1; i <= 7 - getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
                if (getSource().getY() != 0) {
                    for (int i = 1; i <= getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
            } else {
                if (getSource().getY() != 7) {
                    for (int i = 1; i <= 7 - getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
                if (getSource().getX() != 0) {
                    for (int i = 1; i <= getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
            }
            if (getSource().getX() + getSource().getY() >= 7) {
                if (getSource().getX() != 7) {
                    for (int i = 1; i <= 7 - getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
                if (getSource().getY() != 7) {
                    for (int i = 1; i <= 7 - getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
            } else {
                if (getSource().getY() != 0) {
                    for (int i = 1; i <= getSource().getY(); i++) {
                        if (getChessComponents()[getSource().getX() + i][getSource().getY() - i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() + i, getSource().getY() - i));
                            break;
                        } else if (getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
                if (getSource().getX() != 0) {
                    for (int i = 1; i <= getSource().getX(); i++) {
                        if (getChessComponents()[getSource().getX() - i][getSource().getY() + i] instanceof EmptySlotComponent) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.BLACK) {
                            canMoveTo2.add(new ChessboardPoint(getSource().getX() - i, getSource().getY() + i));
                            break;
                        } else if (getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor() == ChessColor.WHITE) {
                            break;
                        }
                    }
                }
            }
        }
        return canMoveTo2;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) {
            super.name = 'b';
        } else if (chessColor == ChessColor.BLACK) {
            super.name = 'B';
        }
    }
}
