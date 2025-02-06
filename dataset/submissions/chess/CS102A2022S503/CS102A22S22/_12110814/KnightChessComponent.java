import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent  {

    public KnightChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        source = new ChessboardPoint(x, y);
        super.name = name;
        if (name == 'N')
            chessColor = ChessColor.BLACK;
        else if (name == 'n')
            chessColor = ChessColor.WHITE;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++) {
                ChessboardPoint destination = new ChessboardPoint(x, y);
                if (CMT(destination))
                    chessboardPoints.add(destination);
            }
        return chessboardPoints;
    }

    public boolean CMT(ChessboardPoint destination) {
        if (chessComponents[destination.getX()][destination.getY()].chessColor != chessColor)
            return ((Math.abs(source.getX() - destination.getX()) == 1) && (Math.abs(source.getY() - destination.getY()) == 2)) ||
                    ((Math.abs(source.getX() - destination.getX()) == 2) && (Math.abs(source.getY() - destination.getY()) == 1));
        return false;
    }
}
