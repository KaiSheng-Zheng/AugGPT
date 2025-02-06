import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color,ChessboardPoint source){
        if (color.equals(ChessColor.BLACK)){
            name = 'N';
            setChessColor(ChessColor.BLACK);
            setSource(source);
        }else {
            name = 'n';
            setChessColor(ChessColor.WHITE);
            setSource(source);
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int currentX = this.getSource().getX();
        int currentY = this.getSource().getY();
        List<ChessboardPoint> MoveTo = new ArrayList<ChessboardPoint>();

        if (currentX+1<=7 && currentY-2>=0 && !chessComponents[currentX+1][currentY-2].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY-2));
        }
        if (currentX+1<=7 && currentY+2<=7 && !chessComponents[currentX+1][currentY+2].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY+2));
        }
        if (currentX-1>=0 && currentY-2>=0 && !chessComponents[currentX-1][currentY-2].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY-2));
        }
        if (currentX-1>=0 && currentY+2<=7 && !chessComponents[currentX-1][currentY+2].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY+2));
        }
        if (currentX+2<=7 && currentY-1>=0 && !chessComponents[currentX+2][currentY-1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+2,currentY-1));
        }
        if (currentX+2<=7 && currentY+1<=7 && !chessComponents[currentX+2][currentY+1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+2,currentY+1));
        }
        if (currentX-2>=0 && currentY-1>=0 && !chessComponents[currentX-2][currentY-1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-2,currentY-1));
        }
        if (currentX-2>=0 && currentY+1<=7 && !chessComponents[currentX-2][currentY+1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-2,currentY+1));
        }
        return MoveTo;
    }
}
