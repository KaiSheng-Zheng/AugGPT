import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor) {
      this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('N');
        }else if (chessColor == ChessColor.WHITE){
            setName('n');
        }
        setChessColor(chessColor);
    }
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('N');
        }else if (chessColor == ChessColor.WHITE){
            setName('n');
        }
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>(0);
        if (valid(1,2)!=null){
            result.add(valid(1,2));
        }
        if (valid(-1,2)!=null){
            result.add(valid(-1,2));
        }
        if (valid(-2,1)!=null){
            result.add(valid(-2,1));
        }
        if (valid(-2,-1)!=null){
            result.add(valid(-2,-1));
        }
        if (valid(-1,-2)!=null){
            result.add(valid(-1,-2));
        }
        if (valid(1,-2)!=null){
            result.add(valid(1,-2));
        }
        if (valid(2,-1)!=null){
            result.add(valid(2,-1));
        }
        if (valid(2,1)!=null){
            result.add(valid(2,1));
        }
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(1,2);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(-1,2);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(-2,1);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(-2,-1);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(-1,-2);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(1,-2);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
//        a=getChessboardPoint().offset(2,-1);
//        if (chessGame.getChess(a.getX(),a.getY()).getChessColor() != this.getChessColor()){
//            result.add(a);
//        }
        return result;
    }
    private ChessboardPoint valid(int x,int y){
        if (getChessboardPoint().offset(x, y)!=null){
            if (chessGame.getChess(getChessboardPoint().offset(x, y)).getChessColor()!=this.getChessColor()){
                return getChessboardPoint().offset(x, y);
            }else return null;
        }else return null;
    }
//        if (one.offset(i,i)==null){
//            break;
//        }
//        if (chessGame.getChess(one.offset(i,i)).getChessColor() == this.getChessColor()){
//            break;
//        }
//        result.add(one.offset(i,i));
//        if (chessGame.getChess(one.offset(i,i)).getChessColor()==oppositeColor){
//            break;
//        }

}
