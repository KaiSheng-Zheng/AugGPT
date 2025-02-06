import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        } else currentPlayer = ChessColor.WHITE;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'P' || chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'R' || chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'N' || chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'B' || chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'Q' || chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == 'K' || chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(chessboard.get(i).charAt(j), chessComponents, new ChessboardPoint(i, j));
                }
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
        StringBuilder Line = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Line.append(getChess(i, j).name);
            }
        }
        String Line1 = Line.substring(0, 8);
        String Line2 = Line.substring(8, 16);
        String Line3 = Line.substring(16, 24);
        String Line4 = Line.substring(24, 32);
        String Line5 = Line.substring(32, 40);
        String Line6 = Line.substring(40, 48);
        String Line7 = Line.substring(48, 56);
        String Line8 = Line.substring(56, 64);

        return Line1 + "\n" + Line2 + "\n" + Line3 + "\n" + Line4 + "\n" + Line5 + "\n" + Line6 + "\n" + Line7 + "\n" + Line8 + "\n";
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int B = 2, Q = 1, K = 1, P = 8, R = 2, N = 2;
        int b = 2, q = 1, k = 1, p = 8, r = 2, n = 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'B') B--;
                if (chessComponents[i][j].name == 'Q') Q--;
                if (chessComponents[i][j].name == 'K') K--;
                if (chessComponents[i][j].name == 'P') P--;
                if (chessComponents[i][j].name == 'R') R--;
                if (chessComponents[i][j].name == 'N') N--;
                if (chessComponents[i][j].name == 'b') b--;
                if (chessComponents[i][j].name == 'q') q--;
                if (chessComponents[i][j].name == 'k') k--;
                if (chessComponents[i][j].name == 'p') p--;
                if (chessComponents[i][j].name == 'r') r--;
                if (chessComponents[i][j].name == 'n') n--;
            }
        }
        StringBuilder capture = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (K != 0) capture.append("K 1\n");

            if (Q != 0) capture.append("Q 1\n");

            if (R != 0) capture.append("R ").append(R).append("\n");

            if (B != 0) capture.append("B ").append(B).append("\n");

            if (N != 0) capture.append("N ").append(N).append("\n");

            if (P != 0) capture.append("P ").append(P).append("\n");

        }
        if (player == ChessColor.WHITE) {
            if (k != 0) capture.append("k 1\n");

            if (q != 0) capture.append("q 1\n");

            if (r != 0) capture.append("r ").append(r).append("\n");

            if (b != 0) capture.append("b ").append(b).append("\n");

            if (n != 0) capture.append("n ").append(n).append("\n");

            if (p != 0) capture.append("p ").append(p).append("\n");
        }
        return capture.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return ChessboardPoint.sort(chess.canMoveTo());
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer() == ChessColor.WHITE) {
            if (chessComponents[sourceX][sourceY].name < 'a') {
                return false;
            } else {
                boolean flag = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() == 0) return false;
                for (ChessboardPoint chessboardPoint : move) {
                    if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                currentPlayer = ChessColor.BLACK;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessComponents[i][j].name == 'P' || chessComponents[i][j].name == 'p') {
                            chessComponents[i][j] = new PawnChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'R' || chessComponents[i][j].name == 'r') {
                            chessComponents[i][j] = new RookChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'N' || chessComponents[i][j].name == 'n') {
                            chessComponents[i][j] = new KingChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'B' || chessComponents[i][j].name == 'b') {
                            chessComponents[i][j] = new BishopChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'Q' || chessComponents[i][j].name == 'q') {
                            chessComponents[i][j] = new QueenChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'K' || chessComponents[i][j].name == 'k') {
                            chessComponents[i][j] = new KingChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == '_') {
                            chessComponents[i][j] = new EmptySlotComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                    }
                }
                return true;
            }
        } else {
            if (chessComponents[sourceX][sourceY].name > 'Z') {
                return false;
            } else {
                boolean flag = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() == 0) return false;
                for (ChessboardPoint chessboardPoint : move) {
                    if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                currentPlayer = ChessColor.WHITE;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (chessComponents[i][j].name == 'P' || chessComponents[i][j].name == 'p') {
                            chessComponents[i][j] = new PawnChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'R' || chessComponents[i][j].name == 'r') {
                            chessComponents[i][j] = new RookChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'N' || chessComponents[i][j].name == 'n') {
                            chessComponents[i][j] = new KingChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'B' || chessComponents[i][j].name == 'b') {
                            chessComponents[i][j] = new BishopChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'Q' || chessComponents[i][j].name == 'q') {
                            chessComponents[i][j] = new QueenChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == 'K' || chessComponents[i][j].name == 'k') {
                            chessComponents[i][j] = new KingChessComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                        if (chessComponents[i][j].name == '_') {
                            chessComponents[i][j] = new EmptySlotComponent(chessComponents[i][j].name, chessComponents, new ChessboardPoint(i, j));
                        }
                    }
                }
                return true;
            }
        }
    }
}