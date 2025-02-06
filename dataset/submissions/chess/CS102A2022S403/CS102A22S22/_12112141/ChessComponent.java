import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent getChessComponent(ChessboardPoint point) {
        if (ChessboardPoint.inChess(point.getX(), point.getY()))
            return chessComponents[point.getX()][point.getY()];
        return null;
    }

    public boolean isEnemy(ChessboardPoint p) {
        ChessComponent m = getChessComponent(getSource());
        ChessComponent e = getChessComponent(p);

        if (m.getChessColor().equals(ChessColor.BLACK) && e.getChessColor().equals(ChessColor.WHITE))
            return true;

        if (e.getChessColor().equals(ChessColor.BLACK) && m.getChessColor().equals(ChessColor.WHITE))
            return true;
        return false;
    }

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    List<ChessboardPoint> getXXYY() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint src = getSource();

        boolean first = false;
        for (int x = 1; x < 8; x++) {
            ChessboardPoint dst = src.offset(x, 0);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }

        first = false;
        for (int x = -1; x != -8; x--) {
            ChessboardPoint dst = src.offset(x, 0);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }

        first = false;
        for (int y = 1; y <= 80; y++) {
            ChessboardPoint dst = src.offset(0, y);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();

            if (you.equals(ChessColor.NONE))
                list.add(dst);

            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }
        first = false;
        for (int y = -1; y != -8; y--) {
            ChessboardPoint dst = src.offset(0, y);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();

            if (you.equals(ChessColor.NONE))
                list.add(dst);

            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }
        return list;
    }

    List<ChessboardPoint> getXYXY() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint src = getSource();

        boolean first = false;
        for (int i = 1; i < 8; i++) {
            ChessboardPoint dst = src.offset(i, i);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }
        first = false;
        for (int i = 1; i < 8; i++) {
            ChessboardPoint dst = src.offset(-i, -i);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }

        first = false;
        for (int i = 1; i < 8; i++) {
            ChessboardPoint dst = src.offset(i, -i);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }

        first = false;
        for (int i = 1; i < 8; i++) {
            ChessboardPoint dst = src.offset(-i, i);
            if (dst == null)
                continue;
            ChessColor my = getChessColor();
            ChessColor you = getChessComponent(dst).getChessColor();
            if (you.equals(ChessColor.NONE))
                list.add(dst);
            else if (!first && !you.equals(my)) {
                first = true;
                list.add(dst);
            } else {
                break;
            }
        }
        return list;
    }

}
