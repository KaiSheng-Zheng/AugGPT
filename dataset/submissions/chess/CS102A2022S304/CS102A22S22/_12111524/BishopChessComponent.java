import java.util.ArrayList;
import java.util.List;


public class BishopChessComponent extends ChessComponent {


    // Constructor
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        // Attributes
        ChessboardPoint sourceCoordinate = getSource();
        int sourceX = sourceCoordinate.getX();
        int sourceY = sourceCoordinate.getY();
        ChessComponent[][] chessComponents = getChessComponents();
        List<ChessboardPoint> result = new ArrayList<>();

        // Operations

        //P
        //PP
        for (int cnt = 1; cnt < 8; cnt++) {

            int x = sourceX + cnt;
            int y = sourceY + cnt;

            if (x >= 0 && y >= 0 &&
                    x <= 7 && y <= 7) {

                if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                    break;
                } else if (chessComponents[x][y].getChessColor() == this.getChessColorInverse()) {
                    result.add(new ChessboardPoint(x, y));
                    break;
                } else if (chessComponents[x][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x, y));
                }

            }
        }
        //PN
        for (int cnt = 1; cnt < 8; cnt++) {

            int x = sourceX - cnt;
            int y = sourceY - cnt;

            if (x >= 0 && y >= 0 &&
                    x <= 7 && y <= 7) {

                if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                    break;
                } else if (chessComponents[x][y].getChessColor() == this.getChessColorInverse()) {
                    result.add(new ChessboardPoint(x, y));
                    break;
                } else if (chessComponents[x][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x, y));
                }

            }

        }

        //N
        int coordinateSum = sourceX + sourceY;
        //NP
        for (int x = sourceX - 1; x >= 0; x--) {

            int y = coordinateSum - x;

            if (x >= 0 && y >= 0 &&
                    x <= 7 && y <= 7) {

                if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                    break;
                } else if (chessComponents[x][y].getChessColor() == this.getChessColorInverse()) {
                    result.add(new ChessboardPoint(x, y));
                    break;
                } else if (chessComponents[x][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x, y));
                }

            }

        }
        //NN
        for (int x = sourceX + 1; x <= coordinateSum; x++) {

            int y = coordinateSum - x;

            if (x >= 0 && y >= 0 &&
                    x <= 7 && y <= 7) {

                if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                    break;
                } else if (chessComponents[x][y].getChessColor() == this.getChessColorInverse()) {
                    result.add(new ChessboardPoint(x, y));
                    break;
                } else if (chessComponents[x][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x, y));
                }

            }

        }

        // Return
        return result;

    }


}



