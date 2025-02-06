import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name, int x, int y) {
        this.name = name;
        this.setSource(x, y);
        if (name == 'P') {
            this.setChessColor(ChessColor.BLACK);
        } else {
            this.setChessColor(ChessColor.WHITE);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>(5);
        ChessboardPoint s = this.getSource();
        int x = s.getX();
        int y = s.getY();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (y <= 3) {
                chessboardPointList.add(new ChessboardPoint(x, y + 1));
            }
            if (y >= 4 && y < 7) {
                chessboardPointList.add(new ChessboardPoint(x + 1, y));
                chessboardPointList.add(new ChessboardPoint(x - 1, y));
                chessboardPointList.add(new ChessboardPoint(x, y + 1));
            }
            if (y == 7) {
                chessboardPointList.add(new ChessboardPoint(x + 1, y));
                chessboardPointList.add(new ChessboardPoint(x - 1, y));
            }
        } else {
            if (y >= 4) {
                chessboardPointList.add(new ChessboardPoint(x, y - 1));
            }
            if (y <= 3 && y > 0) {
                chessboardPointList.add(new ChessboardPoint(x + 1, y));
                chessboardPointList.add(new ChessboardPoint(x - 1, y));
                chessboardPointList.add(new ChessboardPoint(x, y - 1));
            }
            if (y == 0) {
                chessboardPointList.add(new ChessboardPoint(x + 1, y));
                chessboardPointList.add(new ChessboardPoint(x - 1, y));
            }
        }
        return chessboardPointList;
    }
}
