import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        super(source,chessColor);
        if (chessColor == ChessColor.BLACK){
            this.name = 'P';}
        else if (chessColor == ChessColor.WHITE){
            this.name = 'p';}
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
        int x = getSource().getX(); int y = getSource().getY();
        if(getChessColor() == ChessColor.WHITE){
            if(x-1 >= 0 && getComponentColor(chessBoard[x-1][y].toString().charAt(0)) == ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x-1,y));
                if(x == 6 && getComponentColor(chessBoard[x-2][y].toString().charAt(0)) == ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x-2,y));
                }
            }
            if(y >= 1 && getComponentColor(chessBoard[x-1][y-1].toString().charAt(0)) == ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y-1));
            }
            if(y < 7 && getComponentColor(chessBoard[x-1][y+1].toString().charAt(0)) == ChessColor.BLACK){
                moveTo.add(new ChessboardPoint(x-1,y+1));
            }
        }
        else if(getChessColor() == ChessColor.BLACK){
            if(x < 7 && getComponentColor(chessBoard[x+1][y].toString().charAt(0)) == ChessColor.NONE){
                moveTo.add(new ChessboardPoint(x+1,y));
                if(x == 1 && getComponentColor(chessBoard[x+2][y].toString().charAt(0)) == ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+2,y));
                }
            }
            if(y >= 1  && getComponentColor(chessBoard[x+1][y-1].toString().charAt(0)) == ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y-1));
            }
            if(y < 7 && getComponentColor(chessBoard[x+1][y+1].toString().charAt(0)) == ChessColor.WHITE){
                moveTo.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return moveTo;
    }



}

