import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public KnightChessComponent() {
        super();
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();

        int x = this.source.getX();
        int y = this.source.getY();

        for (int i=0;i<8;i++) {
            for (int j=0;j<8;j++) {
                if (Math.abs(x-i)==2 && Math.abs(y-j)==1 && chessComponent[i][j].getChessColor() != chessColor ) {
                    list.add(new ChessboardPoint(i,j));
                } else if (Math.abs(x-i)==1 && Math.abs(y-j)==2 && chessComponent[i][j].getChessColor() != chessColor) {
                    list.add(new ChessboardPoint(i,j));
                }
            }
        }

        if (list.size()==0) {
            return new ArrayList<>();
        } else {
            return list;
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
