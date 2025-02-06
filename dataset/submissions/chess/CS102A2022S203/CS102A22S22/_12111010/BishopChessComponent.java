import java.util.*;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        ChessboardPoint source = this.getSource();
        int i1 = source.getX() + source.getY();
        int j1 = 7 - source.getX() + source.getY();
        int i, j;
        for (i = source.getX() + 1;i <= i1;i++) {
            ChessboardPoint target = new ChessboardPoint(i, i1 - i);
            if (!target.legal()) continue;
            ChessComponent temp = this.getChessComponent(target);
            if (temp.name == '_' && target.legal())
                CanMoveTo.add(target);
            else{
                if (attack(temp))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (i = source.getX() - 1;i >= 0;i--) {
            ChessboardPoint target = new ChessboardPoint(i, i1 - i);
            if (!target.legal()) continue;
            ChessComponent temp = this.getChessComponent(target);
            if (temp.name == '_' && target.legal())
                CanMoveTo.add(target);
            else{
                if (attack(temp))
                    CanMoveTo.add(target);
                break;
            }
        }

        for (j = source.getY() - 1;j >= 0;j--) {
            ChessboardPoint target = new ChessboardPoint(7 - j1 + j, j);
            if (!target.legal()) continue;
            ChessComponent temp = this.getChessComponent(target);
            if (temp.name == '_' && target.legal())
                CanMoveTo.add(target);
            else{
                if (attack(temp))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (j = source.getY() + 1;j <= j1;j++) {
            ChessboardPoint target = new ChessboardPoint(7 - j1 + j, j);
            if (!target.legal()) continue;
            ChessComponent temp = this.getChessComponent(target);
            if (temp.name == '_' && target.legal())
                CanMoveTo.add(target);
            else{
                if (attack(temp))
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
