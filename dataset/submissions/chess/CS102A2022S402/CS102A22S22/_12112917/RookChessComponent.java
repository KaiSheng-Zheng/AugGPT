import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cr = new ArrayList<>();
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,0)) {
                cr.add(super.getSource().offset(i, 0));
                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY())) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(-i,0)) {
                cr.add(super.getSource().offset(-i, 0));

                if (CapturedChess(super.getSource().getX() - i, super.getSource().getY())) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(0,i)) {
                cr.add(super.getSource().offset(0, i));

                if (CapturedChess(super.getSource().getX(), super.getSource().getY() + i)) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(0,-i)) {
                cr.add(super.getSource().offset(0, -i));

                if (CapturedChess(super.getSource().getX(), super.getSource().getY() - i)) break;
            }
            else break;
        }
        return cr;
    }
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK){
            name='R';
        }else
            name = 'r';
    }
}
