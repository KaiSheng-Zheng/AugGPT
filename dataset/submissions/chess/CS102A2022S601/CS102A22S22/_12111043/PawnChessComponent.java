import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int x = source.getX();
        int y = source.getY();
        if (name == 'P') {
            if (x == 1) {
                if (chessComponents[2][y].name == 95) {
                    move.add(new ChessboardPoint(2, y));
                    if (chessComponents[3][y].name == 95) {
                        move.add(new ChessboardPoint(3, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[2][y - 1].name >= 97) {
                        move.add(new ChessboardPoint(2, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[2][y + 1].name >= 97) {
                        move.add(new ChessboardPoint(2, y + 1));
                    }
                }
            } else if (x < 7) {
                if (chessComponents[x + 1][y].name == 95) {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x + 1][y - 1].name >= 97) {
                        move.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x + 1][y + 1].name >= 97) {
                        move.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
            }
        } else {
            if (x == 6) {
                if (chessComponents[5][y].name == 95) {
                    move.add(new ChessboardPoint(5, y));
                    if (chessComponents[4][y].name == 95) {
                        move.add(new ChessboardPoint(4, y));
                    }
                }
                if (y - 1 >= 0) {
                    if (chessComponents[5][y - 1].name <=90) {
                        move.add(new ChessboardPoint(5, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[5][y + 1].name <=90) {
                        move.add(new ChessboardPoint(5, y + 1));
                    }
                }
            } else if (x > 0) {
                if (chessComponents[x - 1][y].name == 95) {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (y - 1 >= 0) {
                    if (chessComponents[x - 1][y - 1].name <=90) {
                        move.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
                if (y + 1 < 8) {
                    if (chessComponents[x - 1][y + 1].name <=90) {
                        move.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
            }
        }
        return move;
    }
}
