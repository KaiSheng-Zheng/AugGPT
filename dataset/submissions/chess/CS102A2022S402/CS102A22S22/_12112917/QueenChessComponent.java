import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cq = new ArrayList<>();
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,0)) {
                cq.add(super.getSource().offset(i, 0));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY())) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(-i,0)) {
                cq.add(super.getSource().offset(-i, 0));

                if (CapturedChess(super.getSource().getX() - i, super.getSource().getY())) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(0,i)) {
                cq.add(super.getSource().offset(0, i));

                if (CapturedChess(super.getSource().getX(), super.getSource().getY() + i)) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(0,-i)) {
                cq.add(super.getSource().offset(0, -i));

                if (CapturedChess(super.getSource().getX(), super.getSource().getY() - i)) break;
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,i)) {
                cq.add(super.getSource().offset(i, i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() + i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = -1;i>=-7;i--){
            if(super.AvailableMove(i,i)) {
                cq.add(super.getSource().offset(i, i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() + i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = 1;i<=7;i++){
            if(super.AvailableMove(i,-i)) {
                cq.add(super.getSource().offset(i, -i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() - i)) {
                    break;
                }
            }
            else break;
        }
        for(int i = -1;i>=-7;i--){
            if(super.AvailableMove(i,-i)) {
                cq.add(super.getSource().offset(i, -i));

                if (CapturedChess(super.getSource().getX() + i, super.getSource().getY() - i)) {
                    break;
                }
            }
            else break;
        }
        return cq;
    }
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK) {
            name = 'Q';
        }else
            name = 'q';
    }
}
