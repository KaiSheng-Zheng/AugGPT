import java.util.LinkedList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if(chessColor==ChessColor.WHITE){
            this.name='n';
        }else {
            this.name = 'N';
        }
        this.setChessColor(chessColor);
        this.setSource(source);
    }
    public List<ChessboardPoint> canMoveTo(){
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> coordinates = new LinkedList<>();
        ChessColor selectColor =chessComponents[x][y].getChessColor();

        if ((getSource().offset(2,1)!=null)) {
            if ((chessComponents[x + 2][y + 1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(2, 1));
            }
        }

        if ((getSource().offset(1,2)!=null)) {
            if ((chessComponents[x + 1][y + 2].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(1, 2));
            }
        }

        if ((getSource().offset(-1,2)!=null)) {
            if ((chessComponents[x -1][y + 2].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(-1, 2));
            }
        }
        if ((getSource().offset(-2,1)!=null)) {
            if ((chessComponents[x-2][y +1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(-2, 1));
            }
        }
        if ((getSource().offset(-2,-1)!=null)) {
            if ((chessComponents[x- 2][y - 1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(-2, -1));
            }
        }
        if ((getSource().offset(-1,-2)!=null)) {
            if ((chessComponents[x-1][y - 2].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(-1, -2));
            }
        }
        if ((getSource().offset(1,-2)!=null)) {
            if ((chessComponents[x+1][y -2].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(1, -2));
            }
        }
        if ((getSource().offset(2,-1)!=null)) {
            if ((chessComponents[x+2][y -1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(2, -1));
            }
        }

        return coordinates;
    }
    public String toString() {
        return String.valueOf(this.name);
    }
}

