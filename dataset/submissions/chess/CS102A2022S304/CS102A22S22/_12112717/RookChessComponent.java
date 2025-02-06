import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'R';
        } else {
            super.name = 'r';
        }
    }

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
            super.name = 'R';
        } else {
            super.name = 'r';
        }
    }

    public RookChessComponent() {
    }

    public RookChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'R';
        } else {
            super.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] a = getChessComponents();
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 1; i < 8 - x; i++) {
            if (a[x + i][y].getChessColor().equals(getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x + i, y));
            if (!a[x + i][y].getChessColor().equals(getChessColor()) && !a[x + i][y].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        } for (int i = 1; i <= x; i++) {
            if (a[x - i][y].getChessColor().equals(getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x - i, y));
            if (!a[x - i][y].getChessColor().equals(getChessColor()) && !a[x - i][y].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }for (int i = 1; i < 8 - y; i++) {
            if (a[x ][y+i].getChessColor().equals(getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x , y+i));
            if (!a[x ][y+i].getChessColor().equals(getChessColor()) && !a[x ][y+i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        } for (int i = 1; i <= y; i++) {
            if (a[x ][y-i].getChessColor().equals(getChessColor())) {
                break;
            }
            list.add(new ChessboardPoint(x , y-i));
            if (!a[x ][y-i].getChessColor().equals(getChessColor()) && !a[x ][y-i].getChessColor().equals(ChessColor.NONE)) {
                break;
            }
        }
        return list;
    }
}
