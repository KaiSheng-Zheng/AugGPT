import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();

        for (int i = source.getX() + 1;i < 8;i++) {
            ChessboardPoint target = new ChessboardPoint(i, source.getY());
            if (this.getChessComponent(target).name == '_')
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (int i = source.getX() - 1;i >= 0;i--) {
            ChessboardPoint target = new ChessboardPoint(i, source.getY());
            if (this.getChessComponent(target).name == '_')
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (int i = source.getY() + 1;i < 8;i++) {
            ChessboardPoint target = new ChessboardPoint(source.getX(), i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_')
                CanMoveTo.add(target);
            else{
                if (attack(this.getChessComponent(target)))
                    CanMoveTo.add(target);
                break;
            }
        }
        for (int i = source.getY() - 1;i >= 0;i--) {
            ChessboardPoint target = new ChessboardPoint(source.getX(), i);
            if (!target.right()) continue;
            if (this.getChessComponent(target).name == '_')
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
        for (ChessboardPoint canmove : CanMoveTo)
            System.out.print(canmove);
    }
}
