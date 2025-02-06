import java.util.*;

public class BishopChessComponent extends ChessComponent{


    public BishopChessComponent(char c, int i, int j, ChessComponent[][] chessComponents) {
        super(c,i,j,chessComponents);
    }

    public boolean thisCanMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==getChessColor()){
            return false;
        }
        if (destination.getY()-source.getY() == destination.getX()-source.getX()) {
            if(destination.getY()>source.getY()){
                for (int i=1;i<destination.getY()-source.getY();i++) {
                    if (!(chessComponents[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }

            } else {
                for (int i=1;i<source.getY()-destination.getY();i++) {
                    if (!(chessComponents[source.getX()-i][source.getY()-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        }
        else if (destination.getY()-source.getY() == -destination.getX()+source.getX()) {
            if(destination.getY()>source.getY()){
                for (int i=1;i<destination.getY()-source.getY();i++) {
                    if (!(chessComponents[source.getX()-i][source.getY()+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            } else {
                for (int i=1;i<source.getY()-destination.getY();i++) {
                    if (!(chessComponents[source.getX()+i][source.getY()-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public  List<ChessboardPoint> canMoveTo() {
        cmt.clear();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (thisCanMoveTo(chessComponents,new ChessboardPoint(i,j))) {
                    cmt.add(new ChessboardPoint(i,j));
                }
            }
        }
        cmt.removeIf(chessboardPoint -> chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==getChessColor());
        return cmt;
    }
}
