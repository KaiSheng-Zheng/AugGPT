import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
    ConcreteChessGame concreteChessGame = new ConcreteChessGame();
    public ChessboardPoint destination;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ChessboardPoint = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (moveChess(source.getX(), source.getY(), i, j)) {
                    ChessboardPoint.add(new ChessboardPoint(i, j));
                }

            }
        }
        return ChessboardPoint;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor()!=super.getChessColor()){
            return false;
        }
        if (chessComponents[sourceX][sourceX].getChessColor()!= chessComponents[targetX][targetY].getChessColor()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int flag = 0;
                    if ((sourceX + sourceY == targetX + targetY)) {
                        flag = 1;
                    } else if ((sourceX - sourceY == targetX - targetY)) {
                        flag = 1;
                    }
                    if (flag != 0) return true;

                    else {
                        int col = targetY;
                        for (int row = targetX; row != sourceX; ) {
                            if (row < sourceX) row++;
                            else row--;

                            if (col < sourceY) col++;
                            else col--;
                            if ((row != sourceX) && !(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            } else {
                                return true;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }
}
