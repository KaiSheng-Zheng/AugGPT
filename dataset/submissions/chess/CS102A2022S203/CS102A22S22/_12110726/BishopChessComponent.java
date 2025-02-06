import java.util.*;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        for (int i = source.getX() + 1;i <= source.getX() + source.getY();i++) {
            ChessboardPoint target = new ChessboardPoint(i, source.getX() + source.getY() - i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_' && target.right())
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (int i = source.getX() - 1;i >= 0;i--) {
            ChessboardPoint target = new ChessboardPoint(i, source.getX() + source.getY() - i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_' && target.right())
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }

        for (int i = source.getY() - 1;i >= 0;i--) {
            ChessboardPoint target = new ChessboardPoint(7 -  (7 - source.getX() + source.getY()) + i, i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_' && target.right())
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (int i = source.getY() + 1;i <=  (7 - source.getX() + source.getY());i++) {
            ChessboardPoint target = new ChessboardPoint(7 -  (7 - source.getX() + source.getY()) + i, i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_' && target.right())
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        return CanMoveTo;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}
