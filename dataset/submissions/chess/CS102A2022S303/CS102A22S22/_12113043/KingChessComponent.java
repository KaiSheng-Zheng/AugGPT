import java.util.*;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();
        int count = 0;
        List<ChessboardPoint> output = new ArrayList<>();
        if (x - 1 >= 0) {
            if (chessComponents[x - 1][y].getChessColor() !=getChessColor() ) {
                ChessboardPoint e = new ChessboardPoint(x - 1, y);
                count++;
                output.add(e);
            }
        }
        if (x + 1 <= 7) {
            if (chessComponents[x + 1][y].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x + 1, y);
                count++;
                output.add(e);
            }
        }
        if (y - 1 >= 0) {
            if (chessComponents[x][y - 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x, y - 1);
                count++;
                output.add(e);
            }
        }
        if (y + 1 <= 7) {
            if (chessComponents[x][y + 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x, y + 1);
                count++;
                output.add(e);
            }
        }
        if (x + 1 <= 7 & y + 1 <= 7) {
            if (chessComponents[x + 1][y + 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x + 1, y + 1);
                count++;
                output.add(e);
            }
        }
        if (x + 1 <= 7 & y - 1 >= 0) {
            if (chessComponents[x + 1][y - 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x + 1, y - 1);
                count++;
                output.add(e);
            }
        }
        if (x - 1 >= 0 & y + 1 <= 7) {
            if (chessComponents[x - 1][y + 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x - 1, y + 1);
                count++;
                output.add(e);
            }
        }
        if (x - 1 >= 0 & y - 1 >= 0) {
            if (chessComponents[x - 1][y - 1].getChessColor() != getChessColor()) {
                ChessboardPoint e = new ChessboardPoint(x - 1, y - 1);
                count++;
                output.add(e);
            }
        }
        if (count > 0) {
            return output;
        } else {
            return new ArrayList<>();
        }
    }
}

