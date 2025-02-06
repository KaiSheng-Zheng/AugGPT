
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int a = getSource().getX();
        int b = getSource().getY();
        if (a + 2 <= 7) {
            if (b - 1 >= 0) {
                ChessComponent chess = chessboard[a + 2][b - 1];
                boolean check = chess instanceof EmptySlotComponent;
                if (check) {
                    move.add(new ChessboardPoint(a + 2, b - 1));
                } else {
                    if (chess.getChessColor() != this.getChessColor()) {
                        move.add(new ChessboardPoint(a + 2, b - 1));
                    }
                }
            }
            if (b + 1 <= 7) {
                ChessComponent chess = chessboard[a + 2][b + 1];
                boolean check = chess instanceof EmptySlotComponent;
                ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                if (check) {
                    move.add(point);
                } else {
                    if (chess.getChessColor() != this.getChessColor()) {
                        move.add(point);
                    }
                }
            }
            if (a - 2 >= 0) {
                if (b - 1 >= 0) {
                    ChessComponent chess = chessboard[a - 2][b - 1];
                    boolean check = chess instanceof EmptySlotComponent;
                    if (check) {
                        move.add(new ChessboardPoint(a - 2, b - 1));
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(new ChessboardPoint(a - 2, b - 1));
                        }
                    }
                }
                if (b + 1 <= 7) {
                    ChessComponent chess = chessboard[a - 2][b + 1];
                    boolean check = chess instanceof EmptySlotComponent;
                    ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                    if (check) {
                        move.add(point);
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(point);
                        }
                    }
                }
            }
            if(a+1<=7){
                if (b + 2 <= 7) {
                    ChessComponent chess = chessboard[a+1][b + 2];
                    boolean check = chess instanceof EmptySlotComponent;
                    ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                    if (check) {
                        move.add(point);
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(point);
                        }
                    }
                }
                if (b-2>=0) {
                    ChessComponent chess = chessboard[a +1][b-2];
                    boolean check = chess instanceof EmptySlotComponent;
                    ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                    if (check) {
                        move.add(point);
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(point);
                        }
                    }
                }
            }
            if(a-1>=0){
                if (b + 2 <= 7) {
                    ChessComponent chess = chessboard[a - 1][b + 2];
                    boolean check = chess instanceof EmptySlotComponent;
                    ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                    if (check) {
                        move.add(point);
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(point);
                        }
                    }
                }
                if (b -2 <= 7) {
                    ChessComponent chess = chessboard[a - 1][b-2];
                    boolean check = chess instanceof EmptySlotComponent;
                    ChessboardPoint point = new ChessboardPoint(chess.getSource().getX(), chess.getSource().getY());
                    if (check) {
                        move.add(point);
                    } else {
                        if (chess.getChessColor() != this.getChessColor()) {
                            move.add(point);
                        }
                    }
                }
            }
        }
        move.sort(Comparator.comparing(ChessboardPoint::getY));
        move.sort(Comparator.comparing(ChessboardPoint::getX));
            return move;
    }
}
