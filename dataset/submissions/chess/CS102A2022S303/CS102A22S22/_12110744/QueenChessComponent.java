import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int[] d = {1, -1};

        if (name == 'Q') {
            for (int i = 0; i < 2; i++) {
                int x = source.getX();
                int y = source.getY();
                for (int j = 0; j < 8; j++) {
                    x += d[i];
                    if (x < 8 && x >= 0) {
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
            for (int i = 0; i < 2; i++) {
                int x = source.getX();
                int y = source.getY();
                for (int j = 0; j < 8; j++) {
                    y += d[i];
                    if (y < 8 && y >= 0) {
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
            }//bishop chess component
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
            }for (int k = 0; k < 8; k++) {
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
            } for (int k = 0; k < 8; k++) {
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
            } for (int k = 0; k < 8; k++) {
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
    }
        else {
            for (int i = 0; i < 2; i++) {
                int x = source.getX();
                int y = source.getY();
                for (int j = 0; j < 8; j++) {
                    x += d[i];
                    if (x < 8 && x >= 0) {
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
            for (int i = 0; i < 2; i++) {
                int x = source.getX();
                int y = source.getY();
                for (int j = 0; j < 8; j++) {
                    y += d[i];
                    if (y < 8 && y >= 0) {
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
            } for (int k = 0; k < 8; k++) {
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
            }for (int k = 0; k < 8; k++) {
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
            }for (int k = 0; k < 8; k++) {
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
