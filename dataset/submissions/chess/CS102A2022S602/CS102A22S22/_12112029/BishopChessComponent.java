import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToPoints1 = new ArrayList<>();
        int x1 = getSource().getX();
        int y1 = getSource().getY();
        int i;
        for(i=1;i<8;i++){
            if(x1+i<8&&y1+i<8){
                if (belonging.getChessComponents()[x1+i][y1+i] instanceof EmptySlotComponent){
                    canMoveToPoints1.add(new ChessboardPoint(x1+i,y1+i));
                }
                else {
                    if (belonging.getChessComponents()[x1+i][y1+i].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                        canMoveToPoints1.add(new ChessboardPoint(x1+i,y1+i));break;
                     }}}
        for(i=1;i<8;i++){
            if(x1+i<8&&y1-i>=0){
                if (belonging.getChessComponents()[x1+i][y1-i] instanceof EmptySlotComponent){
                    canMoveToPoints1.add(new ChessboardPoint(x1+i,y1-i));
                }
                else {
                    if (belonging.getChessComponents()[x1+i][y1-i].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                        canMoveToPoints1.add(new ChessboardPoint(x1+i,y1-i));break;
                    }}}
        for(i=1;i<8;i++){
            if(x1-i>=0&&y1+i<8){
                if (belonging.getChessComponents()[x1-i][y1+i] instanceof EmptySlotComponent){
                    canMoveToPoints1.add(new ChessboardPoint(x1-i,y1+i));
                }
                else {
                    if (belonging.getChessComponents()[x1-i][y1+i].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                        canMoveToPoints1.add(new ChessboardPoint(x1-i,y1+i));break;
                    }}}
        for(i=1;i<8;i++){
            if(x1-i>=0&&y1-i>=0){
                if (belonging.getChessComponents()[x1-i][y1-i] instanceof EmptySlotComponent){
                    canMoveToPoints1.add(new ChessboardPoint(x1-i,y1-i));
                }
                else {
                    if (belonging.getChessComponents()[x1-i][y1-i].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                        canMoveToPoints1.add(new ChessboardPoint(x1-i,y1-i));break;
                   }}}
        return canMoveToPoints1;
    }
}
