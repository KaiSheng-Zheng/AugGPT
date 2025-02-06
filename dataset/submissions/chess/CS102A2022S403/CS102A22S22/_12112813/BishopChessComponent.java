import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessColor chessColor) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('B');
        }else if (chessColor == ChessColor.WHITE){
            setName('b');
        }
        setChessColor(chessColor);
    }
    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if (chessColor == ChessColor.BLACK){
            setName('B');
        }else if (chessColor == ChessColor.WHITE){
            setName('b');
        }
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint one = getChessboardPoint();
        ChessColor oppositeColor = ChessColor.NONE;
        if (this.getChessColor() == ChessColor.WHITE){
            oppositeColor = ChessColor.BLACK;
        }else if (this.getChessColor() == ChessColor.BLACK){
            oppositeColor = ChessColor.WHITE;
        }
//        for (int i = 1;i<=7;i++){
//            result.add(one.offset(i,i));
//            result.add(one.offset(i,-i));
//            result.add(one.offset(-i,i));
//            result.add(one.offset(-i,-i));
//        }
        for (int i = 1;i<=7;i++){
            if (one.offset(i,i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(i,i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(i,i));
            if (chessGame.getChess(one.offset(i,i)).getChessColor()==oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(-i,i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(-i,i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(-i,i));
            if (chessGame.getChess(one.offset(-i,i)).getChessColor() ==oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(-i,-i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(-i,-i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(-i,-i));
            if (chessGame.getChess(one.offset(-i,-i)).getChessColor() ==oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(i,-i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(i,-i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(i,-i));
            if (chessGame.getChess(one.offset(i,-i)).getChessColor() ==oppositeColor){
                break;
            }
        }
        return result;
    }

}
