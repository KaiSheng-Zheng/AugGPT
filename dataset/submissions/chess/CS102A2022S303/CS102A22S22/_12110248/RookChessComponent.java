import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'R' : 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        ChessboardPoint[] newPlace = {
                source.offset(-1, 0),
                source.offset(-2, 0),
                source.offset(-3, 0),
                source.offset(-4, 0),
                source.offset(-5, 0),
                source.offset(-6, 0),
                source.offset(-7, 0),

                source.offset(0, 1),
                source.offset(0, 2),
                source.offset(0, 3),
                source.offset(0, 4),
                source.offset(0, 5),
                source.offset(0, 6),
                source.offset(0, 7),

                source.offset(0, -1),
                source.offset(0, -2),
                source.offset(0, -3),
                source.offset(0, -4),
                source.offset(0, -5),
                source.offset(0, -6),
                source.offset(0, -7),

                source.offset(1, 0),
                source.offset(2, 0),
                source.offset(3, 0),
                source.offset(4, 0),
                source.offset(5, 0),
                source.offset(6, 0),
                source.offset(7, 0)};
        for (int i = 0; i < 7; i++) {
            if (newPlace[i]==null){
                break;
            }
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) == chessColor){
                break;
            }
            moveTo.add(newPlace[i]);
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) != ChessColor.NONE){
                break;
            }
        }
        for (int i = 7; i < 14; i++) {
            if (newPlace[i]==null){
                break;
            }
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) == chessColor){
                break;
            }
            moveTo.add(newPlace[i]);
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) != ChessColor.NONE){
                break;
            }
        }
        for (int i = 14; i < 21; i++) {
            if (newPlace[i]==null){
                break;
            }
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) == chessColor){
                break;
            }
            moveTo.add(newPlace[i]);
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) != ChessColor.NONE){
                break;
            }
        }
        for (int i = 21; i < 28; i++) {
            if (newPlace[i]==null){
                break;
            }
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) == chessColor){
                break;
            }
            moveTo.add(newPlace[i]);
            if (getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) != ChessColor.NONE){
                break;
            }
        }
        return moveTo;
    }

}