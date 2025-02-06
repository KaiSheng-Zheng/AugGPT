import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor color, char name) {
        this.name = name;
        this.source = source;
        this.chessColor = color;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> a = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessboardPoint destination=new ChessboardPoint(i,j);
                if (moveTo(chessComponents,destination)&&chessComponents[i][j].getChessColor()!=chessColor){
                    a.add(destination);
                }
            }

        }
        return a;
    }
    public boolean moveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        if (source.getX()==destination.getX()&&source.getY()==destination.getY()){return false;}
        if (Math.abs(source.getX() - destination.getX()) == Math.abs(source.getY() - destination.getY())) {
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
        } else return false;
    }
}
