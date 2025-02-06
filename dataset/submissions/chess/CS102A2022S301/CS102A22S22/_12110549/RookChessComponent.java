import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo =new ArrayList<>();
        int x=source.getX(),y =source.getY();
        for (int i = 1; i < 8; i++) {
            if (x + i >= 0 && x + i <= 7) {
                if (getComponentColor(chessboard[x + i][y].toString().charAt(0)) == ChessColor.NONE) {
                    moveTo.add(new ChessboardPoint(x + i, y));
                } else if (getComponentColor(chessboard[x + i][y].toString().charAt(0)) != chessColor) {
                    moveTo.add(new ChessboardPoint(x + i, y));
                    break;
                } else
                    break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (x - i >= 0 && x - i <= 7) {
                if (getComponentColor(chessboard[x - i][y].toString().charAt(0)) == ChessColor.NONE) {
                    moveTo.add(new ChessboardPoint(x - i, y));
                } else if (getComponentColor(chessboard[x - i][y].toString().charAt(0)) != chessColor) {
                    moveTo.add(new ChessboardPoint(x - i, y));
                    break;
                } else
                    break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (y + i >= 0 && y + i <= 7) {
                if (getComponentColor(chessboard[x][y + i].toString().charAt(0)) == ChessColor.NONE) {
                    moveTo.add(new ChessboardPoint(x, y + i));
                } else if (getComponentColor(chessboard[x][y + i].toString().charAt(0)) != chessColor) {
                    moveTo.add(new ChessboardPoint(x, y + i));
                    break;
                } else
                    break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if ( y - i >= 0 && y - i <= 7){
                if (getComponentColor(chessboard[x][y - i].toString().charAt(0)) == ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x, y-i));
                }else if (getComponentColor(chessboard[x][y - i].toString().charAt(0))  != chessColor) {
                    moveTo.add(new ChessboardPoint(x, y-i));
                    break;
                }else
                    break;
            }
        }
        return moveTo;
    }
}