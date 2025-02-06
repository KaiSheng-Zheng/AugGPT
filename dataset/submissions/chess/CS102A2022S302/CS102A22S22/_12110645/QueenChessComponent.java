import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int targetx = 0;
        int targety = 0;
        int x = source.getX();
        int y = source.getY();
        boolean flag = true;
        for (int j : number) {
            targety = j;
            for (int col = Math.min(y, targety) + 1; col < Math.max(y, targety); col++) {
                if (!(this.getConcreteGame().getChess(x, col) instanceof EmptySlotComponent)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                target.add(new ChessboardPoint(x, targety));
            }
        }
        for (int j : number) {
            targetx = j;
            for (int row = Math.min(x, targetx) + 1; row< Math.max(x, targetx); row++) {
                if (!(this.getConcreteGame().getChess(row, y) instanceof EmptySlotComponent)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                target.add(new ChessboardPoint(targetx, y));
            }
        }
        for (int k : number) {
            for (int i : number) {
                targetx = k;
                targety = i;
                if (Math.abs(x - targetx) == Math.abs(y - targety)) {
                    int col = source.getY();
                    for (int row = Math.min(x, targetx) + 1; row < Math.max(x, targetx); row++) {
                        if (targety >= y) {
                            col++;
                        } else {
                            col--;
                        }
                        if (!(this.getConcreteGame().getChess(row, col) instanceof EmptySlotComponent)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        target.add(new ChessboardPoint(targetx, targety));
                    }
                }
            }
        }
        return target;
    }
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }
}
