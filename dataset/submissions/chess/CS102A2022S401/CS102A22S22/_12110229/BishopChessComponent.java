import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor,name);
    }

    @Override
    public  List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> tmp = new ArrayList<>();
        int tmpY = getSource().getY();
        int tmpX = getSource().getX();

        for (int i=1;i<8;i++){
            if (boundary(tmpX-i,tmpY-i) ){
                if (checkChess(tmpX-i,tmpY-i,getChessColor())){
                    tmp.add(new ChessboardPoint(tmpX-i,tmpY-i));
                }
                if(chessComponents[tmpX-i][tmpY-i].name != '_' ){
                    break;
                }
            }
        }

        for (int i=1;i<8;i++){
            if (boundary(tmpX-i,tmpY+i) ){
                if (checkChess(tmpX-i,tmpY+i,getChessColor())){
                    tmp.add(new ChessboardPoint(tmpX-i,tmpY+i));
                }
                if(chessComponents[tmpX-i][tmpY+i].name != '_' ){
                    break;
                }
            }
        }

        for (int i=1;i<8;i++){
            if (boundary(tmpX+i,tmpY-i) ){
                if (checkChess(tmpX+i,tmpY-i,getChessColor())){
                    tmp.add(new ChessboardPoint(tmpX+i,tmpY-i));
                }
                if(chessComponents[tmpX+i][tmpY-i].name != '_' ){
                    break;
                }
            }
        }

        for (int i=1;i<8;i++){
            if (boundary(tmpX+i,tmpY+i) ){
                if (checkChess(tmpX+i,tmpY+i,getChessColor())){
                    tmp.add(new ChessboardPoint(tmpX+i,tmpY+i));
                }
                if(chessComponents[tmpX+i][tmpY+i].name != '_' ){
                    break;
                }
            }
        }
        tmp.sort(Comparator.comparingInt(ChessboardPoint::getY));
        tmp.sort(Comparator.comparingInt(ChessboardPoint::getX));
        if (tmp.isEmpty()){
            ArrayList out = new ArrayList();
            return out;
        }
        return tmp;
    }
}
