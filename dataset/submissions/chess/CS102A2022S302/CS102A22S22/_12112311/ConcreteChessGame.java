import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            String row = chessboard.get(i);
            for (int j = 0; j < row.length(); j++) {
                char chessName = row.charAt(j);
                if (chessName != '_') {
                    switch (chessName) {
                        case 'R':
                            chessComponents[i][j] = new RookChessComponent('R');
                            break;
                        case 'N':
                            chessComponents[i][j] = new KnightChessComponent('N');
                            break;
                        case 'B':
                            chessComponents[i][j] = new BishopChessComponent('B');
                            break;
                        case 'Q':
                            chessComponents[i][j] = new QueenChessComponent('Q');
                            break;
                        case 'K':
                            chessComponents[i][j] = new KingChessComponent('K');
                            break;
                        case 'P':
                            chessComponents[i][j] = new PawnChessComponent('P');
                            break;
                        case 'r':
                            chessComponents[i][j] = new RookChessComponent('r');
                            break;
                        case 'n':
                            chessComponents[i][j] = new KnightChessComponent('n');
                            break;
                        case 'b':
                            chessComponents[i][j] = new BishopChessComponent('b');
                            break;
                        case 'q':
                            chessComponents[i][j] = new QueenChessComponent('q');
                            break;
                        case 'k':
                            chessComponents[i][j] = new KingChessComponent('k');
                            break;
                        case 'p':
                            chessComponents[i][j] = new PawnChessComponent('p');
                            break;
                    }
                    if (Character.isUpperCase(chessName)) {
                        chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    } else {
                        chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    }
                } else {
                    chessComponents[i][j] = new EmptySlotComponent('_');
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                }
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }

        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        List<String> rows = new ArrayList<>();
        StringBuilder row1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            row1.setLength(0);
            for (int j = 0; j < 8; j++) {
                row1.append(chessComponents[i][j].getName());
            }
            rows.add(row1.toString());
        }
        String s = rows.get(0) + "\n" + rows.get(1) + "\n" + rows.get(2) + "\n" + rows.get(3) + "\n"
                + rows.get(4) + "\n" + rows.get(5) + "\n" + rows.get(6) + "\n" + rows.get(7);
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        List<ChessComponent> allChess = new ArrayList<>();
        ChessComponent tempChess;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor().equals(player)) {
                    tempChess = chessComponents[i][j];
                    allChess.add(tempChess);
                }
            }
        }
        int r = 0, n = 0, b = 0, q = 0, k = 0, p = 0;
        for (int i = 0; i < allChess.size(); i++) {
            if (allChess.get(i) instanceof RookChessComponent) {
                r += 1;
            } else if (allChess.get(i) instanceof KnightChessComponent) {
                n += 1;
            } else if (allChess.get(i) instanceof BishopChessComponent) {
                b += 1;
            } else if (allChess.get(i) instanceof QueenChessComponent) {
                q += 1;
            } else if (allChess.get(i) instanceof KingChessComponent) {
                k += 1;
            } else if (allChess.get(i) instanceof PawnChessComponent) {
                p += 1;
            }
        }
        StringBuilder s = new StringBuilder();
        int num = 0;
        if (k != 1) {
            s.append("K 1\n");
        }
        if (q != 1) {
            s.append("Q 1\n");
        }
        if (r != 2) {
            num = 2 - r;
            s.append("R " + num + "\n");
        }
        if (b != 2) {
            num = 2 - b;
            s.append("B " + num + "\n");
        }
        if (n != 2) {
            num = 2 - n;
            s.append("N " + num + "\n");
        }
        if (p != 8) {
            num = 8 - p;
            s.append("P " + num + "\n");
        }
        if (player.equals(ChessColor.BLACK)) {
            return s.toString();
        } else {
            return s.toString().toLowerCase();
        }


    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        Collections.sort(canMovePoints);


        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() != currentPlayer) {
            return false;
        }
        int check = 0;
        for (int i = 0; i < getChess(sourceX, sourceY).canMoveTo().size(); i++) {
            if (getChess(sourceX, sourceY).canMoveTo().get(i).getX() == targetX
                    && getChess(sourceX, sourceY).canMoveTo().get(i).getY() == targetY) {
                check = 1;
                break;
            }
        }
        if (check == 0) {

            return false;
        }
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_');
        chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX, sourceY));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
        if (currentPlayer == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
        } else if (currentPlayer == ChessColor.WHITE) {
            currentPlayer = ChessColor.BLACK;
        }
        return true;
    }
}

