import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;


    public QueenChessComponent(ChessComponent[][] chessComponents,int i,int j) {
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(i,j));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointslist = new ArrayList<>();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canmoveto(chessComponents,new ChessboardPoint(i,j))){
                    pointslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return pointslist;
    }

    public boolean canmoveto(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getSource();



        if(Math.abs(source.getY()-destination.getY())==Math.abs(source.getX()-destination.getX())) {
            int num = Math.abs(source.getX() - destination.getX());

            if (destination.getY() > source.getY() && destination.getX() > source.getX()) {
                for (int i = 1; i < num; i++) {
                    if (chessComponents[source.getX() + i][source.getY() + i].getChessColor() != ChessColor.NONE) {
                        return false;
                    }
                }
            } else if (destination.getY() > source.getY() && destination.getX() < source.getX()) {
                for (int i = 1; i < num; i++) {
                    if (chessComponents[source.getX() - i][source.getY() + i].getChessColor() != ChessColor.NONE) {
                        return false;
                    }
                }
            } else if (destination.getY() < source.getY() && destination.getX() > source.getX()) {
                for (int i = 1; i < num; i++) {
                    if (chessComponents[source.getX() + i][source.getY() - i].getChessColor() != ChessColor.NONE) {
                        return false;
                    }
                }
            } else if (destination.getY() < source.getY() && destination.getX() < source.getX()) {
                for (int i = 1; i < num; i++) {
                    if (chessComponents[source.getX() - i][source.getY() - i].getChessColor() != ChessColor.NONE) {
                        return false;
                    }
                }
            }

            if(chessboard[destination.getX()][destination.getY()].getChessColor()!=chessboard[source.getX()][source.getY()].getChessColor()){
                return true;
            }else return false;

        }else if(destination.getY()==source.getY()) {
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
}




