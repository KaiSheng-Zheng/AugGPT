import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> tmp = new ArrayList<>();
        int tmpY = getSource().getY();
        int tmpX = getSource().getX();
        if (getChessColor() == ChessColor.BLACK){
            if (tmpX == 1 ){
                if (boundary(tmpX+2,tmpY) && chessComponents[tmpX+2][tmpY].name == '_' && chessComponents[tmpX+1][tmpY].name == '_' ){
                    tmp.add(new ChessboardPoint(tmpX+2,tmpY));
                }
            }
            if (boundary(tmpX+1,tmpY) && chessComponents[tmpX+1][tmpY].name =='_'){
                tmp.add(new ChessboardPoint(tmpX+1,tmpY));
            }
            if (boundary(tmpX+1,tmpY+1) && chessComponents[tmpX+1][tmpY+1].getChessColor() == ChessColor.WHITE){
                tmp.add(new ChessboardPoint(tmpX+1,tmpY+1));
            }
            if (boundary(tmpX+1,tmpY -1) && chessComponents[tmpX+1][tmpY-1].getChessColor() == ChessColor.WHITE){
                tmp.add(new ChessboardPoint(tmpX+1,tmpY-1));
            }
        }
        if (getChessColor() == ChessColor.WHITE){
            if (tmpX == 6 ){
                if (boundary(tmpX-2,tmpY) && chessComponents[tmpX-2][tmpY].name == '_' && chessComponents[tmpX-1][tmpY].name == '_' ){
                    tmp.add(new ChessboardPoint(tmpX-2,tmpY));
                }
            }
            if (boundary(tmpX-1,tmpY) && chessComponents[tmpX-1][tmpY].name =='_'){
                tmp.add(new ChessboardPoint(tmpX-1,tmpY));
            }
            if (boundary(tmpX-1,tmpY-1) && chessComponents[tmpX-1][tmpY-1].getChessColor() == ChessColor.BLACK){
                tmp.add(new ChessboardPoint(tmpX-1,tmpY-1));
            }
            if (boundary(tmpX-1, tmpY+1) && chessComponents[tmpX-1][tmpY+1].getChessColor() == ChessColor.BLACK){
                tmp.add(new ChessboardPoint(tmpX-1,tmpY+1));
            }
        }
        if (tmp.isEmpty()){
           return new ArrayList<>();
        }
        return tmp;
    }

}
