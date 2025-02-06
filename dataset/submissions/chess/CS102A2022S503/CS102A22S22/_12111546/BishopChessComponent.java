import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> returnList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(new ChessboardPoint(i, j)))
                    returnList.add(new ChessboardPoint(i, j));
            }
        }
        return returnList;
    }

    public boolean canMoveTo(ChessboardPoint destination) {
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();

        if (sourceX - destination.getX() == sourceY - destination.getY()) {
            int row_min = Math.min(sourceX, destination.getX());
            int col_min = Math.min(sourceY, destination.getY());
            for (int col = col_min + 1; col < Math.max(sourceY, destination.getY()); col++) {
                int i = col - col_min;
                if (game.getChess(row_min + i, col).getChessColor() == ChessColor.WHITE
                        || game.getChess(row_min + i, col).getChessColor() == ChessColor.BLACK)
                    return false;
            }
            if (game.getChess(destination.getX(), destination.getY()).getChessColor() == getChessColor())return false;


        } else if (sourceX - destination.getX() == -sourceY + destination.getY()) {
            int row_max = Math.max(sourceX, destination.getX());
            int col_min = Math.min(sourceY, destination.getY());
            for (int col = Math.min(sourceY, destination.getY()) + 1; col < Math.max(sourceY, destination.getY()); col++) {
                int i = col - col_min;
                if (game.getChess(row_max - i, col).getChessColor() == ChessColor.WHITE
                        || game.getChess(row_max - i, col).getChessColor() == ChessColor.BLACK)
                    return false;
            }
            if (game.getChess(destination.getX(), destination.getY()).getChessColor() == getChessColor())return false;
        }  else {
            return false;
        }
        return true;
    }
}
