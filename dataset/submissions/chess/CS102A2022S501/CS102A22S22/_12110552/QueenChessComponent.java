import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source, chessColor, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Move = new ArrayList<>();
        for (int i = 1; i + source.getX() < 8 && 0 <= i + source.getX() && i + source.getY() < 8 && 0 <= i + source.getY(); i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() + i, source.getY() + i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + i][source.getY() + i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; source.getX() - i < 8 && 0 <= source.getX() - i &&  source.getY() - i < 8 && 0 <= source.getY() - i; i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() - i, source.getY() - i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - i][source.getY() - i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; i + source.getX() < 8 && 0 <= i + source.getX() && source.getY() - i < 8 && 0 <= source.getY() - i; i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() + i, source.getY() - i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + i][source.getY() - i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; source.getX() - i < 8 && 0 <= source.getX() - i && i + source.getY() < 8 && 0 <= i + source.getY(); i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() - i, source.getY() + i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - i][source.getY() + i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; i + source.getX() < 8 && 0 <= i + source.getX(); i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() + i, source.getY());
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + i][source.getY()].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; source.getX() - i  < 8 && 0 <= source.getX() - i ; i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX() - i, source.getY());
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - i][source.getY()].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; i + source.getY() < 8 && 0 <= i + source.getY(); i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX(), source.getY() + i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX()][source.getY() + i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }
        for (int i = 1; source.getY() - i  < 8 && 0 <= source.getY() - i ; i++) {
            ChessboardPoint destination = new ChessboardPoint(source.getX(), source.getY() - i);
            if(destination != null){
                if((chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX()][source.getY() - i].getChessColor())){
                    Move.add(destination);
                }
            }
            else{
                Move.add(destination);
            }
        }


        if(Move.isEmpty()){
            return new ArrayList<>();
        }else{
            return Move;
        }

    }
    public static ChessColor color;


}
