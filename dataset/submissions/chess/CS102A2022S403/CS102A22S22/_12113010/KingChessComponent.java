import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessComponent[][] c;

    public KingChessComponent(char name, int x, int y, ChessComponent[][] chess) {
        this.c = chess;
        if (name == 'k') {
            this.name = name;
            this.setChessColor(ChessColor.WHITE);
            this.setSource(new ChessboardPoint(x, y));
        }
        if (name == 'K') {
            this.name = name;
            this.setChessColor(ChessColor.BLACK);
            this.setSource(new ChessboardPoint(x, y));
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        this.find(x, y, 1, 0, list);
        this.find(x, y, -1, 0, list);
        this.find(x, y, 0, 1, list);
        this.find(x, y, 0, -1, list);
        this.find(x, y, 1, 1, list);
        this.find(x, y, 1, -1, list);
        this.find(x, y, -1, 1, list);
        this.find(x, y, -1, -1, list);

        return list;
    }

    public void find(int x, int y, int xmove, int ymove, List<ChessboardPoint> list) {
        int X = x + xmove;
        int Y = y + ymove;
        if (X >= 0 && X < 8 && Y >= 0 && Y < 8) {
            if (c[X][Y].name == '_')
                list.add(new ChessboardPoint(X, Y));
            else if (c[X][Y].getChessColor() != this.getChessColor())
                list.add(new ChessboardPoint(X, Y));
        }
    }
}