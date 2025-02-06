import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    //private ChessboardPoint source;
   // private ChessColor chessColor;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ConcreteChessGame board){
//        this.name = name;
//        this.setSource(source);
//        this.setChessColor(chessColor);
//        this.board = board;
        super(source,chessColor,name,board);
    }
    public List<ChessboardPoint> canMoveTo() {
//        List<ChessboardPoint> list = new ArrayList<ChessboardPoint>();
//        for (int i=1; i<= 7- getSource().getX(); i++){
//            if(getSource().offset(i,i) != null){
//                list.add(getSource().offset(i,i));
//            }
//        }
//        for (int i=1; getSource().getX()-i>=0; i++){
//            if (getSource().offset(-i, -i) != null){
//                list.add(getSource().offset(-i, -i));
//            }
//        }
//        for (int i=1; i<= 7- getSource().getX(); i++){
//            if(getSource().offset(i,-i) != null){
//                list.add(getSource().offset(i,-i));
//            }
//        }
//        for (int i=1; getSource().getX()-i>=0; i++){
//            if (getSource().offset(-i, i) != null){
//                list.add(getSource().offset(-i, i));
//            }
//        }
//        return list;
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(i,i)) == null){
                break;
            }
            list.add(getSource().offset(i,i));
            if (hasOpponentChess(getSource().offset(i,i))){
                break;
            }
        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(i,-i)) == null){
                break;
            }
            list.add(getSource().offset(i,-i));
            if (hasOpponentChess(getSource().offset(i,-i))){
                break;
            }

        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(-i,-i)) == null){
                break;
            }
            list.add(getSource().offset(-i,-i));
            if (hasOpponentChess(getSource().offset(-i,-i))){
                break;
            }
        }
        for (int i = 1; i < 8; i++){
            if (canStep(getSource().offset(-i,i)) == null){
                break;
            }
            list.add(getSource().offset(-i,i));
            if (hasOpponentChess(getSource().offset(-i,i))){
                break;
            }
        }
        return list;
    }
}
