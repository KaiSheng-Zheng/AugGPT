import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cp = new ArrayList<>();
        List<ChessboardPoint> cp1 = new ArrayList<>();
        if(super.getChessColor()==ChessColor.BLACK){
            if(super.AvailableMove(1,0)){
                if(chessComponents[super.getSource().getX()+1][super.getSource().getY()].getChessColor()
                        ==ChessColor.NONE){
                    cp.add(super.getSource().offset(1,0));
                }
            }
            if(super.getSource().getX()==1){
                if(super.AvailableMove(1,0)) {
                    if (chessComponents[super.getSource().getX() + 1][super.getSource().getY()].getChessColor()
                            == ChessColor.NONE) {
                        if (AvailableMove(2, 0)) {
                            if (chessComponents[super.getSource().getX() + 2][super.getSource().getY()].getChessColor()
                                    == ChessColor.NONE) {
                                cp.add(super.getSource().offset(2, 0));
                            }
                        }
                    }
                }
            }
            if(super.AvailableMove(1,1)) {
                if (chessComponents[super.getSource().getX() + 1][super.getSource().getY() + 1].getChessColor()
                        == ChessColor.WHITE) {
                    cp.add(super.getSource().offset(1, 1));
                }
            }
            if(super.AvailableMove(1,-1)) {
                if (chessComponents[super.getSource().getX() + 1][super.getSource().getY() - 1].getChessColor()
                        == ChessColor.WHITE) {
                    cp.add(super.getSource().offset(1, -1));
                }
            }
            return cp;
        }

        else{
            if(super.AvailableMove(-1,0)){
                if(chessComponents[super.getSource().getX()-1][super.getSource().getY()].getChessColor()
                        ==ChessColor.NONE) {
                    cp1.add(super.getSource().offset(-1, 0));
                }
            }
            if(super.getSource().getX()==6){
                if(super.AvailableMove(-1,0)) {
                    if (chessComponents[super.getSource().getX() -1][super.getSource().getY()].getChessColor()
                            == ChessColor.NONE) {
                        if (AvailableMove(-2, 0)) {
                            if (chessComponents[super.getSource().getX() - 2][super.getSource().getY()].getChessColor()
                                    == ChessColor.NONE) {
                                cp1.add(super.getSource().offset(-2, 0));
                            }
                        }
                    }
                }
            }
            if(super.AvailableMove(-1,1)) {
                if (chessComponents[super.getSource().getX() - 1][super.getSource().getY() + 1].getChessColor()
                        == ChessColor.BLACK) {
                    cp1.add(super.getSource().offset(-1, 1));
                }
            }
            if(super.AvailableMove(-1,-1)) {
                if (chessComponents[super.getSource().getX() - 1][super.getSource().getY() - 1].getChessColor()
                        == ChessColor.BLACK) {
                    cp1.add(super.getSource().offset(-1, -1));
                }
            }
            return cp1;
        }

    }
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source, chessColor);
        if(chessColor == ChessColor.BLACK) {
            name = 'P';
        }
        else
            name = 'p';
    }
}
