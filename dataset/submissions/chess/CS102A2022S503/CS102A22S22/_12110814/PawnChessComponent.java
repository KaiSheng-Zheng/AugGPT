import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent  {

    public PawnChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        source = new ChessboardPoint(x, y);
        super.name = name;
        if (name == 'P')
            chessColor = ChessColor.BLACK;
        else if (name == 'p')
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
        if (chessComponents[destination.getX()][destination.getY()].chessColor != chessColor) {
            int prF = 0;
            if (super.chessColor == ChessColor.WHITE) prF = -1;
            else if (super.chessColor == ChessColor.BLACK) prF = 1;

            if (source.getX() + prF == destination.getX() && source.getY() == destination.getY()) {
                return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent;

            } else if (source.getX() + prF == destination.getX() && Math.abs(source.getY() - destination.getY()) == 1) {
                return !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent);

            } else if (source.getX() + prF * 2 == destination.getX() && source.getY() == destination.getY()) {
                if ((super.chessColor == ChessColor.WHITE && source.getX() == 6) ||
                        (super.chessColor == ChessColor.BLACK && source.getX() == 1))
                    return chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent
                            && chessComponents[destination.getX() - prF][destination.getY()] instanceof EmptySlotComponent;

            } else { // Not on the same row or the same column.
                return false;
            }
        }
        return false;
    }
}
