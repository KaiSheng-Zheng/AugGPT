import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    int x; int y;

    public RookChessComponent(int x, int y, char name) {
        super(x,y,name);
        this.name = 'R';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i <=7 ; i++) {
            for (int j = 0; j <= 7; j++) {
                if(canMoveTo(chessboard,new ChessboardPoint(i,j))&&this.getChessColor()!=chessboard[i][j].getChessColor()){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = this.getSource();
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
