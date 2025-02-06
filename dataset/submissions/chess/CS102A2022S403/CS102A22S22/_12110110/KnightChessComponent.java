import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movePointList = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.chessComponentsStatic;
        int sourceX = super.getSource().getX();
        int sourceY = super.getSource().getY();
        ChessColor color = super.getChessColor();
        ChessColor oppositeColor = (color == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
        for (int i = 0; i < 8; i++) {
            int[] xx = {sourceX + 2, sourceX + 2, sourceX - 2, sourceX - 2, sourceX + 1, sourceX + 1, sourceX - 1, sourceX - 1};
            int[] yy = {sourceY + 1, sourceY - 1, sourceY + 1, sourceY - 1, sourceY + 2, sourceY - 2, sourceY + 2, sourceY - 2};
            if (xx[i] >= 0 && xx[i] <= 7 && yy[i] >= 0 && yy[i] <= 7) {
                if (chessComponents[xx[i]][yy[i]].getName() == '_') {
                    movePointList.add(new ChessboardPoint(xx[i], yy[i]));
                } else if (chessComponents[xx[i]][yy[i]].getChessColor() == oppositeColor) {
                    movePointList.add(new ChessboardPoint(xx[i], yy[i]));
                }
            }
        }
        return movePointList;
    }
}
