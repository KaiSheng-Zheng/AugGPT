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
        ChessComponent[][]a=getChessComponents();
        List<ChessboardPoint> list = new ArrayList<>();
        if (x -2>= 0 && x-2 <= 7){
            if (y -1>= 0 && y-1 <= 7){
                if (!a[x-2][y-1].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x - 2, y - 1));}
            }
        }if (x +2>= 0 && x+2 <= 7){
            if (y -1>= 0 && y-1 <= 7){
                if (!a[x+2][y-1].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x + 2, y - 1));}
            }
        }if (x -2>= 0 && x-2 <= 7){
            if (y +1>= 0 && y+1 <= 7){
                if (!a[x-2][y+1].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x - 2, y +1));}
            }
        }if (x +2>= 0 && x+2 <= 7){
            if (y +1>= 0 && y+1 <= 7){
                if (!a[x+2][y+1].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x + 2, y + 1));}
            }
        }if (x -1>= 0 && x-1 <= 7){
            if (y -2>= 0 && y-2 <= 7){
                if (!a[x-1][y-2].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x - 1, y - 2));}
            }
        }if (x +1>= 0 && x+1 <= 7){
            if (y -2>= 0 && y-2 <= 7){
                if (!a[x+1][y-2].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x + 1, y - 2));}
            }
        }if (x -1>= 0 && x-1 <= 7){
            if (y +2>= 0 && y+2 <= 7){
                if (!a[x-1][y+2].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x - 1, y + 2));}
            }
        }if (x +1>= 0 && x+1 <= 7){
            if (y +2>= 0 && y+2 <= 7){
                if (!a[x+1][y+2].getChessColor().equals(getChessColor())){list.add(new ChessboardPoint(x + 1, y + 2));}
            }
        }
        return list;
    }
}
