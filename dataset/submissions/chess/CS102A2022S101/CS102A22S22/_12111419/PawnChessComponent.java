import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public PawnChessComponent() {
        super();
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        int x = this.source.getX();
        int y = this.source.getY();
        if (this.chessColor == ChessColor.WHITE) {

            if (chessComponent[x-1][y].getChessColor() == ChessColor.NONE) {
                list.add(new ChessboardPoint(x-1,y));
            }

            if (y-1>=0 && chessComponent[x-1][y-1].getChessColor() == ChessColor.BLACK) {
                list.add(new ChessboardPoint(x-1,y-1));
            }
            if (y+1<8 && chessComponent[x-1][y+1].getChessColor() == ChessColor.BLACK) {
                list.add(new ChessboardPoint(x-1,y+1));
            }

            if (x == 6) {
                if (chessComponent[x-2][y].getChessColor() == ChessColor.NONE && chessComponent[x-1][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x-2,y));
                }

            }


        } else {

            if (chessComponent[x+1][y].getChessColor() == ChessColor.NONE) {
                list.add(new ChessboardPoint(x+1,y));
            }
            if (y-1>=0 && chessComponent[x+1][y-1].getChessColor() == ChessColor.WHITE) {
                list.add(new ChessboardPoint(x+1,y-1));
            }
            if (y+1<8 && chessComponent[x+1][y+1].getChessColor() == ChessColor.WHITE) {
                list.add(new ChessboardPoint(x+1,y+1));
            }
            if (x == 1) {
                if (chessComponent[x+2][y].getChessColor() == ChessColor.NONE && chessComponent[x+1][y].getChessColor() == ChessColor.NONE) {
                    list.add(new ChessboardPoint(x+2,y));
                }

            }

        }


        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void setSource(int targetX, int targetY) {
        this.source = new ChessboardPoint(targetX,targetY);
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public ChessboardPoint getChessboardPoint() {
        return super.getChessboardPoint();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
