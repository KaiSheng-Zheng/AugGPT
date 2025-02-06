import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor color) {
        if (color == ChessColor.BLACK) {
            name = 'B';
        }
        if (color== ChessColor.WHITE) {
            name = 'b';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();

        for(int i=1;x+i<8&&y+i<8;i++) {
            if (chessComponents[x + i][y+i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(x + i, y + i));
            }
            if (chessComponents[x + i][y+i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMove.add(new ChessboardPoint(x + i, y+i));
                break;
            }
            if (chessComponents[x + i][y+i].getChessColor() == super.getChessColor()) {
                break;
            }
        }

        for(int i=1;x+i<8&&y-i>=0;i++){
            if (chessComponents[x + i][y-i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(x + i, y - i));
            }
            if (chessComponents[x + i][y-i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMove.add(new ChessboardPoint(x + i, y-i));
                break;
            }
            if (chessComponents[x + i][y-i].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        for(int i=1;x-i>=0&&y+i<8;i++){
            if (chessComponents[x - i][y+i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(x - i, y + i));
            }
            if (chessComponents[x - i][y+i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMove.add(new ChessboardPoint(x - i, y+i));
                break;
            }
            if (chessComponents[x - i][y+i].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        for(int i=1;x-i>=0&&y-i>=0;i++){
            if (chessComponents[x - i][y-i] instanceof EmptySlotComponent) {
                canMove.add(new ChessboardPoint(x - i, y - i));
            }
            if (chessComponents[x - i][y-i].getChessColor() == reverseChessColor(super.getChessColor())) {
                canMove.add(new ChessboardPoint(x - i, y-i));
                break;
            }
            if (chessComponents[x - i][y-i].getChessColor() == super.getChessColor()) {
                break;
            }
        }
        canMove.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) return 1;
                if (o1.getX() == o2.getX()) {
                    if (o1.getY() > o2.getY()) return 1;
                    else return -1;
                } else return -1;
            }
        });
        return canMove;
    }


    public ChessColor reverseChessColor(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        }
        if (chessColor == ChessColor.WHITE) {
            return ChessColor.BLACK;
        } else {
            return ChessColor.NONE;
        }
    }
}
