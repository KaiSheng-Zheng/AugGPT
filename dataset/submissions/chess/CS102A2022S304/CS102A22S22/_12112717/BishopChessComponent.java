import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
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
            super.name = 'B';
        } else {
            super.name = 'b';
        }
    }

    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'B';
        } else {
            super.name = 'b';
        }
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'B';
        } else {
            super.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] a = getChessComponents();

        int x = getSource().getX();
        int y = getSource().getY();

        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 1; ; i++) {
            if (x - i == -1 || y + i == 8) {
                break;
            }
            if (getChessColor().equals(a[x - i][y + i].getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x - i, y + i));
            if (!getChessColor().equals(a[x - i][y + i].getChessColor()) && !a[x - i][y + i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (x - i == -1 || y - i == -1) {
                break;
            }
            if (getChessColor().equals(a[x - i][y - i].getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x - i, y - i));
            if (!getChessColor().equals(a[x - i][y - i].getChessColor()) && !a[x - i][y - i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (x + i == 8 || y - i == -1) {
                break;
            }
            if (getChessColor().equals(a[x + i][y - i].getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x + i, y - i));
            if (!getChessColor().equals(a[x + i][y - i].getChessColor()) && !a[x + i][y - i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }
        for (int i = 1; ; i++) {
            if (x + i == 8 || y + i == 8) {
                break;
            }
            if (getChessColor().equals(a[x + i][y + i].getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x + i, y + i));
            if (!getChessColor().equals(a[x + i][y + i].getChessColor()) && !a[x + i][y + i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }
        return list;

    }


}
