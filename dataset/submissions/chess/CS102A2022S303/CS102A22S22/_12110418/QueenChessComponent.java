import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent(ChessboardPoint source, ChessColor color, char name) {
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

    public boolean moveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else if (Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY())) {
            if (destination.getX() > source.getX() && destination.getY() > source.getY()) {
                for (int col = source.getY() + 1, row = source.getX() + 1;
                     col < destination.getY() && row < destination.getX(); col++, row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else if (destination.getX() < source.getX() && destination.getY() > source.getY()) {
                for (int col = source.getY() + 1, row = source.getX() - 1;
                     col < destination.getY() && row > destination.getX(); col++, row--) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else if (destination.getX() < source.getX() && destination.getY() < source.getY()) {
                for (int col = source.getY() - 1, row = source.getX() - 1;
                     col > destination.getY() && row > destination.getX(); col--, row--) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else if (destination.getX() > source.getX() && destination.getY() < source.getY()) {
                for (int col = source.getY() - 1, row = source.getX() + 1;
                     col > destination.getY() && row < destination.getX(); col--, row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
