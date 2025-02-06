import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        if(source!=null) {
            int row = source.getX();
            int column = source.getY();
            List<ChessboardPoint> canMoveTo = new ArrayList<>();
            for (int i = row + 1; i < 8; i++) {
                if (chessComponents[i][column] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(i, column));
                } else {
                    if (chessComponents[i][column].getChessColor() == chessComponents[row][column].getChessColor()) {
                        break;
                    }

                    if (chessComponents[i][column].getChessColor() != chessComponents[row][column].getChessColor()) {
                        canMoveTo.add(new ChessboardPoint(i, column));
                        break;
                    }
                }
            }

            for (int i = row - 1; i > -1; i--) {
                if (chessComponents[i][column] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(i, column));
                } else {
                    if (chessComponents[i][column].getChessColor() == chessComponents[row][column].getChessColor()) {
                        break;
                    }
                    if (chessComponents[i][column].getChessColor() != chessComponents[row][column].getChessColor()) {
                        canMoveTo.add(new ChessboardPoint(i, column));
                        break;
                    }
                }
            }

            for (int i = column + 1; i < 8; i++) {
                if (chessComponents[row][i] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(row, i));
                } else {
                    if (chessComponents[row][i].getChessColor() == chessComponents[row][column].getChessColor()) {
                        break;
                    }
                    if (chessComponents[row][i].getChessColor() != chessComponents[row][column].getChessColor()) {
                        canMoveTo.add(new ChessboardPoint(row, i));
                        break;
                    }
                }
            }

            for (int i = column - 1; i > -1; i--) {
                if (chessComponents[row][i] instanceof EmptySlotComponent) {
                    canMoveTo.add(new ChessboardPoint(row, i));
                } else {
                    if (chessComponents[row][i].getChessColor() == chessComponents[row][column].getChessColor()) {
                        break;
                    }
                    if (chessComponents[row][i].getChessColor() != chessComponents[row][column].getChessColor()) {
                        canMoveTo.add(new ChessboardPoint(row, i));
                        break;
                    }
                }
            }
            return canMoveTo;
        }
        else {
            return new ArrayList<>();
        }
    }

    public RookChessComponent(ChessColor chessColor,ChessboardPoint source){
        this.setChessColor(chessColor);
        this.setSource(source);
        if (this.getChessColor()==chessColor.WHITE){
            this.setName('r');

        }else{
            this.setName('R');
        }
    }


}
