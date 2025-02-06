import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(){}
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'P' : 'p';
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = getSource().getX();//row
        int y = getSource().getY();
        if (name == 'P') {
            if (x == 1) { // at the initial point of black pawns
                for (int i=1;i<3;i++){
                    if (chessComponents[x+i][y]instanceof EmptySlotComponent){
                        canMoveTo.add(getSource().offset(i, 0));
                    }else if (chessComponents[x+i][y].getChessColor()!=getCurrentPlayer()){
                        canMoveTo.add(getSource().offset(i, 0));
                        break;
                    }else break;
                }
                
                if (y+1<8&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,1));
                }else if (y-1>=0&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,-1));
                }
            } else if (chessComponents[x+1][y]instanceof EmptySlotComponent){
                if (y+1<8&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,1));
                }else if (y-1>=0&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,-1));
                }
                canMoveTo.add(getSource().offset(1, 0));
            }else {
                if (y+1<8&&chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,1));
                }else if (y-1>=0&&chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE){
                    canMoveTo.add(getSource().offset(1,-1));
                }
            }

        } else {
            if (x == 6) {
                for (int i=1;i<3;i++){
                    if (chessComponents[x-i][y]instanceof EmptySlotComponent){
                        canMoveTo.add(getSource().offset(-i, 0));
                    }else if (chessComponents[x-i][y].getChessColor()!=getCurrentPlayer()){
                        canMoveTo.add(getSource().offset(-i, 0));
                        break;
                    }else break;
                }
                if (y+1<8&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,1));
                }else if (y-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,-1));
                }
            } else if (chessComponents[x-1][y]instanceof EmptySlotComponent){
                if (y+1<8&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,1));
                }else if (y-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,-1));
                }
                canMoveTo.add(getSource().offset(-1, 0));
            }else {
                if (y+1<8&&chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,1));
                }else if (y-1>=0&&chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    canMoveTo.add(getSource().offset(-1,-1));
                }
            }


        }
        return canMoveTo;
    }

    public ChessColor getCurrentPlayer() {
        if (this.name == 'P') {
            return ChessColor.BLACK;
        } else return ChessColor.WHITE;
    }


}