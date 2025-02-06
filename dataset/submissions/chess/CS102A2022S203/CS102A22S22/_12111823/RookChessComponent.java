import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name, int x, int y) {
        this.name = name;
        this.setSource(x, y);
        if (name == 'R') {
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
        int h = 0;
        while (x + h <= 7) {
            chessboardPointList.add(new ChessboardPoint(x + h, y));
            h++;
        }
        h = 0;
        while (x - h >= 0) {
            chessboardPointList.add(new ChessboardPoint(x - h, y));
            h++;
        }
        h = 0;
        while (y + h <= 7) {
            chessboardPointList.add(new ChessboardPoint(x, y + h));
            h++;
        }
        h = 0;
        while (y - h >= 0) {
            chessboardPointList.add(new ChessboardPoint(x, y - h));
            h++;
        }
        return chessboardPointList;
    }
}
