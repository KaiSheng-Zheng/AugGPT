import java.util.*;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>move= new ArrayList<>();
        int a = getSource().getX();
        int b = getSource().getY();
        for(int i=-1;i<=1;i++) {
            for (int j = -1; j <= 1; j++) {
                if(a+i>=0&&a+i<=7&&b+j<=7&&b+j>=0){
                    ChessComponent chess = chessboard[a+i][b+j];
                    boolean check = chess instanceof EmptySlotComponent;
                    if(check){
                        move.add(new ChessboardPoint(chess.getSource().getX(),chess.getSource().getY()));
                    }
                }
            }
        }
        return move;
    }
}