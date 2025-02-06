import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public boolean ss(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source =new ChessboardPoint(getSource().getX(), getSource().getY());
        if(  samecolor(getChessColor(),getChessboard()[destination.getX()][destination.getY()].getChessColor())){
            return false;
        }
        int b = destination.getX() - source.getX();
        int a = destination.getY() - source.getY();
        if (source.getX() == 6 && getChessColor().equals(ChessColor.WHITE) && chessboard[5][source.getY()].getChessColor() == ChessColor.NONE) {
            return (a == 0 && b == -1) || (a == 0 && b == -2 && chessboard[4][source.getY()].getChessColor() == ChessColor.NONE);
        } else if (source.getX() != 6 && getChessColor().equals(ChessColor.WHITE)) {
            if (source.getY() != 0 && source.getY() != 7) {
                if (!(chessboard[source.getX() - 1][source.getY() + 1] instanceof EmptySlotComponent)  ) {
                    return (a == 1 && b == -1) ;
                }else if(!(chessboard[source.getX() - 1][source.getY() - 1] instanceof EmptySlotComponent)){
                    return (a == -1 && b == -1);
                } else if (chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.BLACK || chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == -1;
                }
            } else if (source.getY() == 0) {
                if (!(chessboard[source.getX() - 1][source.getY() + 1] instanceof EmptySlotComponent)) {
                    return (a == 1 && b == -1);
                } else if (chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.BLACK || chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == -1;
                }
            } else {
                if (!(chessboard[source.getX() - 1][source.getY() - 1] instanceof EmptySlotComponent)) {
                    return (a == -1 && b == -1);

                } else if (chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.BLACK || chessboard[source.getX() - 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == -1;
                }
            }


        } else if (source.getX() == 1 && getChessColor().equals(ChessColor.BLACK) && chessboard[2][source.getY()].getChessColor() == ChessColor.NONE) {
            return (a == 0 && b == 1) || (a == 0 && b == 2 && chessboard[3][source.getY()].getChessColor() == ChessColor.NONE);

        } else if (source.getX() != 1 && getChessColor().equals(ChessColor.BLACK)) {
            if (source.getY() != 0 && source.getY() != 7) {
                if (!(chessboard[source.getX() + 1][source.getY() + 1] instanceof EmptySlotComponent)  ) {
                    return (a == 1 && b == 1);
                }else if(!(chessboard[source.getX() + 1][source.getY() - 1] instanceof EmptySlotComponent)){
                    return  (a == -1 && b == 1);
                } else if (chessboard[source.getX() + 1][source.getY()].getChessColor() == ChessColor.BLACK || chessboard[source.getX() + 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == 1;
                }
            } else if (source.getY() == 0) {
                if (!(chessboard[source.getX() + 1][source.getY() + 1] instanceof EmptySlotComponent)) {
                    return (a == 1 && b == 1);
                } else if (chessboard[source.getX() + 1][source.getY()].getChessColor() == ChessColor.BLACK && chessboard[source.getX() + 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == 1;
                }
            } else {
                if (!(chessboard[source.getX() + 1][source.getY() - 1] instanceof EmptySlotComponent)) {
                    return (a == -1 && b == 1);

                } else if (chessboard[source.getX() - +1][source.getY()].getChessColor() == ChessColor.BLACK && chessboard[source.getX() + 1][source.getY()].getChessColor() == ChessColor.WHITE) {
                    return false;
                } else {
                    return a == 0 && b == 1;
                }
            }

        }else {
            return false;
        }


    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chess = new ArrayList<>();
        ChessboardPoint chessboardPoint;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                ChessComponent[][] chessComponents = getChessboard();
                //  ChessComponent[][] chessComponents = new ChessComponent[8][8];
                if(ss(chessComponents, destination)){
                    chess.add(new ChessboardPoint(i,j));
                }
            }
        }
        return chess;
    }
}
