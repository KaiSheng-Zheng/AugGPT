import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {

        super(source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'K';
        } else {
            this.name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ChessboardPoint Destination = getSource().offset(moveByOneStep[i][0], moveByOneStep[i][1]);
            if (Destination != null) {
                if(checkColor(chessBoard[Destination.getX()][Destination.getY()].toString().charAt(0)) != getChessColor())
                {
                    canMoveToPoints.add(Destination);
                }
            }
        }
        return canMoveToPoints;
    }
}
