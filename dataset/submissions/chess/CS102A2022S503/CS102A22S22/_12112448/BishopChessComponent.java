import java.util.*;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int a = getSource().getX();
        int b = getSource().getY();
        for (int i = 1; i <= 7; i++) {
            if (a + i >= 0 && a + i <= 7 && b + i <= 7 && b + i >= 0) {
                ChessComponent chess = chessboard[i + a][b + i];
                boolean check = chess instanceof EmptySlotComponent;
                if (check) {
                    move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                }
                else{
                    if(this.getChessColor()!=chess.getChessColor()){
                        move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }

        for (int i = 1; i <= 7; i++) {
            if (a + i >= 0 && a + i <= 7 && b - i<= 7 && b - i>= 0) {
                ChessComponent chess= chessboard[a+i][b-i];
                boolean check = chess instanceof EmptySlotComponent;
                if (check) {
                    move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                }
                else{
                    if(this.getChessColor()!=chess.getChessColor()){
                        move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (a - i >= 0 && a - i <= 7 && b + i<= 7 && b + i>= 0) {
                ChessComponent chess = chessboard[-i + a][b + i];
                boolean check = chess instanceof EmptySlotComponent;
                if (check) {
                    move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                }
                else{
                    if(this.getChessColor()!=chess.getChessColor()){
                        move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (a - i >= 0 && a - i <= 7 && b - i<= 7 && b - i>= 0) {
                ChessComponent chess = chessboard[-i + a][b - i];
                boolean check = chess instanceof EmptySlotComponent;
                if (check) {
                    move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                }
                else{
                    if(this.getChessColor()!=chess.getChessColor()){
                        move.add(new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY()));
                    }
                    break;
                }
            }
            else{
                break;
            }
        }
        move.sort(Comparator.comparing(ChessboardPoint::getY));
        move.sort(Comparator.comparing(ChessboardPoint::getX));

        return move;
    }
}

