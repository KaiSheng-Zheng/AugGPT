import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints= new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e= belonging.getChessComponents()[i][j];
                if (this.move(belonging.getChessComponents(),e.getChessboardPoint()))chessboardPoints.add(e.getChessboardPoint());
            }

        }
        return chessboardPoints;
    }
    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor())return false;
        if (destination.getX()>8||destination.getX()<0)return false;
        if (destination.getY()>8||destination.getY()<0)return false;
        ChessComponent c = chessComponents[destination.getX()][destination.getY()];
        ChessComponent d = chessComponents[source.getX()][source.getY()];
//        if (c.steps==0&&d.steps==0){
//            if (c instanceof KingChessComponent&&c.chessColor==)
//        }
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

}
    