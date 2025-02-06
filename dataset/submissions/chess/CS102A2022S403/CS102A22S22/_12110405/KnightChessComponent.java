import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {

        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'N';
        } else {
            this.name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        ChessboardPoint Destination1 = getSource().offset(-2, -1);
        if (Destination1 != null) {
            if (checkColor(chessBoard[Destination1.getX()][Destination1.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination1);
            }
        }
        ChessboardPoint Destination2 = getSource().offset(2, -1);
        if (Destination2 != null) {
            if (checkColor(chessBoard[Destination2.getX()][Destination2.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination2);
            }
        }
        ChessboardPoint Destination3 = getSource().offset(-2, 1);
        if (Destination3 != null) {
            if (checkColor(chessBoard[Destination3.getX()][Destination3.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination3);
            }
        }   ChessboardPoint Destination4 =getSource().offset(2, 1);
        if (Destination4 != null) {
            if (checkColor(chessBoard[Destination4.getX()][Destination4.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination4);
            }
        }   ChessboardPoint Destination5 =getSource().offset(1, -2);
        if (Destination5 != null) {
            if (checkColor(chessBoard[Destination5.getX()][Destination5.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination5);
            }
        }   ChessboardPoint Destination6 =getSource().offset(1, 2);
        if (Destination6 != null) {
            if (checkColor(chessBoard[Destination6.getX()][Destination6.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination6);
            }
        }   ChessboardPoint Destination7 =getSource().offset(-1, 2);
        if (Destination7 != null) {
            if (checkColor(chessBoard[Destination7.getX()][Destination7.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination7);
            }
        }   ChessboardPoint Destination8 =getSource().offset(-1, -2);
        if (Destination8 != null) {
            if (checkColor(chessBoard[Destination8.getX()][Destination8.getY()].toString().charAt(0)) != getChessColor()) {
                canMoveToPoints.add(Destination8);
            }
        }
        return canMoveToPoints;
    }
}
