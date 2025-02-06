import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        if(this.getChessColor()==ChessColor.BLACK){
            if(getSource().offset(1,1)!=null) {
                if (ConcreteChessGame.getChessBoard()[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    arrayList.add(getSource().offset(1, 1));
                }
            }
            if(getSource().offset(1,-1)!=null) {
                if (ConcreteChessGame.getChessBoard()[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    arrayList.add(getSource().offset(1, -1));
                }
            }
            if((getSource().getX()==1)&(ConcreteChessGame.getChessBoard()[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE)&(ConcreteChessGame.getChessBoard()[getSource().getX()+2][getSource().getY()].getChessColor()==ChessColor.NONE)){
                arrayList.add(getSource().offset(1, 0));
                arrayList.add(getSource().offset(2, 0));
            }else {
                arrayList.add(getSource().offset(1,0));
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i)==null){
                    arrayList.remove(i);
                    i=i-1;
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if(ConcreteChessGame.getChessBoard()[arrayList.get(i).getX()][arrayList.get(i).getY()].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                    arrayList.remove(i);
                    i=i-1;
                }
            }
            return arrayList;
        }else {
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                arrayList.add(getSource().offset(-1, -1));
            }
            if(ConcreteChessGame.getChessBoard()[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                arrayList.add(getSource().offset(-1, 1));
            }
            if((getSource().getX()==6)&(ConcreteChessGame.getChessBoard()[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE)&(ConcreteChessGame.getChessBoard()[getSource().getX()-2][getSource().getY()].getChessColor()==ChessColor.NONE)){
                arrayList.add(getSource().offset(-1, 0));
                arrayList.add(getSource().offset(-2, 0));
            }else {
                arrayList.add(getSource().offset(-1,0));
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i)==null){
                    arrayList.remove(i);
                    i=i-1;
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if(ConcreteChessGame.getChessBoard()[arrayList.get(i).getX()][arrayList.get(i).getY()].getChessColor()==ConcreteChessGame.getChessBoard()[getSource().getX()][getSource().getY()].getChessColor()){
                    arrayList.remove(i);
                    i=i-1;
                }
            }
            return arrayList;
        }
    }
}