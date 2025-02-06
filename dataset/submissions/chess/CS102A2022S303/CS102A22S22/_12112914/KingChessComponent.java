import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color,ChessboardPoint source){
        if (color.equals(ChessColor.BLACK)){
            name = 'K';
           setChessColor(ChessColor.BLACK);
           setSource(source);
        }else {
            name = 'k';
        setChessColor(ChessColor.WHITE);
        setSource(source);}

    }
    @Override
    public  List<ChessboardPoint> canMoveTo(){
        int currentX = this.getSource().getX();
        int currentY = this.getSource().getY();
        List<ChessboardPoint> MoveTo = new ArrayList<ChessboardPoint>();

        if (currentX+1<=7 && !chessComponents[currentX+1][currentY].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY));
        }
        if (currentX-1>=0 && !chessComponents[currentX-1][currentY].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY));
        }
        if (currentY-1>=0 && !chessComponents[currentX][currentY-1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX,currentY-1));
        }
        if (currentY+1<=7 && !chessComponents[currentX][currentY+1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX,currentY+1));
        }
        if (currentX+1<=7 && currentY-1>=0 && !chessComponents[currentX+1][currentY-1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY-1));
        }
        if (currentX+1<=7 && currentY+1<=7 && !chessComponents[currentX+1][currentY+1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+1,currentY+1));
        }
        if (currentX-1>=0 && currentY-1>=0 && !chessComponents[currentX-1][currentY-1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY-1));
        }
        if (currentX-1>=0 && currentY+1<=7 && !chessComponents[currentX-1][currentY+1].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-1,currentY+1));
        }
        return MoveTo;
    }

}
