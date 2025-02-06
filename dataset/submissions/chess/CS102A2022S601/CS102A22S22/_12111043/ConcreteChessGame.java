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
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case ('P') -> chessComponents[i][j] = new PawnChessComponent('P', chessComponents, new ChessboardPoint(i, j));
                    case ('p') -> chessComponents[i][j] = new PawnChessComponent('p', chessComponents, new ChessboardPoint(i, j));
                    case ('R') -> chessComponents[i][j] = new RookChessComponent('R', chessComponents, new ChessboardPoint(i, j));
                    case ('r') -> chessComponents[i][j] = new RookChessComponent('r', chessComponents, new ChessboardPoint(i, j));
                    case ('N') -> chessComponents[i][j] = new KnightChessComponent('N', chessComponents, new ChessboardPoint(i, j));
                    case ('n') -> chessComponents[i][j] = new KnightChessComponent('n', chessComponents, new ChessboardPoint(i, j));
                    case ('B') -> chessComponents[i][j] = new BishopChessComponent('B', chessComponents, new ChessboardPoint(i, j));
                    case ('b') -> chessComponents[i][j] = new BishopChessComponent('b', chessComponents, new ChessboardPoint(i, j));
                    case ('Q') -> chessComponents[i][j] = new QueenChessComponent('Q', chessComponents, new ChessboardPoint(i, j));
                    case ('q') -> chessComponents[i][j] = new QueenChessComponent('q', chessComponents, new ChessboardPoint(i, j));
                    case ('K') -> chessComponents[i][j] = new KingChessComponent('K', chessComponents, new ChessboardPoint(i, j));
                    case ('k') -> chessComponents[i][j] = new KingChessComponent('k', chessComponents, new ChessboardPoint(i, j));
                    case ('_') -> chessComponents[i][j] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(i, j));
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
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        StringBuilder line4 = new StringBuilder();
        StringBuilder line5 = new StringBuilder();
        StringBuilder line6 = new StringBuilder();
        StringBuilder line7 = new StringBuilder();
        StringBuilder line8 = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            line1.append(getChess(0, i).name);
            line2.append(getChess(1, i).name);
            line3.append(getChess(2, i).name);
            line4.append(getChess(3, i).name);
            line5.append(getChess(4, i).name);
            line6.append(getChess(5, i).name);
            line7.append(getChess(6, i).name);
            line8.append(getChess(7, i).name);
        }
        String a1 = line1.toString();
        String a2 = line2.toString();
        String a3 = line3.toString();
        String a4 = line4.toString();
        String a5 = line5.toString();
        String a6 = line6.toString();
        String a7 = line7.toString();
        String a8 = line8.toString();

        return a1 + "\n" + a2 + "\n" + a3 + "\n" + a4 + "\n" + a5 + "\n" + a6 + "\n" + a7 + "\n" + a8;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder str = new StringBuilder();
        int P = 0, R = 0, N = 0, B = 0, Q = 0, K = 0;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'P' -> P++;
                        case 'R' -> R++;
                        case 'N' -> N++;
                        case 'B' -> B++;
                        case 'Q' -> Q++;
                        case 'K' -> K++;
                    }
                }
            }
            if (K < 1) {
                str.append("K 1\n");
            }
            if (Q < 1) {
                str.append("Q 1\n");
            }
            if (R < 2) {
                str.append(String.format("R %s\n", 2 - R));
            }
            if (B < 2) {
                str.append(String.format("B %s\n", 2 - B));
            }
            if (N < 2) {
                str.append(String.format("N %s\n", 2 - N));
            }
            if (P < 8) {
                str.append(String.format("P %s\n", 8 - P));
            }
            return str.toString();
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'p' -> P++;
                        case 'r' -> R++;
                        case 'n' -> N++;
                        case 'b' -> B++;
                        case 'q' -> Q++;
                        case 'k' -> K++;
                    }
                }
            }
            if (K < 1) {
                str.append("k 1\n");
            }
            if (Q < 1) {
                str.append("q 1\n");
            }
            if (R < 2) {
                str.append(String.format("r %s\n", 2 - R));
            }
            if (B < 2) {
                str.append(String.format("b %s\n", 2 - B));
            }
            if (N < 2) {
                str.append(String.format("n %s\n", 2 - N));
            }
            if (P < 8) {
                str.append(String.format("p %s\n", 8 - P));
            }
            return str.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        if (canMovePoints.size() >= 2) {
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                boolean b = true;
                for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                    ChessboardPoint temp;
                    if (canMovePoints.get(j).getY() > canMovePoints.get(j + 1).getY()) {
                        b = false;
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, temp);
                    }
                }
                if (b) {
                    break;
                }
            }
            for (int i = 0; i < canMovePoints.size() - 1; i++) {
                boolean b = true;
                for (int j = 0; j < canMovePoints.size() - 1 - i; j++) {
                    ChessboardPoint temp;
                    if (canMovePoints.get(j).getX() > canMovePoints.get(j + 1).getX()) {
                        b = false;
                        temp = canMovePoints.get(j);
                        canMovePoints.set(j, canMovePoints.get(j + 1));
                        canMovePoints.set(j + 1, temp);
                    }
                }
                if (b) {
                    break;
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getCurrentPlayer() == ChessColor.BLACK) {
            if (chessComponents[sourceX][sourceY].name <= 90) {
                boolean ok = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() != 0) {
                    for (int i = 0; i < move.size(); i++) {
                        if (move.get(i).getX() == targetX && move.get(i).getY() == targetY) {
                            ok = true;
                            break;
                        }
                    }
                    if (ok) {
                        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                        currentPlayer = ChessColor.WHITE;
                        boardChange(chessComponents);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (chessComponents[sourceX][sourceY].name >= 97) {
                boolean ok = false;
                List<ChessboardPoint> move = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                if (move.size() != 0) {
                    for (int i = 0; i < move.size(); i++) {
                        if (move.get(i).getX() == targetX && move.get(i).getY() == targetY) {
                            ok = true;
                            break;
                        }
                    }
                    if (ok) {
                        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(sourceX, sourceY));
                        currentPlayer = ChessColor.BLACK;
                        boardChange(chessComponents);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    public void boardChange(ChessComponent[][]chessComponents){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case ('P') -> chessComponents[i][j] = new PawnChessComponent('P', chessComponents, new ChessboardPoint(i, j));
                    case ('p') -> chessComponents[i][j] = new PawnChessComponent('p', chessComponents, new ChessboardPoint(i, j));
                    case ('R') -> chessComponents[i][j] = new RookChessComponent('R', chessComponents, new ChessboardPoint(i, j));
                    case ('r') -> chessComponents[i][j] = new RookChessComponent('r', chessComponents, new ChessboardPoint(i, j));
                    case ('N') -> chessComponents[i][j] = new KnightChessComponent('N', chessComponents, new ChessboardPoint(i, j));
                    case ('n') -> chessComponents[i][j] = new KnightChessComponent('n', chessComponents, new ChessboardPoint(i, j));
                    case ('B') -> chessComponents[i][j] = new BishopChessComponent('B', chessComponents, new ChessboardPoint(i, j));
                    case ('b') -> chessComponents[i][j] = new BishopChessComponent('b', chessComponents, new ChessboardPoint(i, j));
                    case ('Q') -> chessComponents[i][j] = new QueenChessComponent('Q', chessComponents, new ChessboardPoint(i, j));
                    case ('q') -> chessComponents[i][j] = new QueenChessComponent('q', chessComponents, new ChessboardPoint(i, j));
                    case ('K') -> chessComponents[i][j] = new KingChessComponent('K', chessComponents, new ChessboardPoint(i, j));
                    case ('k') -> chessComponents[i][j] = new KingChessComponent('k', chessComponents, new ChessboardPoint(i, j));
                    case ('_') -> chessComponents[i][j] = new EmptySlotComponent('_', chessComponents, new ChessboardPoint(i, j));
                }
            }
        }
    }
}
