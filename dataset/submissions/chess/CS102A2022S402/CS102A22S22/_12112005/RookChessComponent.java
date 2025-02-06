import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    ChessComponent[][] chessComponents;


    public RookChessComponent(ChessComponent[][] pass, int i, int j) {
        this.chessComponents = pass;
        this.setSource(new ChessboardPoint(i, j));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        List<ChessboardPoint> pointslist = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canmoveto(source, new ChessboardPoint(i, j))) {
                    pointslist.add(new ChessboardPoint(i, j));
                }
            }
        }
        return pointslist;
    }

    public boolean canmoveto(ChessboardPoint source, ChessboardPoint destination) {

        if(destination.getY()==source.getY()) {
                if (chessComponents[destination.getX()][destination.getY()].getChessColor() == chessComponents[source.getX()][source.getY()].getChessColor() || destination.getX()==source.getX()){
                    return false;
                }
                    for (int i = Math.min(destination.getX(), source.getX()) + 1; i < Math.max(destination.getX(), source.getX()); i++) {
                        if (chessComponents[i][source.getY()].getChessColor()!=ChessColor.NONE) {
                            return false;
                        }
                    }
                    return true;

        }else if(destination.getX()==source.getX()){
            if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor()){
                return false;
            }
                for (int i = Math.min(destination.getY(), source.getY()) + 1; i < Math.max(destination.getY(), source.getY()); i++) {
                    if (chessComponents[source.getX()][i].getChessColor()!=ChessColor.NONE) {
                        return false;
                    }
                }
                return true;

        }else return false;


    }

//    public boolean canmoveto(ChessComponent[][] chessComponents, ChessboardPoint destination) {
//        ChessboardPoint source = getSource();
//
//        if (destination.getY() == source.getY()) {
//            if (destination.getX() != source.getX() && chessComponents[destination.getX()][destination.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
//                for (int i = Math.min(destination.getX(), source.getX()) + 1; i < Math.max(destination.getX(), source.getX()); i++) {
//                    if (chessComponents[i][source.getY()].getChessColor() == ChessColor.WHITE || chessComponents[i][source.getY()].getChessColor() == ChessColor.BLACK) {
//                        return false;
//                    }
//                }
//                return true;
//            } else return false;
//        } else if (destination.getX() == source.getX()) {
//            if (chessComponents[destination.getX()][destination.getY()].getChessColor() != chessComponents[source.getX()][source.getY()].getChessColor()) {
//                for (int i = Math.min(destination.getY(), source.getY()) + 1; i < Math.max(destination.getY(), source.getY()); i++) {
//                    if (chessComponents[i][source.getY()].getChessColor() == ChessColor.WHITE || chessComponents[i][source.getY()].getChessColor() == ChessColor.BLACK) {
//                        return false;
//                    }
//                }
//                return true;
//            } else return false;
//        } else return false;
//
//    }
}
