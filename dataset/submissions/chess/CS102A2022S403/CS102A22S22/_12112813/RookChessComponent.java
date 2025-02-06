import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>(1);
        ChessboardPoint one = getChessboardPoint();
        ChessColor oppositeColor = ChessColor.NONE;
        if (this.getChessColor() == ChessColor.WHITE){
            oppositeColor = ChessColor.BLACK;
        }else if (this.getChessColor() == ChessColor.BLACK){
            oppositeColor = ChessColor.WHITE;
        }
//        for (int i = 1;i<=7;i++){
//            result.add(one.offset(i,0));
//            result.add(one.offset(-i,0));
//            result.add(one.offset(0,i));
//            result.add(one.offset(0,-i));
//        }
//        for (int i = 1;i<=7;i++){
//            if (one.offset(i,i)==null){
//                continue;
//            }
//            if (chessGame.getChess(one.offset(i,i)).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(i,i));
//            if (chessGame.getChess(one.offset(i,i)).getChessColor()==oppositeColor){
//                break;
//            }
//        }
        for (int i = 1;i<=7;i++){
            if (one.offset(i,0)==null){
                break;
            }
            if (chessGame.getChess(one.offset(i,0)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(i,0));
            if (chessGame.getChess(one.offset(i,0)).getChessColor() == oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(-i,0)==null){
                break;
            }
            if (chessGame.getChess(one.offset(-i,0)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(-i,0));
            if (chessGame.getChess(one.offset(-i,0)).getChessColor() == oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(0,i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(0,i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(0,i));
            if (chessGame.getChess(one.offset(0,i)).getChessColor() == oppositeColor){
                break;
            }
        }
        for (int i = 1;i<=7;i++){
            if (one.offset(0,-i)==null){
                break;
            }
            if (chessGame.getChess(one.offset(0,-i)).getChessColor() == this.getChessColor()){
                break;
            }
            result.add(one.offset(0,-i));
            if (chessGame.getChess(one.offset(0,-i)).getChessColor() == oppositeColor){
                break;
            }
        }
        return result;
    }

    public RookChessComponent(ChessColor chessColor) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('R');
        }else if (chessColor == ChessColor.WHITE){
            setName('r');
        }
        setChessColor(chessColor);
    }
    public RookChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('R');
        }else if (chessColor == ChessColor.WHITE){
            setName('r');
        }
        setSource(source);
        setChessColor(chessColor);
    }
}
