import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
//complete done
    public BishopChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }public BishopChessComponent(char name){
        super(name);
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (name == 'B') {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x++;
                y++;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name >= 'a') {
                        move.add(new ChessboardPoint(x, y));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x++;
                y++;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name <= 'Z') {
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

        if (name == 'B') {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x++;
                y--;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name =='_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name >= 'a') {
                        move.add(new ChessboardPoint(x, y));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x++;
                y--;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name <= 'Z') {
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
        if (name == 'B') {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x--;
                y--;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name >= 'a') {
                        move.add(new ChessboardPoint(x, y));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x--;
                y--;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name <='Z') {
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
        if (name == 'B') {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x--;
                y++;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name =='_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name >= 'a') {
                        move.add(new ChessboardPoint(x, y));
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            int x = source.getX();
            int y = source.getY();
            for (int k = 0; k < 8; k++) {
                x--;
                y++;
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    if (chessComponents[x][y].name == '_') {
                        move.add(new ChessboardPoint(x, y));
                    } else if (chessComponents[x][y].name <= 'Z') {
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
        return move;
    }
}