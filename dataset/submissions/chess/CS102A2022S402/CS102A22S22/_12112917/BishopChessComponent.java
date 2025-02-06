import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cb = new ArrayList<>();
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,i)) {
                cb.add(super.getSource().offset(i, i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() + i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = -1;i>=-7;i--){
            if(super.AvailableMove(i,i)) {
                cb.add(super.getSource().offset(i, i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() + i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,-i)) {
                cb.add(super.getSource().offset(i, -i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() - i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = -1;i>=-7;i--){
            if(super.AvailableMove(i,-i)) {
                cb.add(super.getSource().offset(i, -i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() - i)) {
                    break;
                }
            }
            else break;
        }
        return cb;

    }public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK) {
            name = 'B';
        }
        else
            name = 'b';
    }
}
