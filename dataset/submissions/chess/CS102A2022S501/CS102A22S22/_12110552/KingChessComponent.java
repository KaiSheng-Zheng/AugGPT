import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source, chessColor, name);
    }

    public KingChessComponent() {
    }
    private ChessboardPoint source;
    
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Move = new ArrayList<>();
        ChessComponent[][] chessboard = getChessboard() ;
        if (0 <= source.getX() - 1){
            if (chessboard[source.getX()-1][source.getY()].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 1][source.getY()].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() -1, source.getY()));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() -1, source.getY()));
            }

        }
        if (0 <= source.getY() - 1){
            if (chessboard[source.getX()][source.getY() - 1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX()][source.getY() - 1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX(), source.getY() - 1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX(), source.getY() - 1));
            }

        }
        if ( source.getX() + 1 <= 7){
            if (chessboard[source.getX()+1][source.getY()].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 1][source.getY()].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() +1, source.getY()));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() +1, source.getY()));
            }

        }
        if (source.getY() + 1 <= 7){
            if (chessboard[source.getX()][source.getY() + 1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX()][source.getY() + 1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX(), source.getY() + 1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX(), source.getY() + 1));
            }

        }
        if (0 <= source.getX() - 1 && 0 <= source.getY() - 1){
            if (chessboard[source.getX()-1][source.getY() - 1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 1][source.getY() - 1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() -1, source.getY() - 1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() -1, source.getY() - 1));
            }

        }
        if (0 <= source.getX() - 1 && source.getY() + 1 <= 7){
            if (chessboard[source.getX()-1][source.getY()+1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() - 1][source.getY()+1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() -1, source.getY() + 1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() -1, source.getY() + 1));
            }

        }
        if (source.getX() + 1 <= 7 && source.getY() + 1 <= 7){
            if (chessboard[source.getX()+1][source.getY()+1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 1][source.getY() +1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() +1, source.getY()+1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() +1, source.getY()+1));
            }

        }
        if (0 <= source.getY() - 1 && source.getX() + 1 <= 7){
            if (chessboard[source.getX()+1][source.getY()-1].getChessColor() != ChessColor.NONE) {
                if (chessboard[source.getX()][source.getY()].getChessColor() != chessboard[source.getX() + 1][source.getY()-1].getChessColor()) {
                    Move.add(new ChessboardPoint(source.getX() +1, source.getY()-1));
                }
            }else{
                Move.add(new ChessboardPoint(source.getX() +1, source.getY()-1));
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
