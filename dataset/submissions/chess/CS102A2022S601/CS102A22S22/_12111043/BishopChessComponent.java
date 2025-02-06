import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public BishopChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int[] dx = {1, -1};
        int[] dy = {1, -1};
        if (name == 'B') {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int x = source.getX();
                    int y = source.getY();
                    for (int k = 0; k < 8; k++) {
                        x += dx[i];
                        y += dy[j];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                            if (chessComponents[x][y].name == 95) {
                                move.add(new ChessboardPoint(x, y));
                            } else if (chessComponents[x][y].name >= 97) {
                                move.add(new ChessboardPoint(x, y));
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }

        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int x = source.getX();
                    int y = source.getY();
                    for (int k = 0; k < 8; k++) {
                        x += dx[i];
                        y += dy[j];
                        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                            if (chessComponents[x][y].name == 95) {
                                move.add(new ChessboardPoint(x, y));
                            } else if (chessComponents[x][y].name <= 90) {
                                move.add(new ChessboardPoint(x, y));
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return move;
    }
}
