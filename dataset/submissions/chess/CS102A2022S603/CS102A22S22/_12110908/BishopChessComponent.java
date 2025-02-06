import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(){
        if (this.getChessColor()==ChessColor.BLACK){
            name='B';
        }else {
            name='b';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        for (int i=1; source.getX()+i<=7 && source.getY()+i<=7; i++){
            if (!(chessboard[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()+i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(i, i));
                }
                break;
            }else
            result.add(source.offset(i,i));
        }
        for (int i=1; source.getX()+i<=7 && source.getY()-i>=0; i++){
            if (!(chessboard[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()+i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(i, -i));
                }
                break;
            }else
                result.add(source.offset(i,-i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()+i<=7; i++){
            if (!(chessboard[source.getX()-i][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()-i][source.getY()+i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(-i, i));
                }
                break;
            }else
                result.add(source.offset(-i,i));
        }
        for (int i=1; source.getX()-i>=0 && source.getY()-i>=0; i++){
            if (!(chessboard[source.getX()-i][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()-i][source.getY()-i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(-i, -i));
                }
                break;
            }else
                result.add(source.offset(-i,-i));
        }
        if (result.size()==0){
            return new ArrayList<>();
        }else {
            return result;
        }
    }
}
