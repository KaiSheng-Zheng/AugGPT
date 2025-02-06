import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){
        if (this.getChessColor()==ChessColor.BLACK){
            name='R';
        }else {
            name='r';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source=getSource();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        for (int i=1; source.getX()+i<=7;i++){
            if (!(chessboard[source.getX()+i][source.getY()] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()+i][source.getY()].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(i, 0));
                }
                break;
            }else {
                result.add(source.offset(i, 0));
            }
        }
        for (int i=1; source.getX()-i>=0;i++){
            if (!(chessboard[source.getX()-i][source.getY()] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()-i][source.getY()].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(-i, 0));
                }
                break;
            }else {
                result.add(source.offset(-i, 0));
            }
        }
        for (int i=1; source.getY()+i<=7;i++){
            if (!(chessboard[source.getX()][source.getY()+i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()][source.getY()+i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(0, i));
                }
                break;
            }else {
                result.add(source.offset(0, i));
            }
        }
        for (int i=1; source.getY()-i>=0;i++){
            if (!(chessboard[source.getX()][source.getY()-i] instanceof EmptySlotComponent)){
                if (chessboard[source.getX()][source.getY()-i].getChessColor() != this.getChessColor()) {
                    result.add(source.offset(0, -i));
                }
                break;
            }else {
                result.add(source.offset(0, -i));
            }
        }
        if (result.size()==0){
            return new ArrayList<>();
        }else {
            return result;
        }
    }
}
