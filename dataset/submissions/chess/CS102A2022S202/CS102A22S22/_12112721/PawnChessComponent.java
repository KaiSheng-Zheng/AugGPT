import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame){
        super(source,name,chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cbp = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(getChessGame().getChessComponents(),new ChessboardPoint(i,j))) {
                    cbp.add(new ChessboardPoint(i,j));
                }
            }
        }
        return cbp;
    }


    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (getChessColor() == ChessColor.WHITE) {
            if (source.getY() == destination.getY()) {
                if (source.getX() - destination.getX() == 1) {
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                        return false;
                    }
                }
                else if (source.getX() - destination.getX() == 2 && source.getX() == 6) {
                    if (!(chessComponents[source.getX() - 1][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                        return false;
                    }
                } else return false;
            } else if (Math.abs(source.getY() - destination.getY()) == 1) {
                if (source.getX() - destination.getX() == 1) {
                    if (chessComponents[source.getX() - 1][destination.getY()] instanceof EmptySlotComponent) {
                        return false;
                    }
                } else return false;
            } else return false;
        } else {
            if (source.getY() == destination.getY()) {
                if (source.getX() - destination.getX() == -1) {
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                        return false;
                    }
                }
                else if (source.getX() - destination.getX() == -2 && source.getX() == 1) {
                    if (!(chessComponents[source.getX() + 1][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    }
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                        return false;
                    }
                } else return false;
            } else if (Math.abs(source.getY() - destination.getY()) == 1) {
                if (source.getX() - destination.getX() == -1) {
                    if (chessComponents[source.getX() + 1][destination.getY()] instanceof EmptySlotComponent) {
                        return false;
                    }
                } else return false;
            } else return false;
        }
        if (chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        return true;
    }

}
