import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessColor color,ChessboardPoint source){
        if (color.equals(ChessColor.BLACK)){
            name = 'P';
            setChessColor(ChessColor.BLACK);
            setSource(source);
        }else {
            name = 'p';
            setChessColor(ChessColor.WHITE);
            setSource(source);
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> MoveTo = new ArrayList<ChessboardPoint>();
        int currentX = this.getSource().getX();
        int currentY = this.getSource().getY();
        if (getChessColor().equals(ChessColor.BLACK) && currentX+1<=7){
            if (chessComponents[currentX+1][currentY].getChessColor().equals(ChessColor.NONE)){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY));
            }
            if ( currentY+1<=7 && chessComponents[currentX+1][currentY+1].getChessColor().equals(ChessColor.WHITE)){
                MoveTo.add(new ChessboardPoint(currentX+1,currentY+1));
            }
            if (currentY-1>=0 && chessComponents[currentX+1][currentY-1].getChessColor().equals(ChessColor.WHITE)){
                MoveTo.add(new ChessboardPoint(currentX+1,currentY-1));
            }
            if (chessComponents[currentX+2][currentY].getChessColor().equals(ChessColor.NONE)
                    && currentX == 1
                    && chessComponents[currentX+1][currentY].getChessColor().equals(ChessColor.NONE)){
                MoveTo.add(new ChessboardPoint(currentX+2,currentY));
            }
        }else if (getChessColor().equals(ChessColor.WHITE) && currentX-1>=0){
            if (chessComponents[currentX-1][currentY].getChessColor().equals(ChessColor.NONE)){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY));
            }
            if ( currentY+1<=7 && chessComponents[currentX-1][currentY+1].getChessColor().equals(ChessColor.BLACK)
                    ){
                MoveTo.add(new ChessboardPoint(currentX-1,currentY+1));
            }
            if (currentY-1>=0 && chessComponents[currentX-1][currentY-1].getChessColor().equals(ChessColor.BLACK)){
                MoveTo.add(new ChessboardPoint(currentX-1,currentY-1));
            }
            if (chessComponents[currentX-2][currentY].getChessColor().equals(ChessColor.NONE)
                    && currentX == 6
                    && chessComponents[currentX-1][currentY].getChessColor().equals(ChessColor.NONE)){
                MoveTo.add(new ChessboardPoint(currentX-2,currentY));
            }
        }
        return MoveTo;
    }
}
