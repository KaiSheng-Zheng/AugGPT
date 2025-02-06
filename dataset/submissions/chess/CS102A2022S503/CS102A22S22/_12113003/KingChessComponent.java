import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color) {
        if(color==ChessColor.BLACK){
            name='K';
        }
        if(color==ChessColor.WHITE){
            name='k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        if (x + 1 < 8 && x - 1 >= 0 && y + 1 < 8 && y - 1 >= 0) {
            for (int i = -1; i < 2; i++) {
                if (chessComponents[x + i][y + i].getChessColor() != super.getChessColor()) {
                    canMove.add(new ChessboardPoint(x + i, y + i));
                }
            }
        }
        if (x + 1 < 8 && x - 1 >= 0 && y - 1 < 0) {
            for (int i = -1; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (chessComponents[x + i][y + j].getChessColor() != super.getChessColor()) {
                        canMove.add(new ChessboardPoint(x + i, y + j));
                    }
                }
            }
        }
        if (x + 1 < 8 && x - 1 >= 0 && y + 1 >= 8) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 1; j++) {
                    if (chessComponents[x + i][y + j].getChessColor() != super.getChessColor()) {
                        canMove.add(new ChessboardPoint(x + i, y + j));
                    }
                }
            }
        }
        if (x - 1 < 0 && y + 1 < 8 && y - 1 >= 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (chessComponents[x + i][y + j].getChessColor() != super.getChessColor()) {
                        canMove.add(new ChessboardPoint(x + i, y + j));
                    }
                }
            }
        }
        if (x + 1 >= 8 && y + 1 < 8 && y - 1 >= 0) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 2; j++) {
                    if (chessComponents[x + i][y + j].getChessColor() != super.getChessColor()) {
                        canMove.add(new ChessboardPoint(x + i, y + j));
                    }
                }
            }
        }
        return canMove;
    }
}