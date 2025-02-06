import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        if(source!=null) {
            int row = source.getX();
            int column = source.getY();
            List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
            if (row + 1 < 8 && column + 1 < 8 && row + 1 > -1 && column + 1 > -1) {
                if (chessComponents[row + 1][column + 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row + 1, column + 1));
                }
            }
            if (row + 1 < 8 && column < 8 && row + 1 > -1 && column > -1) {
                if (chessComponents[row + 1][column].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row + 1, column));
                }
            }
            if (row + 1 < 8 && column - 1 < 8 && row + 1 > -1 && column - 1 > -1) {
                if (chessComponents[row + 1][column - 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row + 1, column - 1));
                }
            }
            if (row < 8 && column + 1 < 8 && row > -1 && column + 1 > -1) {
                if (chessComponents[row][column + 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row, column + 1));
                }
            }
            if (row < 8 && column - 1 < 8 && row > -1 && column - 1 > -1) {
                if (chessComponents[row][column - 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row, column - 1));
                }
            }
            if (row - 1 < 8 && column + 1 < 8 && row - 1 > -1 && column + 1 > -1) {
                if (chessComponents[row - 1][column + 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row - 1, column + 1));
                }
            }
            if (row - 1 < 8 && column < 8 && row - 1 > -1 && column > -1) {
                if (chessComponents[row - 1][column].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row - 1, column));
                }
            }
            if (row - 1 < 8 && column - 1 < 8 && row - 1 > -1 && column - 1 > -1) {
                if (chessComponents[row - 1][column - 1].getChessColor() == chessComponents[row][column].getChessColor()) {

                } else {
                    canMoveTo.add(new ChessboardPoint(row - 1, column - 1));
                }
            }
            return canMoveTo;
        }
        else {
            return new ArrayList<>();
        }
    }
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if (this.getChessColor()==chessColor.WHITE){
            this.setName('k');
        }else{
            this.setName('K');
        }
    }
}
