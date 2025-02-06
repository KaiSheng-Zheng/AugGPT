import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ChessboardPoint = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(source.getX(),source.getY(),i,j)){
                    ChessboardPoint.add(new ChessboardPoint(i,j));
                }

            }
        }
        return ChessboardPoint;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=super.getChessColor()){
            return false;
        }
        if (chessComponents[sourceX][sourceY].getChessColor() != chessComponents[targetX][targetY].getChessColor()) {
            if (sourceX == targetX) {
                for (int col = Math.min(sourceY, targetY) + 1;
                     col < Math.max(sourceY, targetY); col++) {
                    if (chessComponents[sourceX][col].toString().charAt(0)!='_') {
                        return false;
                    }
                }
                return true;
            } else if (sourceY == targetY) {
                for (int row = Math.min(sourceX, targetX) + 1;
                     row < Math.max(sourceX, targetY); row++) {
                    if (chessComponents[row][sourceY].toString().charAt(0)!='_') {
                        return false;
                    }
                }
                return true;
            }

        }
        return false;
    }
}
