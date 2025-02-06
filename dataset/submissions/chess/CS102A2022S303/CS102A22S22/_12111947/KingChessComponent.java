import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = super.getSource();
        ChessColor color = super.getChessColor();
        ChessComponent[][] a = super.chessboard;
        ArrayList<ChessboardPoint> M = new ArrayList<>();
        if (source != null) {
            if ((source.getX() - 1>=0)&&(source.getX() - 1<=7)){
                if ((source.getY() - 1>=0)&&(source.getY() - 1<=7)){
                    ChessboardPoint target1 = new ChessboardPoint(source.getX() - 1, source.getY() - 1);
                    if (a[target1.getX()][target1.getY()] instanceof EmptySlotComponent || (a[target1.getX()][target1.getY()].getChessColor() != color)) {
                        M.add(target1);
                    }
                }
                if ((source.getY() >=0)&&(source.getY() <=7)){
                    ChessboardPoint target2 = new ChessboardPoint(source.getX() - 1, source.getY());
                    if (a[target2.getX()][target2.getY()] instanceof EmptySlotComponent || (a[target2.getX()][target2.getY()].getChessColor() != color)) {
                        M.add(target2);
                    }
                }
                if ((source.getY() + 1>=0)&&(source.getY() +1<=7)){
                    ChessboardPoint target3 = new ChessboardPoint(source.getX() - 1, source.getY() + 1);
                    if (a[target3.getX()][target3.getY()] instanceof EmptySlotComponent || (a[target3.getX()][target3.getY()].getChessColor() != color)) {
                        M.add(target3);
                    }
                }
            }
            if ((source.getX()>=0)&&(source.getX()<=7)){
                if ((source.getY() - 1>=0)&&(source.getY() - 1<=7)){
                    ChessboardPoint target4 = new ChessboardPoint(source.getX(), source.getY() - 1);
                    if (a[target4.getX()][target4.getY()] instanceof EmptySlotComponent || (a[target4.getX()][target4.getY()].getChessColor() != color)) {
                        M.add(target4);
                    }
                }
                if ((source.getY() + 1>=0)&&(source.getY() +1<=7)){
                    ChessboardPoint target5 = new ChessboardPoint(source.getX(), source.getY() + 1);
                    if (a[target5.getX()][target5.getY()] instanceof EmptySlotComponent || (a[target5.getX()][target5.getY()].getChessColor() != color)) {
                        M.add(target5);
                    }
                }
            }
            if ((source.getX()+1>=0)&&(source.getX()+1<=7)){
                if ((source.getY() - 1>=0)&&(source.getY() - 1<=7)){
                    ChessboardPoint target6 = new ChessboardPoint(source.getX() + 1, source.getY() - 1);
                    if (a[target6.getX()][target6.getY()] instanceof EmptySlotComponent || (a[target6.getX()][target6.getY()].getChessColor() != color)) {
                        M.add(target6);
                    }
                }
                if ((source.getY() >=0)&&(source.getY() <=7)){
                    ChessboardPoint target7 = new ChessboardPoint(source.getX() + 1, source.getY());
                    if (a[target7.getX()][target7.getY()] instanceof EmptySlotComponent || (a[target7.getX()][target7.getY()].getChessColor() != color)) {
                        M.add(target7);
                    }
                }
                if ((source.getY() + 1>=0)&&(source.getY() + 1<=7)){
                    ChessboardPoint target8 = new ChessboardPoint(source.getX() + 1, source.getY() + 1);
                    if (a[target8.getX()][target8.getY()] instanceof EmptySlotComponent || (a[target8.getX()][target8.getY()].getChessColor() != color)) {
                        M.add(target8);
                    }

                }
            }
        }


    return M;
}
}