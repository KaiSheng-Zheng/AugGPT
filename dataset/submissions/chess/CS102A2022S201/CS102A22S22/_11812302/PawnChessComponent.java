import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Pb0 = new ArrayList<>();
        ArrayList<ChessboardPoint> Pb1 = new ArrayList<>();
        ArrayList<ChessboardPoint> Pw0 = new ArrayList<>();
        ArrayList<ChessboardPoint> Pw1 = new ArrayList<>();
        Pb0.add(getSource().offset(0,1));
        if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()+1].getChessColor() ==
                ChessColor.NONE) {
            Pb0.add(getSource().offset(0,2));
        }
        Pb1.add(getSource().offset(0,1));
        Pw0.add(getSource().offset(0,-1));
        if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()-1].getChessColor() ==
                ChessColor.NONE) {
            Pw0.add(getSource().offset(0,-2));
        }
        Pw1.add(getSource().offset(0,-1));
        for (int i=0; i<Pb0.size(); i++) {
            if (Pb0.get(i) == null) {
                Pb0.remove(i);
                i = i - 1;
            }
        }
        for (int i=0; i<Pb0.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                    ChessColor.NONE) {
                Pb0.remove(i);
                i = i-1;
            }
        }
        for (int i=0; i<Pb1.size(); i++) {
            if (Pb1.get(i) == null) {
                Pb1.remove(i);
                i = i-1;
            }
        }
        for (int i=0; i<Pb1.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                    ChessColor.NONE) {
                Pb1.remove(i);
                i = i-1;
            }
        }
        for (int i=0; i<Pw0.size(); i++) {
            if (Pw0.get(i) == null) {
                Pw0.remove(i);
                i = i - 1;
            }
        }
        for (int i=0; i<Pw0.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                    ChessColor.NONE) {
                Pw0.remove(i);
                i = i-1;
            }
        }
        for (int i=0; i<Pw1.size(); i++) {
            if (Pw1.get(i) == null) {
                Pw1.remove(i);
                i = i - 1;
            }
        }
        for (int i=0; i<Pw1.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() !=
                    ChessColor.NONE) {
                Pw1.remove(i);
                i = i-1;
            }
        }
        int hang =  getSource().getX();
        ChessColor color = getChessColor();
        if (color == ChessColor.BLACK) {
            if (hang == 1) {
                return Pb0;
            }
            else {
                return Pb1;
            }
        }
        else  {
            if (hang == 6) {
                return Pw0;
            }
            else {
                return Pw1;
            }
        }
    }
}