
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>move= new ArrayList<>();
        int a = getSource().getX();
        int b = getSource().getY();
        for(int i=1;a+i<=7;i++){
            ChessComponent chess = chessboard[a+i][b];
            boolean check = chess instanceof EmptySlotComponent;
            if(check){
                move.add(new ChessboardPoint(a+i,b));
            }
            else{
                if(chess.getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(a+i,b));
                }
                break;
            }
        }
        for(int i=1;a-i>=0;i++){
            ChessComponent chess = chessboard[a-i][b];
            boolean check = chess instanceof EmptySlotComponent;
            if(check){
                move.add(new ChessboardPoint(a-i,b));
            }
            else{
                if(chess.getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(a-i,b));
                }
                break;
            }
        }
        for(int i=1;b+i<=7;i++){
            ChessComponent chess = chessboard[a][b+i];
            boolean check = chess instanceof EmptySlotComponent;
            if(check){
                move.add(new ChessboardPoint(a,b+i));
            }
            else{
                if(chess.getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(a,b+i));
                }
                break;
            }
        }
        for(int i=1;b-i>=0;i++){
            ChessComponent chess = chessboard[a][b-i];
            boolean check = chess instanceof EmptySlotComponent;
            if(check){
                move.add(new ChessboardPoint(a,b-i));
            }
            else{
                if(chess.getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(a,b-i));
                }
                break;
            }
        }
        move.sort(Comparator.comparing(ChessboardPoint::getY));
        move.sort(Comparator.comparing(ChessboardPoint::getX));
        return move;
    }
}
