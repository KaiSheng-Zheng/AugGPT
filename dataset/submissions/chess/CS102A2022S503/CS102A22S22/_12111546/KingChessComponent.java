import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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

        if (
                (sourceX == destination.getX()&&(sourceY == destination.getY() + 1 || sourceY == destination.getY() - 1))
                ||(sourceY == destination.getY()&&(sourceX == destination.getX() + 1 || sourceX == destination.getX() - 1))
                ||(sourceX - destination.getX() == sourceY - destination.getY() && (sourceX == destination.getX() + 1 || sourceX == destination.getX() - 1))
                ||(sourceX - destination.getX() == -sourceY + destination.getY() && (sourceX == destination.getX() + 1 || sourceX == destination.getX() - 1))
        )
        {
            if (game.getChess(destination.getX(), destination.getY()).getChessColor() == getChessColor())
                return false;
        }
        else {
            return false;
        }
        return true;
    }

}
