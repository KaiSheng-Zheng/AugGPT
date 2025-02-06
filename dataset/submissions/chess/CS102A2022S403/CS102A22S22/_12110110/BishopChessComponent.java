import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        for (int i=0; i<4; i++){
            for (int j=1; j <=7; j++) {
                int[] xx = {sourceX + j, sourceX + j, sourceX - j, sourceX - j};
                int[] yy = {sourceY + j, sourceY - j, sourceY + j, sourceY - j};
                if (xx[i] >= 0 && xx[i] <= 7 && yy[i] >= 0 && yy[i] <= 7) {
                    if (chessComponents[xx[i]][yy[i]].getName() == '_') {
                        movePointList.add(new ChessboardPoint(xx[i], yy[i]));
                    } else if (chessComponents[xx[i]][yy[i]].getChessColor() == color) {
                        break;
                    } else if (chessComponents[xx[i]][yy[i]].getChessColor() == oppositeColor) {
                        movePointList.add(new ChessboardPoint(xx[i], yy[i]));
                        break;
                    }
                }
            }
        }
        return movePointList;
    }
}
