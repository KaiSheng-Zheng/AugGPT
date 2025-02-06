import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){

        ArrayList<ChessboardPoint> canMoveToPoints1 = new ArrayList<>();
        int x1 = getSource().getX();
        int y1 = getSource().getY();
        if (x1+1<=7&&y1+1<8){
            if (belonging.getChessComponents()[x1+1][y1+1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1+1,y1+1));
            else {
                if (belonging.getChessComponents()[x1+1][y1+1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1+1,y1+1));
            }
        }
        if (y1+1<8){
            if (belonging.getChessComponents()[x1][y1+1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1,y1+1));
            else {
                if (belonging.getChessComponents()[x1][y1+1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1,y1+1));
            }
        }
        if (x1+1<=7){
            if (belonging.getChessComponents()[x1+1][y1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1+1,y1));
            else {
                if (belonging.getChessComponents()[x1+1][y1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1+1,y1));
            }
        }
        if (x1-1>=0){
            if (belonging.getChessComponents()[x1-1][y1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1-1,y1));
            else {
                if (belonging.getChessComponents()[x1-1][y1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1-1,y1));
            }
        }
        if (y1-1>=0){
            if (belonging.getChessComponents()[x1][y1-1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1,y1-1));
            else {
                if (belonging.getChessComponents()[x1][y1-1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1,y1-1));
            }
        }
        if (x1+1<=7&&y1-1>=0){
            if (belonging.getChessComponents()[x1+1][y1-1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1+1,y1-1));
            else {
                if (belonging.getChessComponents()[x1+1][y1-1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1+1,y1-1));
            }
        }
        if (x1-1>=0&&y1+1<8){
            if (belonging.getChessComponents()[x1-1][y1+1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1-1,y1+1));
            else {
                if (belonging.getChessComponents()[x1-1][y1+1].getChessColor()!=belonging.getChessComponents()[x1][y1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1-1,y1+1));
            }
        }
        if (x1-1>=0&&y1-1>=0){
            if (belonging.getChessComponents()[x1-1][y1-1] instanceof EmptySlotComponent)canMoveToPoints1.add(new ChessboardPoint(x1-1,y1-1));
            else {
                if (belonging.getChessComponents()[x1-1][y1-1].getChessColor()!=belonging.getChessComponents()[x1-1][y1-1].getChessColor())
                    canMoveToPoints1.add(new ChessboardPoint(x1-1,y1-1));
            }
        }
       return canMoveToPoints1;
    }
}
