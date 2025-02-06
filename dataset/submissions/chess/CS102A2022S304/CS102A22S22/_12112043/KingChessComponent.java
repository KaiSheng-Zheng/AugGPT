import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        int row = source.getX();
        int col = source.getY();
        List<ChessboardPoint> can = new ArrayList<>();
                if (source.getX() >= 0 && source.getX() < 8 && source.getY() >= 0 && source.getY() < 8) {
                    if (row!=0) {
                        if (chessboard[row - 1][col].chessColor != getChessColor()) {
                            ChessboardPoint destination1 = new ChessboardPoint(row - 1, col);
                            can.add(destination1);
                        }
                    }
                    if (row != 7) {
                        if (chessboard[row + 1][col].chessColor != getChessColor()) {
                        ChessboardPoint destination2 = new ChessboardPoint(row + 1, col);
                        can.add(destination2);
                    }
                    }
                    if (col!=7){
                    if (chessboard[row ][col+1].chessColor != getChessColor()) {
                        ChessboardPoint destination3 = new ChessboardPoint(row , col+1);
                        can.add(destination3);
                    }
                    }if (col!=0){
                    if (chessboard[row][col-1].chessColor != getChessColor()) {
                        ChessboardPoint destination4 = new ChessboardPoint(row , col-1);
                        can.add(destination4);
                    }
                    }
                    if (row!=0&&col!=0){
                    if (chessboard[row - 1][col - 1].chessColor != getChessColor()) {
                        ChessboardPoint destination5 = new ChessboardPoint(row-1, col - 1);
                        can.add(destination5);
                    }
                    }if (row!=0&&col!=7){
                    if (chessboard[row - 1][col+1].chessColor != getChessColor()) {
                        ChessboardPoint destination6 = new ChessboardPoint(row - 1, col+1);
                        can.add(destination6);
                    }
                    }
                    if (row!=7&&col!=7){
                    if (chessboard[row + 1][col+1].chessColor != getChessColor()) {
                        ChessboardPoint destination7 = new ChessboardPoint(row + 1, col+1);
                        can.add(destination7);
                    }
                    }if (row!=7&&col!=0){
                    if (chessboard[row + 1][col-1].chessColor != getChessColor()) {
                        ChessboardPoint destination8 = new ChessboardPoint(row + 1, col-1);
                        can.add(destination8);
                    }
                    }
                }
        if (can != null) {
            return can;
        } else {
            return new ArrayList<>();
        }
    }
}
