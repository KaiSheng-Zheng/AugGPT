import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>(0);
        ChessboardPoint one = getChessboardPoint();
        ChessColor oppositeColor = ChessColor.NONE;
        if (getChessColor() == ChessColor.BLACK){
            oppositeColor = ChessColor.WHITE;
        }else if (getChessColor() == ChessColor.WHITE){
            oppositeColor = ChessColor.BLACK;
        }
//        for (int i = 1;i<=7;i++){
//            result.add(one.offset(i,0));
//            result.add(one.offset(-i,0));
//            result.add(one.offset(0,i));
//            result.add(one.offset(0,-i));
//
//            result.add(one.offset(i,i));
//            result.add(one.offset(i,-i));
//            result.add(one.offset(-i,i));
//            result.add(one.offset(-i,-i));
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()+i, getChessboardPoint().getY()+0).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(i,0));
//            if (chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()+0).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(-i,0));
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()+0).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()+0,getChessboardPoint().getY()+i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(0,i));
//            if (chessGame.getChess(getChessboardPoint().getX()+0,getChessboardPoint().getY()+i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()+0,getChessboardPoint().getY()-i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(0,-i));
//            if (chessGame.getChess(getChessboardPoint().getX()+0,getChessboardPoint().getY()-i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(i,i));
//            if (chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()+i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(-i,i));
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()+i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()-i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(-i,-i));
//            if (chessGame.getChess(getChessboardPoint().getX()-i,getChessboardPoint().getY()-i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
//                break;
//            }
//        }
//        for (int i = 1;i<=7;i++){
//            if (chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()-i).getChessColor() == this.getChessColor()){
//                break;
//            }
//            result.add(one.offset(i,-i));
//            if (chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()-i).getChessColor() != ChessColor.NONE && chessGame.getChess(getChessboardPoint().getX()+i,getChessboardPoint().getY()+0).getChessColor() != this.getChessColor()){
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

    public QueenChessComponent() {
    }
    public QueenChessComponent(ChessColor chessColor) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('Q');
        }else if (chessColor == ChessColor.WHITE){
            setName('q');
        }
        setChessColor(chessColor);
    }
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK){
            setName('Q');
        }else if (chessColor == ChessColor.WHITE){
            setName('q');
        }
        setChessColor(chessColor);
        setSource(source);
    }
}
