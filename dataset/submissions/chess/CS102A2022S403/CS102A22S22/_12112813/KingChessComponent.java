import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor) {
        if (chessColor == ChessColor.BLACK){
            setName('K');
        }else if (chessColor == ChessColor.WHITE){
            setName('k');
        }
        setChessColor(chessColor);
    }
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if (chessColor == ChessColor.BLACK){
            setName('K');
        }else if (chessColor == ChessColor.WHITE){
            setName('k');
        }
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>(0);
        ChessColor oppositeColor = ChessColor.NONE;
        if (getChessColor() == ChessColor.BLACK){
            oppositeColor = ChessColor.WHITE;
        }else if (getChessColor() == ChessColor.WHITE){
            oppositeColor = ChessColor.BLACK;
        }
        ChessboardPoint one = getChessboardPoint();
//        result.add(getChessboardPoint().offset(1,0));
//        result.add(getChessboardPoint().offset(1,1));
//        result.add(getChessboardPoint().offset(0,1));
//        result.add(getChessboardPoint().offset(-1,1));
//        result.add(getChessboardPoint().offset(-1,0));
//        result.add(getChessboardPoint().offset(-1,-1));
//        result.add(getChessboardPoint().offset(0,-1));
//        result.add(getChessboardPoint().offset(1,-1));
//        if (one.offset(0,-i)==null){
//            break;
//        }
//        if (chessGame.getChess(one.offset(0,-i)).getChessColor() == this.getChessColor()){
//            break;
//        }
//        result.add(one.offset(0,-i));
//        if (chessGame.getChess(one.offset(0,-i)).getChessColor() == oppositeColor){
//            break;
        if (valid(1,0)!=null){
            result.add(valid(1,0));
        }
        if (valid(1,1)!=null){
            result.add(valid(1,1));
        }
        if (valid(0,1)!=null){
            result.add(valid(0,1));
        }
        if (valid(-1,1)!=null){
            result.add(valid(-1,1));
        }
        if (valid(-1,0)!=null){
            result.add(valid(-1,0));
        }
        if (valid(-1,-1)!=null){
            result.add(valid(-1,-1));
        }
        if (valid(0,-1)!=null){
            result.add(valid(0,-1));
        }
        if (valid(1,-1)!=null){
            result.add(valid(1,-1));
        }
        return result;
    }
    private ChessboardPoint valid(int x, int y){
        ChessboardPoint result = null;
        if (getChessboardPoint().offset(x,y)!=null){
            if (chessGame.getChess(getChessboardPoint().offset(x,y)).getChessColor() != getChessColor()){
                result = getChessboardPoint().offset(x,y);
            }
        }
        return result;
    }
}
