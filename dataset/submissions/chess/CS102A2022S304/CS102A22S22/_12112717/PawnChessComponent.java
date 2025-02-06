import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else {
            super.name = 'p';
        }
    }

    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else {
            super.name = 'p';
        }
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'P';
        } else {
            super.name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] a = getChessComponents();
        if (getChessColor().equals(ChessColor.WHITE)) {
            if (x == 6) {
                List<ChessboardPoint> list = new ArrayList<>();
                if (a[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(x - 1, y));
                    if (a[x - 2][y].getChessColor().equals(ChessColor.NONE)) {
                        list.add(new ChessboardPoint(x - 2, y));
                    }
                }
                if (y != 0) {
                    if (a[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                        list.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y != 7) {
                    if (a[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                        list.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
                return list;
            } else {
                if (x == 0) {
                    return new ArrayList<ChessboardPoint>();
                }
                List<ChessboardPoint> list = new ArrayList<>();
                if (a[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(x - 1, y));
                }
                if (y != 0) {
                    if (a[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                        list.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y != 7) {
                    if (a[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                        list.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
                return list;
            }
        } else {
            if (x == 1) {
                List<ChessboardPoint> list = new ArrayList<>();
                if (a[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(x + 1, y));
                    if (a[x + 2][y].getChessColor().equals(ChessColor.NONE)) {
                        list.add(new ChessboardPoint(x + 2, y));
                    }
                }
                if (y != 0) {
                    if (a[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y != 7) {
                    if (a[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
                return list;
            } else {
                if (x == 7) {
                    return new ArrayList<ChessboardPoint>();
                }
                List<ChessboardPoint> list = new ArrayList<>();
                if (a[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                    list.add(new ChessboardPoint(x + 1, y));
                }
                if (y != 0) {
                    if (a[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y != 7) {
                    if (a[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                        list.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
                return list;
            }
        }
    }

    public boolean ifCanMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }
}
