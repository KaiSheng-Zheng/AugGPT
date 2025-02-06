import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public KingChessComponent() {
        super();
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        int x = source.getX();
        int y = source.getY();

        for (int i=x-1;i<x+2;i++) {
            if (0<=i && i <8) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (0<=j && j<8) {
                        if ((i != x || j != y) && chessComponent[i][j].getChessColor() != this.chessColor) {
                            list.add(new ChessboardPoint(i, j));
                        }
                    }
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
