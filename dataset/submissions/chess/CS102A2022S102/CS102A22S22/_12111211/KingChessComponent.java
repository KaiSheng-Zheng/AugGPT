import java.util.LinkedList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if(chessColor==ChessColor.WHITE){
            this.name='k';
        }else {
            this.name = 'K';
        }
        this.setChessColor(chessColor);
        this.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> coordinates = new LinkedList<>();
        ChessColor selectColor =chessComponents[x][y].getChessColor();

        if (getSource().offset(1,1)!=null){
            if ( (chessComponents[x+1][y+1].getChessColor()!=selectColor)){
                coordinates.add(getSource().offset(1, 1));
            }
        }


        if (getSource().offset(-1,1)!=null) {
            if (chessComponents[x- 1][y + 1].getChessColor() != selectColor) {
                coordinates.add(getSource().offset(-1, 1));
            }
        }
        if (getSource().offset(1,-1)!=null) {
            if (chessComponents[x + 1][y - 1].getChessColor() != selectColor) {
                coordinates.add(getSource().offset(1, -1));
            }
        }
        if ((getSource().offset(-1,-1)!=null)) {
            if ((chessComponents[x - 1][y - 1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(-1, -1));
            }
        }
        if ((getSource().offset(0,1)!=null)) {
            if ((chessComponents[x][y+1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(0, 1));
            }
        }
        if ((getSource().offset(0,-1)!=null)) {
            if ((chessComponents[x][y-1].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(0, -1));
            }
        }
        if ((getSource().offset(1,0)!=null)) {
            if ((chessComponents[x+1][y].getChessColor() != selectColor)) {
                coordinates.add(getSource().offset(1, 0));
            }
        }
        if ((getSource().offset(-1,0)!=null)) {
            if ((chessComponents[x-1 ][y].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(-1, 0));
            }
        }
        return coordinates;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
