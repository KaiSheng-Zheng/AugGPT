import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char theName,ChessComponent[][] chessComponents){
        super(source,chessColor,theName,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movablePoints=new ArrayList<>();
        int row=this.getSource().getX();
        int col=this.getSource().getY();

        if(this.getChessColor()==ChessColor.BLACK){
            if(row==1){
                if(row+1>=0&&row+1<8&&row+2>=0&&row+2<8) {
                    if (chessboard[row + 1][col] instanceof EmptySlotComponent && chessboard[row + 2][col] instanceof EmptySlotComponent) {
                        movablePoints.add(chessboard[row + 2][col].getSource());
                    }
                }
            }
            if(row+1<8&&row+1>=0){
                if(chessboard[row+1][col] instanceof EmptySlotComponent){movablePoints.add(chessboard[row+1][col].getSource());}
            }
            if(row+1>=0&&col+1>=0&&row+1<8&&col+1<8){
                if(chessboard[row+1][col+1].getChessColor()==ChessColor.WHITE){movablePoints.add(chessboard[row+1][col+1].getSource());}
            }
            if(row+1>=0&&row+1<8&&col-1<8&&col-1>=0){
                if(chessboard[row+1][col-1].getChessColor()==ChessColor.WHITE){movablePoints.add(chessboard[row+1][col-1].getSource());}
            }
        }
        else{
            if(row==6){
                if(row-1>=0&&row-1<8&&row-2>=0&&row-2<8) {
                    if (chessboard[row - 1][col] instanceof EmptySlotComponent && chessboard[row - 2][col] instanceof EmptySlotComponent) {
                        movablePoints.add(chessboard[row - 2][col].getSource());
                    }
                }
            }
            if(row-1<8&&row-1>=0){
                if(chessboard[row-1][col] instanceof EmptySlotComponent){movablePoints.add(chessboard[row-1][col].getSource());}
            }
            if(row-1>=0&&col-1>=0&&row-1<8&&col-1<8){
                if(chessboard[row-1][col-1].getChessColor()==ChessColor.BLACK){movablePoints.add(chessboard[row-1][col-1].getSource());}
            }
            if(row-1>=0&&col-1>=0&&row+1<8&&col+1<8){
                if(chessboard[row-1][col+1].getChessColor()==ChessColor.BLACK){movablePoints.add(chessboard[row-1][col+1].getSource());}
            }

        }
        return movablePoints;
    }
}
