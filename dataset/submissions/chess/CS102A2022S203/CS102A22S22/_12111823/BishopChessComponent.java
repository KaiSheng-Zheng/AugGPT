import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(char name, int x, int y) {
        this.name = name;
        this.setSource(x, y);
        if (name == 'B') {
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

        for (int i = 0; x + i <= 7 || y + i <= 7; i++) {
            chessboardPointList.add(new ChessboardPoint(x + i, y + i));
        }
        for (int i = 0; x - i >= 0 || y - i >= 0; i++) {
            chessboardPointList.add(new ChessboardPoint(x - i, y - i));
        }
        for (int i = 0; x + i <= 7 || y - i >= 0; i++) {
            chessboardPointList.add(new ChessboardPoint(x + i, y - i));
        }
        for (int i = 0; x - i >= 0 || y + i <= 7; i++) {
            chessboardPointList.add(new ChessboardPoint(x - i, y + i));
        }
        return chessboardPointList;
    }
}
