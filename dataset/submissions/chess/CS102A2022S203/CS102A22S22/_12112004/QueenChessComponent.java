import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[sourceX][sourceX].getChessColor()== chessComponents[targetX][targetY].getChessColor()){
                    return false;
                }
                if (sourceX == targetX) {
                    int row = sourceX;
                    for (int col = Math.min(sourceY, targetY) + 1;
                         col < Math.max(sourceY, targetY); col++) {
                        if (chessComponents[row][sourceY].toString().charAt(0)!='_') {
                            return false;
                        }
                    }
                    return true;
                } else if (sourceY == targetY) {
                    int col = sourceY;
                    for (int row = Math.min(sourceX, targetX) + 1;
                         row < Math.max(sourceX, targetX); row++) {
                        if (chessComponents[row][sourceY].toString().charAt(0)!='_') {
                            return false;
                        }
                    }
                    return true;
                }
                else if (Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)) {
                    int col = Math.min(sourceY, targetY) + 1;
                    for (int row = Math.min(sourceX, targetX) + 1;
                         row < Math.max(sourceX, targetX); row++, col++) {
                        if (chessComponents[row][sourceY].toString().charAt(0)!='_') {
                            return false;
                        }

                    }
                    return true;
                }
            }
        }

        return false;
    }
}

