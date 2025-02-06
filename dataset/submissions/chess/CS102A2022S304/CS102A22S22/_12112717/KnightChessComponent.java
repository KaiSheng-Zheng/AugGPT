import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
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
            super.name = 'N';
        } else {
            super.name = 'n';
        }
    }

    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'N';
        } else {
            super.name = 'n';
        }
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'N';
        } else {
            super.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> list = new ArrayList<>();
        if (judgeCanMoveTo(x - 2, y - 1)) {
            list.add(new ChessboardPoint(x - 2, y - 1));
        }
        if (judgeCanMoveTo(x - 2, y + 1)) {
            list.add(new ChessboardPoint(x - 2, y + 1));
        }
        if (judgeCanMoveTo(x - 1, y - 2)) {
            list.add(new ChessboardPoint(x - 1, y - 2));
        }
        if (judgeCanMoveTo(x - 1, y + 2)) {
            list.add(new ChessboardPoint(x - 1, y + 2));
        }
        if (judgeCanMoveTo(x + 1, y - 2)) {
            list.add(new ChessboardPoint(x + 1, y - 2));
        }
        if (judgeCanMoveTo(x + 1, y + 2)) {
            list.add(new ChessboardPoint(x + 1, y + 2));
        }
        if (judgeCanMoveTo(x + 2, y - 1)) {
            list.add(new ChessboardPoint(x + 2, y - 1));
        }
        if (judgeCanMoveTo(x + 2, y + 1)) {
            list.add(new ChessboardPoint(x + 2, y + 1));
        }return list;
    }

    public boolean judgeCanMoveTo(int x, int y) {
        boolean p=false;ChessComponent[][] a=getChessComponents();
        if (x >= 0 && x <= 7) {
            if( y >= 0 && y <= 7){
                if (!a[x][y].getChessColor().equals(getChessColor())){p=true;}
            }
        } return p;
    }
}
