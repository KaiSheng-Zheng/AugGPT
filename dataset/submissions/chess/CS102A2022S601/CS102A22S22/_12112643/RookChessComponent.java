import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
   // private ChessboardPoint source;
    //private ChessColor chessColor;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame board){
//        this.name = name;
//        this.setSource(source);
//        this.setChessColor(chessColor);
//        this.board = board;
        super(source,chessColor,name,board);
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(i,0)) == null){
                break;
            }
            list.add(getSource().offset(i,0));
            if (hasOpponentChess(getSource().offset(i,0))){
                break;
            }
        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(0,-i)) == null){
                break;
            }
            list.add(getSource().offset(0,-i));
            if (hasOpponentChess(getSource().offset(0,-i))){
                break;
            }

        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(0,i)) == null){
                break;
            }
            list.add(getSource().offset(0,i));
            if (hasOpponentChess(getSource().offset(0,i))){
                break;
            }
        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(-i,0)) == null){
                break;
            }
            list.add(getSource().offset(-i,0));
            if (hasOpponentChess(getSource().offset(-i,0))){
                break;
            }
        }
        return list;

    }
}
