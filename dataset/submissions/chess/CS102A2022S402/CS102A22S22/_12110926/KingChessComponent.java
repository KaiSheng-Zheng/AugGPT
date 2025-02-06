import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public KingChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name=name;
        this.chessComponents=chessComponents;
        this.source=source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        int x = source.getX();
        int y = source.getY();
        int flag1 = 92;
        int flag2 = 96;
        if (name == 'K') {
            if ((x > 0 && x < 7) && (y > 0 && y < 7)) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (chessComponents[x + dx[i]][y + dy[j]].name > flag1) {
                            move.add(new ChessboardPoint(x + dx[i], y + dy[j]));
                        }
                    }
                }
            }
            if (x == 0 && y > 0 && y < 7) {
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x][y + dy[j]].name > flag1) {
                        move.add(new ChessboardPoint(x, y + dy[j]));
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x + 1][y + dy[j]].name > flag1) {
                        move.add(new ChessboardPoint(x + 1, y + dy[j]));
                    }
                }
            }
            if (x == 7 && y > 0 && y < 7) {
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x - 1][y + dy[j]].name > flag1) {
                        move.add(new ChessboardPoint(x - 1, y + dy[j]));
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x][y + dy[j]].name > flag1) {
                        move.add(new ChessboardPoint(x, y + dy[j]));
                    }
                }

            }
            if (y == 0 && x > 0 && x < 7) {
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y].name > flag1) {
                        move.add(new ChessboardPoint(x + dx[i], y));
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y + 1].name > flag1) {
                        move.add(new ChessboardPoint(x + dx[i], y + 1));
                    }
                }
            }
            if (y == 7 && x > 0 && x < 7) {
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y].name > flag1) {
                        move.add(new ChessboardPoint(x + dx[i], y));
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y-1].name > flag1) {
                        move.add(new ChessboardPoint(x + dx[i], y-1));
                    }
                }
            }
            if (x == 0 && y == 0) {
                if (chessComponents[x + 1][y].name > flag1) {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (chessComponents[x][y + 1].name > flag1) {
                    move.add(new ChessboardPoint(x, y + 1));
                }
                if (chessComponents[x + 1][y + 1].name > flag1) {
                    move.add(new ChessboardPoint(x + 1, y + 1));
                }
            }
            if (x == 7 && y == 0) {
                if (chessComponents[x - 1][y].name > flag1) {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x][y + 1].name > flag1) {
                    move.add(new ChessboardPoint(x, y + 1));
                }
                if (chessComponents[x - 1][y + 1].name > flag1) {
                    move.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
            if (x == 0 && y == 7) {
                if (chessComponents[x + 1][y].name > flag1) {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (chessComponents[x][y - 1].name > flag1) {
                    move.add(new ChessboardPoint(x, y - 1));
                }
                if (chessComponents[x + 1][y - 1].name > flag1) {
                    move.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (x == 7 && y == 7) {
                if (chessComponents[x - 1][y].name > flag1) {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x][y - 1].name > flag1) {
                    move.add(new ChessboardPoint(x, y - 1));
                }
                if (chessComponents[x - 1][y - 1].name > flag1) {
                    move.add(new ChessboardPoint(x - 1, y - 1));
                }
            }
        }



        if (name=='k') {
            if ((x > 0 && x < 7) && (y > 0 && y < 7)) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (chessComponents[x + dx[i]][y + dy[j]].name < flag2) {
                            move.add(new ChessboardPoint(x + dx[i], y + dy[j]));
                        }
                    }
                }
            }
            if (x == 0 && y > 0 && y < 7) {
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x][y + dy[j]].name < flag2) {
                        move.add(new ChessboardPoint(x, y + dy[j]));
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x + 1][y + dy[j]].name < flag2) {
                        move.add(new ChessboardPoint(x + 1, y + dy[j]));
                    }
                }
            }
            if (x == 7 && y > 0 && y < 7) {
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x - 1][y + dy[j]].name < flag2) {
                        move.add(new ChessboardPoint(x - 1, y + dy[j]));
                    }
                }
                for (int j = 0; j < 3; j++) {
                    if (chessComponents[x][y + dy[j]].name < flag2) {
                        move.add(new ChessboardPoint(x, y + dy[j]));
                    }
                }

            }
            if (y == 0 && x > 0 && x < 7) {
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y].name < flag2) {
                        move.add(new ChessboardPoint(x + dx[i], y));
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y + 1].name < flag2) {
                        move.add(new ChessboardPoint(x + dx[i], y + 1));
                    }
                }
            }
            if (y == 7 && x > 0 && x < 7) {
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y].name < flag2) {
                        move.add(new ChessboardPoint(x + dx[i], y));
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (chessComponents[x + dx[i]][y - 1].name < flag2) {
                        move.add(new ChessboardPoint(x + dx[i], y - 1));
                    }
                }
            }
            if (x == 0 && y == 0) {
                if (chessComponents[x + 1][y].name < flag2) {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (chessComponents[x][y + 1].name < flag2) {
                    move.add(new ChessboardPoint(x, y + 1));
                }
                if (chessComponents[x + 1][y + 1].name < flag2) {
                    move.add(new ChessboardPoint(x + 1, y + 1));
                }
            }
            if (x == 7 && y == 0) {
                if (chessComponents[x - 1][y].name < flag2) {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x][y + 1].name < flag2) {
                    move.add(new ChessboardPoint(x, y + 1));
                }
                if (chessComponents[x - 1][y + 1].name < flag2) {
                    move.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
            if (x == 0 && y == 7) {
                if (chessComponents[x + 1][y].name < flag2) {
                    move.add(new ChessboardPoint(x + 1, y));
                }
                if (chessComponents[x][y - 1].name < flag2) {
                    move.add(new ChessboardPoint(x, y - 1));
                }
                if (chessComponents[x + 1][y - 1].name < flag2) {
                    move.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            if (x == 7 && y == 7) {
                if (chessComponents[x - 1][y].name < flag2) {
                    move.add(new ChessboardPoint(x - 1, y));
                }
                if (chessComponents[x][y - 1].name < flag2) {
                    move.add(new ChessboardPoint(x, y - 1));
                }
                if (chessComponents[x - 1][y - 1].name < flag2) {
                    move.add(new ChessboardPoint(x - 1, y - 1));
                }
            }
        }
        return move;
    }
}