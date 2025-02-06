import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor color, char name) {
        this.name = name;
        this.source = source;
        this.chessColor = color;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                ChessboardPoint destination=component.getSource();
                if (moveTo(chessComponents,destination)&&component.getChessColor()!=chessColor){
                    a.add(destination);
                }
            }
        }
        return a;
    }
    public boolean moveTo(ChessComponent[][] chessComponents, ChessboardPoint destination){
        if (chessColor == ChessColor.BLACK) {
            if (source.getX() == 1) {
                if (destination.getY() == source.getY() && destination.getX() - source.getX() == 2) {
                    if (!(chessComponents[destination.getX() - 1][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    } else return true;
                } else if (destination.getX() - source.getX() == 1 && destination.getY() == source.getY()) {
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    } else return true;
                } else if (Math.abs(destination.getY() - source.getY()) == 1 && destination.getX() - source.getX() == 1) {
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                        return true;
                    } else return false;
                } else return false;
            } else if (destination.getX() - source.getX() == 1 && destination.getY() == source.getY()) {
                if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                    return false;
                } else return true;
            } else if (Math.abs(destination.getY() - source.getY()) == 1 && destination.getX() - source.getX() == 1) {
                if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.WHITE) {
                    return true;
                }
                else return false;
            } else return false;
        } else if (chessColor == ChessColor.WHITE) {
            if (source.getX() == 6) {
                if (destination.getY() == source.getY() && source.getX() - destination.getX() == 2) {
                    if (!(chessComponents[source.getX() - 1][source.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    } else return true;
                } else if (source.getX() - destination.getX() == 1 && destination.getY() == source.getY()) {
                    if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                        return false;
                    } else return true;
                } else if (Math.abs(destination.getY() - source.getY()) == 1 && source.getX() - destination.getX() == 1) {
                    if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                        return true;
                    } else return false;
                } else return false;
            } else if (source.getX() - destination.getX() == 1 && destination.getY() == source.getY()) {
                if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                    return false;
                } else return true;
            } else if (Math.abs(destination.getY() - source.getY()) == 1 && source.getX() - destination.getX() == 1) {
                if (chessComponents[destination.getX()][destination.getY()].getChessColor() == ChessColor.BLACK) {
                    return true;
                } else return false;
            } else return false;
        }
        return false;
    }


}
