import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> returnValue = new ArrayList<>();
        ChessboardPoint nowMovingTo;
        for (int i = 0; i < 8; i = i + 2) {
            for (int j = 1; j < 8; j++) {
                nowMovingTo = source.offset(generalMoveDirection[i][0] * j, generalMoveDirection[i][1] * j);
                if (nowMovingTo == null) {
                    break;
                }
                if (chessComponents[source.getX() + generalMoveDirection[i][0] * j][source.getY() + generalMoveDirection[i][1] * j].chessColor == ChessColor.NONE) {
                    returnValue.add(nowMovingTo);
                } else if (chessComponents[source.getX() + generalMoveDirection[i][0] * j][source.getY() + generalMoveDirection[i][1] * j].chessColor != ChessColor.NONE) {
                    if (chessComponents[source.getX() + generalMoveDirection[i][0] * j][source.getY() + generalMoveDirection[i][1] * j].chessColor != this.chessColor) {
                        returnValue.add(nowMovingTo);
                    }
                    break;
                }
            }
        }
        return returnValue;
    }
}
