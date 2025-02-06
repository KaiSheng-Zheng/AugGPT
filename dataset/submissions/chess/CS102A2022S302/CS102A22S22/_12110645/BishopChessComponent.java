import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> target = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int targetx = 0;
        int targety = 0;
        boolean flag = true;
        for (int k : number) {
            for (int i : number) {
                targetx = k;
                targety = i;
                if (Math.abs(source.getX() - targetx) == Math.abs(source.getY() - targety)) {
                    int col = source.getY();
                    for (int row = Math.min(source.getX(), targetx) + 1; row < Math.max(source.getX(), targetx); row++) {
                        if (source.getY() <= targety) {
                            col++;
                        }
                        if (source.getY() > targety) {
                            col--;
                        }
                        if (!(this.getConcreteGame().getChess(row, col) instanceof EmptySlotComponent)) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        target.add(new ChessboardPoint(targetx, targety));
                    }
                }
            }
        }
        ArrayList<ChessboardPoint> finalPoint=new ArrayList<>();
        for (int i = 0; i < target.size(); i++) {
            ChessComponent p=this.getConcreteGame().getChess(target.get(i).getX(), target.get(i).getY());
            if (p instanceof EmptySlotComponent){
                finalPoint.add(target.get(i));
            } else if (!(p.getChessColor().equals(this.getChessColor()))){
                finalPoint.add(target.get(i));
            }
        }
        return finalPoint;
    }
    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor color,char name) {
        super(chessboardPoint, color, name);
    }
}
