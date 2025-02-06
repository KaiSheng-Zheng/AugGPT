import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor color,ChessboardPoint source){
        if (color.equals(ChessColor.BLACK)){
            name = 'R';
            setChessColor(ChessColor.BLACK);
            setSource(source);
        }else {
            name = 'r';
            setChessColor(ChessColor.WHITE);
            setSource(source);
        }

    }


    public List<ChessboardPoint> canMoveTo() {
        int currentX = this.getSource().getX();
        int currentY = this.getSource().getY();
        List<ChessboardPoint> MoveTo = new ArrayList<ChessboardPoint>();
        int i =1;
        while (currentX+i<=7 && !chessComponents[currentX+i][currentY].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX+i,currentY));

            if (chessComponents[currentX+i][currentY].getChessColor().equals(getChessColor().gatInverseColor(getChessColor()))){
                break;
            }
            i++;
        }
        i = 1;
        while (currentX-i>=0 && !chessComponents[currentX-i][currentY].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX-i,currentY));

            if (chessComponents[currentX-i][currentY].getChessColor().equals(getChessColor().gatInverseColor(getChessColor()))){
                break;
            }
            i++;
        }
        i = 1;
        while (currentY-i>=0 && !chessComponents[currentX][currentY-i].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX,currentY-i));

            if (chessComponents[currentX][currentY-i].getChessColor().equals(getChessColor().gatInverseColor(getChessColor()))){
                break;
            }
            i++;
        }
        i = 1;
        while (currentY+i<=7 && !chessComponents[currentX][currentY+i].getChessColor().equals(getChessColor())){
            MoveTo.add(new ChessboardPoint(currentX,currentY+i));

            if (chessComponents[currentX][currentY+i].getChessColor().equals(getChessColor().gatInverseColor(getChessColor()))){
                break;
            }
            i++;
        }

        return MoveTo;
    }
}
