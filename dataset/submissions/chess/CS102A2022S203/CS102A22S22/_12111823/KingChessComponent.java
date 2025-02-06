import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(char name, int x, int y) {
        this.name = name;
        setSource(x, y);
        if (name == 'K') {
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
        if (x != 0 && x != 7 && y != 0 && y != 7) {
            chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
        }
        if (x == 0 && y != 0 && y != 7) {
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x == 7 && y != 0 && y != 7) {
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (y == 0 && x != 0 && x != 7) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (y == 7 && x != 0 && x != 7) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x == 0 && y == 0) {
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
        }
        if (x == 0 && y == 7) {
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x + 1, y));
            chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
        }
        if (x == 7 && y == 0) {
            chessboardPointList.add(new ChessboardPoint(x, y + 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
        }
        if (x == 7 && y == 7) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x, y - 1));
            chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
        }
        return chessboardPointList;
    }


}

