import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
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
            super.name = 'K';
        } else {
            super.name = 'k';
        }
    }

    public KingChessComponent() {
    }

    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'K';
        } else {
            super.name = 'k';
        }
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'K';
        } else {
            super.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        // missing condition when (x,y+1) is valid
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] a = getChessComponents();
        List<ChessboardPoint> list = new ArrayList<>();
        if (x - 1 >= 0) {
            if (!a[x - 1][y].getChessColor().equals(getChessColor())) {
                list.add(new ChessboardPoint(x - 1, y));
            }
            if (y - 1 >= 0) {
                if (!a[x-1][y - 1].getChessColor().equals(getChessColor())) {
                    list.add(new ChessboardPoint(x-1, y - 1));
                }
            }if (y+1<=7){
                if (!a[x -1][y+1].getChessColor().equals(getChessColor())) {
                    list.add(new ChessboardPoint(x -1, y+1));
                }
            }
        }if (y -1>=0) {

            if (!a[x][y - 1].getChessColor().equals(getChessColor())) {
                list.add(new ChessboardPoint(x, y - 1));

            }if (y+1<=7){
                if (!a[x ][y+1].getChessColor().equals(getChessColor())) {
                    list.add(new ChessboardPoint(x , y+1));
                }
            }
        }if (x + 1 <=7) {
            if (!a[x + 1][y].getChessColor().equals(getChessColor())) {
                list.add(new ChessboardPoint(x + 1, y));
            }
            if (y - 1 >= 0) {
                if (!a[x+1][y - 1].getChessColor().equals(getChessColor())) {
                    list.add(new ChessboardPoint(x+1, y - 1));
                }
            }if (y+1<=7){
                if (!a[x+1 ][y+1].getChessColor().equals(getChessColor())) {
                    list.add(new ChessboardPoint(x+1 , y+1));
                }
            }
        }
        return list;
    }


}
