import java.util.ArrayList;
import java.util.List;

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'P' : 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        ChessboardPoint[] newPlace = {
                source.offset(-1, 0),
                source.offset(-2, 0),
                source.offset(-1, 1),
                source.offset(-1, -1),
                source.offset(1, 0),
                source.offset(2, 0),
                source.offset(1, 1),
                source.offset(1, -1)};
        //white
        //straight1
        if (chessColor == ChessColor.WHITE && newPlace[0] != null &&
                getComponentColor(chessboard[newPlace[0].getX()][newPlace[0].getY()].toString().charAt(0)) == ChessColor.NONE) {
            moveTo.add(newPlace[0]);
        }
        //1eat
        if (chessColor == ChessColor.WHITE &&
                newPlace[2] != null &&
                getComponentColor(chessboard[newPlace[2].getX()][newPlace[2].getY()].toString().charAt(0)) == ChessColor.BLACK) {
            moveTo.add(newPlace[2]);
        }
        //2eat
        if (chessColor == ChessColor.WHITE &&
                newPlace[3] != null &&
                getComponentColor(chessboard[newPlace[3].getX()][newPlace[3].getY()].toString().charAt(0)) == ChessColor.BLACK) {
            moveTo.add(newPlace[3]);
        }
        //straight2
        if (chessColor == ChessColor.WHITE &&
                source.getX() == 6 &&
                newPlace[1] != null &&
                getComponentColor(chessboard[newPlace[0].getX()][newPlace[0].getY()].toString().charAt(0)) == ChessColor.NONE &&
                getComponentColor(chessboard[newPlace[1].getX()][newPlace[1].getY()].toString().charAt(0)) == ChessColor.NONE) {
            moveTo.add(newPlace[1]);
        }


        //black
        //straight1
        if (chessColor == ChessColor.BLACK && newPlace[4] != null &&
                getComponentColor(chessboard[newPlace[4].getX()][newPlace[4].getY()].toString().charAt(0)) == ChessColor.NONE) {
            moveTo.add(newPlace[4]);
        }
        //1eat
        if (chessColor == ChessColor.BLACK &&
                newPlace[6] != null &&
                getComponentColor(chessboard[newPlace[6].getX()][newPlace[6].getY()].toString().charAt(0)) == ChessColor.WHITE) {
            moveTo.add(newPlace[6]);
        }
        //2eat
        if (chessColor == ChessColor.BLACK &&
                newPlace[7] != null &&
                getComponentColor(chessboard[newPlace[7].getX()][newPlace[7].getY()].toString().charAt(0)) == ChessColor.WHITE) {
            moveTo.add(newPlace[7]);
        }
        //straight2
        if (chessColor == ChessColor.BLACK &&
                source.getX() == 1 &&
                newPlace[5] != null &&
                getComponentColor(chessboard[newPlace[4].getX()][newPlace[4].getY()].toString().charAt(0)) == ChessColor.NONE &&
                getComponentColor(chessboard[newPlace[5].getX()][newPlace[5].getY()].toString().charAt(0)) == ChessColor.NONE) {
            moveTo.add(newPlace[5]);
        }

        return moveTo;
    }

}
