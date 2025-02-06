import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
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
            super.name = 'Q';
        } else {
            super.name = 'q';
        }
    }

    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'Q';
        } else {
            super.name = 'q';
        }
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'Q';
        } else {
            super.name = 'q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo( ){
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][]a=getChessComponents();
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
        }for (int i = 1; ; i++) {
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
