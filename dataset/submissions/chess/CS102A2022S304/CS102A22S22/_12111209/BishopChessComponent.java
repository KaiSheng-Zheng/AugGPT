import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        if(source!=null) {
            int row = source.getX();
            int column = source.getY();
            List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
            for (int i = 1; i < 8; i++) {
                if (row + i < 8 && row + i > -1 && column + i < 8 && column + i > -1) {
                    if (chessComponents[row + i][column + i] instanceof EmptySlotComponent) {
                        canMoveTo.add(new ChessboardPoint(row + i, column + i));
                    } else {
                        if (chessComponents[row + i][column + i].getChessColor() == chessComponents[row][column].getChessColor()) {
                            break;
                        }
                        if (chessComponents[row + i][column + i].getChessColor() != chessComponents[row][column].getChessColor()) {
                            canMoveTo.add(new ChessboardPoint(row + i, column + i));
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (row + i < 8 && row + i > -1 && column - i < 8 && column - i > -1) {
                    if (chessComponents[row + i][column - i] instanceof EmptySlotComponent) {
                        canMoveTo.add(new ChessboardPoint(row + i, column - i));
                    } else {
                        if (chessComponents[row + i][column - i].getChessColor() == chessComponents[row][column].getChessColor()) {
                            break;
                        }
                        if (chessComponents[row + i][column - i].getChessColor() != chessComponents[row][column].getChessColor()) {
                            canMoveTo.add(new ChessboardPoint(row + i, column - i));
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (row - i < 8 && row - i > -1 && column - i < 8 && column - i > -1) {
                    if (chessComponents[row - i][column - i] instanceof EmptySlotComponent) {
                        canMoveTo.add(new ChessboardPoint(row - i, column - i));
                    } else {
                        if (chessComponents[row - i][column - i].getChessColor() == chessComponents[row][column].getChessColor()) {
                            break;
                        }
                        if (chessComponents[row - i][column - i].getChessColor() != chessComponents[row][column].getChessColor()) {
                            canMoveTo.add(new ChessboardPoint(row - i, column - i));
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (row - i < 8 && row - i > -1 && column + i < 8 && column + i > -1) {
                    if (chessComponents[row - i][column + i] instanceof EmptySlotComponent) {
                        canMoveTo.add(new ChessboardPoint(row - i, column + i));
                    } else {
                        if (chessComponents[row - i][column + i].getChessColor() == chessComponents[row][column].getChessColor()) {
                            break;
                        }
                        if (chessComponents[row - i][column + i].getChessColor() != chessComponents[row][column].getChessColor()) {
                            canMoveTo.add(new ChessboardPoint(row - i, column + i));
                            break;
                        }
                    }
                }
            }
            return canMoveTo;
        }
        else {
            return new ArrayList<>();
        }
    }
    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if (this.getChessColor()==chessColor.WHITE){
            this.setName('b');
        }else{
            this.setName('B');
        }
    }
}
