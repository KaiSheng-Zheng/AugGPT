import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(){

    }

    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor currentColor = getChessColor();
        if(currentColor == ChessColor.BLACK){
            if(x == 1){
                if(chessComponents[x+1][y].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x+1][y].getSource());
                }
                if(chessComponents[x+2][y].getChessColor() == ChessColor.NONE && chessComponents[x+1][1].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x+2][y].getSource());
                }
                if(chessComponents[x+1][y-1].getChessColor() == ChessColor.WHITE && getSource().offset(1,-1) != null){
                    canMoveTo.add(chessComponents[x+1][y-1].getSource());
                }
                if(chessComponents[x+1][y+1].getChessColor() == ChessColor.WHITE && getSource().offset(1,1) != null){
                    canMoveTo.add(chessComponents[x+1][y+1].getSource());
                }
            }
            else {
                if(chessComponents[x+1][y].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x+1][y].getSource());
                }
                if(chessComponents[x+1][y-1].getChessColor() == ChessColor.WHITE && getSource().offset(1,-1) != null){
                    canMoveTo.add(chessComponents[x+1][y-1].getSource());
                }
                if(chessComponents[x+1][y+1].getChessColor() == ChessColor.WHITE && getSource().offset(1,1) != null){
                    canMoveTo.add(chessComponents[x+1][y+1].getSource());
                }
            }
        }
        if(currentColor == ChessColor.WHITE){
            if(x == 6){
                if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x-1][y].getSource());
                }
                if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE && chessComponents[x-2][y].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x][y+2].getSource());
                }
                if(chessComponents[x-1][y+1].getChessColor() == ChessColor.BLACK && getSource().offset(-1,1) != null){
                    canMoveTo.add(chessComponents[x-1][y+1].getSource());
                }
                if(chessComponents[x-1][y-1].getChessColor() == ChessColor.BLACK && getSource().offset(-1,-1) != null){
                    canMoveTo.add(chessComponents[x-1][y-1].getSource());
                }
            }
            else {
                if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE){
                    canMoveTo.add(chessComponents[x-1][y].getSource());
                }
                if(chessComponents[x-1][y+1].getChessColor() == ChessColor.BLACK && getSource().offset(-1,1) != null){
                    canMoveTo.add(chessComponents[x-1][y+1].getSource());
                }
                if(chessComponents[x-1][y-1].getChessColor() == ChessColor.BLACK && getSource().offset(-1,-1) != null){
                    canMoveTo.add(chessComponents[x-1][y-1].getSource());
                }
            }
        }

        if(canMoveTo.size() != 0){
            return canMoveTo;
        }
        else return new ArrayList<>();
    }
}
