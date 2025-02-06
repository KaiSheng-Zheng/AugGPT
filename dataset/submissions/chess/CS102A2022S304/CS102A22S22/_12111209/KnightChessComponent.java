import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        int row = source.getX();
        int column = source.getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (row + 1 < 8 && column + 2 < 8 && row + 1 > -1 && column + 2 > -1) {
            if (chessComponents[row + 1][column + 2].getChessColor() == chessComponents[row][column].getChessColor()) {

            } else {
                canMoveTo.add(new ChessboardPoint(row + 1, column + 2));
            }
        }
        if (row + 1 < 8 && column - 2 < 8 && row + 1 > -1 && column - 2 > -1) {
            if(chessComponents[row+1][column-2].getChessColor() == chessComponents[row][column].getChessColor()){

            }else {
                canMoveTo.add(new ChessboardPoint(row+1, column-2));
            }
        }
        if (row + 2 < 8 && column + 1 < 8 && row + 2 > -1 && column + 1 > -1) {
            if(chessComponents[row+2][column+1].getChessColor() == chessComponents[row][column].getChessColor()){

            }
        else {
                canMoveTo.add(new ChessboardPoint(row+2, column+1));
            }
        }
        if (row + 2 < 8 && column - 1 < 8 && row + 2 > -1 && column - 1 > -1) {
            if(chessComponents[row+2][column-1].getChessColor() == chessComponents[row][column].getChessColor()){

            }
            else {
                canMoveTo.add(new ChessboardPoint(row+2, column-1));
            }
        }
        if (row - 1 < 8 && column + 2 < 8 && row - 1 > -1 && column + 2 > -1) {
            if(chessComponents[row-1][column+2].getChessColor() == chessComponents[row][column].getChessColor()){

            }
            else {
                canMoveTo.add(new ChessboardPoint(row-1, column+2));
            }
        }
        if (row - 1 < 8 && column - 2 < 8 && row - 1 > -1 && column - 2 > -1) {
            if(chessComponents[row-1][column-2].getChessColor() == chessComponents[row][column].getChessColor()){

            }
            else {
                canMoveTo.add(new ChessboardPoint(row-1, column-2));
            }
        }
        if (row - 2 < 8 && column + 1 < 8 && row - 2 > -1 && column + 1 > -1) {
            if(chessComponents[row-2][column+1].getChessColor() == chessComponents[row][column].getChessColor()){

            }else {
                canMoveTo.add(new ChessboardPoint(row-2, column+1));
            }
        }
        if (row - 2 < 8 && column - 1 < 8 && row - 2 > -1 && column - 1 > -1) {
            if(chessComponents[row-2][column-1].getChessColor() == chessComponents[row][column].getChessColor()){

            }
            else {
                canMoveTo.add(new ChessboardPoint(row-2, column-1));
            }
        }
        return canMoveTo;
    }
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if (this.getChessColor()==chessColor.WHITE){
            this.setName('n');
        }else{
            this.setName('N');
        }
    }
}
