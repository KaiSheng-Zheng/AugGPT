import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessComponent[][] c;
    int a =0;
    public PawnChessComponent(char name, int x, int y, ChessComponent[][] c) {
        this.c=c;
        if (name == 'p') {
            this.name = name;
            this.setChessColor(ChessColor.WHITE);
            this.setSource(new ChessboardPoint(x, y));
        }
        if (name == 'P') {
            this.name = name;
            this.setChessColor(ChessColor.BLACK);
            this.setSource(new ChessboardPoint(x, y));
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
            if (this.getChessColor() == ChessColor.WHITE) {
                if (x == 6) {
                    if (c[x - 1][y].name == '_')
                        list.add(new ChessboardPoint(x - 1, y));
                    if (c[x - 1][y].name == '_' && c[x - 2][y].name == '_')
                        list.add(new ChessboardPoint(x - 2, y));
                    this.find(x, y, -1, -1, list);
                    this.find(x, y, -1, 1, list);
                } else {
                    if (x > 0 && c[x - 1][y].name == '_')
                        list.add(new ChessboardPoint(x - 1, y));
                    this.find(x, y, -1, -1, list);
                    this.find(x, y, -1, 1, list);
                }
            }
            if (this.getChessColor() == ChessColor.BLACK) {
                if (x == 1) {
                    if (c[x + 1][y].name == '_')
                        list.add(new ChessboardPoint(x + 1, y));
                    if (c[x + 1][y].name == '_' && c[x + 2][y].name == '_')
                        list.add(new ChessboardPoint(x + 2, y));
                    this.find(x, y, 1, -1, list);
                    this.find(x, y, 1, 1, list);
                } else {
                    if (x < 7 && c[x + 1][y].name == '_')
                        list.add(new ChessboardPoint(x + 1, y));
                    this.find(x, y, 1, -1, list);
                    this.find(x, y, 1, 1, list);
                }
            }
        return list;
    }

    public void find(int x, int y, int xmove, int ymove, List<ChessboardPoint> list) {
        int X = x + xmove;
        int Y = y + ymove;
        if (X >= 0 && X < 8 && Y >= 0 && Y < 8) {
            if (c[X][Y].name != '_' && c[X][Y].getChessColor() != this.getChessColor())
                list.add(new ChessboardPoint(X, Y));
        }
    }
}
