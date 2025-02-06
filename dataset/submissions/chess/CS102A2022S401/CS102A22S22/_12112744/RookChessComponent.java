import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    //Variables
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //Constructor
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
//        this.source = source;
//        this.chessColor = chessColor;
        if (chessColor == ChessColor.BLACK)
            name = 'R';
        else
            name = 'r';
    }

    public RookChessComponent(ChessboardPoint source, char name) {
        super(source, name);
//        this.source = source;
//        this.name = name;
        if (name == 'R')
            chessColor = ChessColor.BLACK;
        else
            chessColor = ChessColor.WHITE;
    }

    //Methods
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMovePoint = new ArrayList<>();
        int srcX = source.getX();
        int srcY = source.getY();
        for (int x = 0; x < 8; x++) {
            if (x != srcX)
                canMovePoint.add(new ChessboardPoint(x, srcY));
        }
        for (int y = 0; y < 8; y++) {
            if (y != srcY)
                canMovePoint.add(new ChessboardPoint(srcX, y));
        }
        return canMovePoint;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    //Methods
    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}
