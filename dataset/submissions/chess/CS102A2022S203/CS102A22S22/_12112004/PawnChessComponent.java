import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    boolean b = false;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    ConcreteChessGame concreteChessGame = new ConcreteChessGame();
    public ChessboardPoint destination;
    private boolean theFirstStep;

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
        if (chessComponents[sourceX][sourceX].getChessColor() != chessComponents[targetX][targetY].getChessColor()) {
            if (sourceX==1||sourceX==6) {
                if (sourceY - targetY == 0) {
                    if (targetX - sourceX == 1 ) {
                        return true;
                    }
                    else if (sourceX==1){
                        if (chessComponents[sourceX + 1][sourceY].toString().charAt(0) == '_' && targetX - sourceX == 2) {
                            return true;
                        }
                    }
                }
            }
            if (sourceY - targetY == 0 && targetX - sourceX == 1) {
                if (chessComponents[sourceX][sourceX].getChessColor() == ChessColor.BLACK) {
                    if (sourceX - 1 >= 0) {
                        if (chessComponents[sourceX - 1][sourceY].toString().charAt(0) == '_') {
                            return true;
                        }
                    }
                }
            }
            if (sourceY - 1 >= 0) {
                if (sourceY + 1 < 8) {
                    if (chessComponents[sourceX][sourceY - 1].toString().charAt(0) != '_' || chessComponents[sourceX][sourceY + 1].toString().charAt(0) != '_') {
                        b = true;
                    }
                } else {
                    if (chessComponents[sourceX][sourceY - 1].toString().charAt(0) != '_') {
                        b = true;
                    }
                }
            } else {
                if (chessComponents[sourceX][sourceY + 1].toString().charAt(0) != '_') {
                    b = true;
                }
            }
        }
        return false;
    }
}
