import java.util.LinkedList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if(chessColor==ChessColor.WHITE){
            this.name='p';
        }else {
            this.name = 'P';
        }
        this.setChessColor(chessColor);
        this.setSource(source);
    }
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> coordinates = new LinkedList<>();
        ChessColor selectColor = chessComponents[x][y].getChessColor();
        if (selectColor == ChessColor.BLACK) {

            if ((getSource().offset(2, 0) != null)&&(getSource().offset(1, 0) != null)) {
                if ((x == 1 && chessComponents[x+2][y].getChessColor() == ChessColor.NONE)&&
                        (chessComponents[x+1][y].getChessColor() == ChessColor.NONE)) {
                    coordinates.add(getSource().offset(2, 0));
                }
            }
            if ((getSource().offset(1, 0) != null)) {
                if ((chessComponents[x + 1][y].getChessColor() == ChessColor.NONE)) {
                    coordinates.add(getSource().offset(1, 0));
                }
                if ((getSource().offset(1, 1) != null)) {
                    if ((chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE)) {
                        coordinates.add(getSource().offset(1, 1));
                    }
                }
                if ((getSource().offset(1, -1) != null)) {
                    if ((chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE)) {
                        coordinates.add(getSource().offset(1, -1));
                    }
                }
            }
            return coordinates;
        }
        if (selectColor == ChessColor.WHITE) {
            if (getSource().offset(-2, 0) != null&&getSource().offset(-1, 0) != null) {
                if (x == 6 && chessComponents[x-2][y].getChessColor() == ChessColor.NONE&&
                        chessComponents[x-1][y].getChessColor() == ChessColor.NONE) {
                    coordinates.add(getSource().offset(-2, 0));
                }
            }
            if ((getSource().offset(-1, 0) != null)) {
                    if ((chessComponents[x - 1][y].getChessColor() == ChessColor.NONE)) {
                        coordinates.add(getSource().offset(-1, 0));
                    }
                }
            
                if ((getSource().offset(-1, 1) != null)) {
                    if ((chessComponents[x - 1][y + 1].getChessColor() == ChessColor.BLACK)) {
                        coordinates.add(getSource().offset(-1, 1));
                    }
                }
            
                if ((getSource().offset(-1, -1) != null)) {
                    if ((chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK)) {
                        coordinates.add(getSource().offset(-1, -1));
                    }
                }
            
            return coordinates;
        }
        return coordinates;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}
