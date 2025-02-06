import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        arrayList.add(getSource().offset(1, 0));
        arrayList.add(getSource().offset(0, 1));
        arrayList.add(getSource().offset(1, 1));
        arrayList.add(getSource().offset(-1, 0));
        arrayList.add(getSource().offset(0,-1));
        arrayList.add(getSource().offset(-1, -1));
        arrayList.add(getSource().offset(1, -1));
        arrayList.add(getSource().offset(-1, 1));
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