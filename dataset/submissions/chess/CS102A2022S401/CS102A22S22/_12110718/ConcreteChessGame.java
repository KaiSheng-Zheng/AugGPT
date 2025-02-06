import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String[] chess = chessboard.get(i).split("");
//            System.out.println(Arrays.toString(chess));
            for (int j = 0; j < chess.length; j++) {
                switch (chess[j]) {
                    case "K":
                        KingChessComponent king = new KingChessComponent();
                        king.setName('K');
                        king.setChessColor(ChessColor.BLACK);
                        king.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = king;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "Q":
                        QueenChessComponent queen = new QueenChessComponent();
                        queen.setName('Q');
                        queen.setChessColor(ChessColor.BLACK);
                        queen.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = queen;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "R":
                        RookChessComponent rook = new RookChessComponent();
                        rook.setName('R');
                        rook.setChessColor(ChessColor.BLACK);
                        rook.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = rook;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "B":
                        BishopChessComponent bishop = new BishopChessComponent();
                        bishop.setName('B');
                        bishop.setChessColor(ChessColor.BLACK);
                        bishop.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = bishop;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "N":
                        KnightChessComponent knight = new KnightChessComponent();
                        knight.setName('N');
                        knight.setChessColor(ChessColor.BLACK);
                        knight.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = knight;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "P":
                        PawnChessComponent pawn = new PawnChessComponent();
                        pawn.setName('P');
                        pawn.setChessColor(ChessColor.BLACK);
                        pawn.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = pawn;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "k":
                        KingChessComponent king1 = new KingChessComponent();
                        king1.setName('k');
                        king1.setChessColor(ChessColor.WHITE);
                        king1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = king1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "q":
                        QueenChessComponent queen1 = new QueenChessComponent();
                        queen1.setName('q');
                        queen1.setChessColor(ChessColor.WHITE);
                        queen1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = queen1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "r":
                        RookChessComponent rook1 = new RookChessComponent();
                        rook1.setName('r');
                        rook1.setChessColor(ChessColor.WHITE);
                        rook1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = rook1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "b":
                        BishopChessComponent bishop1 = new BishopChessComponent();
                        bishop1.setName('b');
                        bishop1.setChessColor(ChessColor.WHITE);
                        bishop1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = bishop1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "n":
                        KnightChessComponent knight1 = new KnightChessComponent();
                        knight1.setName('n');
                        knight1.setChessColor(ChessColor.WHITE);
                        knight1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = knight1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "p":
                        PawnChessComponent pawn1 = new PawnChessComponent();
                        pawn1.setName('p');
                        pawn1.setChessColor(ChessColor.WHITE);
                        pawn1.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = pawn1;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
                    case "_":
                        EmptySlotComponent empty = new EmptySlotComponent();
                        empty.setName('_');
                        empty.setChessColor(ChessColor.NONE);
                        empty.setSource(new ChessboardPoint(i, j));
                        chessComponents[i][j] = empty;
                        chessComponents[i][j].setConcreteChessGame(this);
                        break;
//                    default:
//                        throw new IllegalStateException("Unexpected value: " + chess[j]);
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder chessboard = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard.append(chessComponents[i][j].name);
            }
            chessboard.append("\n");
        }
        return chessboard.toString();
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder CapturedChess = new StringBuilder();
        int k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'k':
                            k--;
                            break;
                        case 'q':
                            q--;
                            break;
                        case 'r':
                            r--;
                            break;
                        case 'b':
                            b--;
                            break;
                        case 'n':
                            n--;
                            break;
                        case 'p':
                            p--;
                            break;
                    }
                }
            }
            if (k != 0) {
                CapturedChess.append("k ");
                CapturedChess.append(k);
                CapturedChess.append("\n");
            }
            if (q != 0) {
                CapturedChess.append("q ");
                CapturedChess.append(q);
                CapturedChess.append("\n");
            }
            if (r != 0) {
                CapturedChess.append("r ");
                CapturedChess.append(r);
                CapturedChess.append("\n");
            }
            if (b != 0) {
                CapturedChess.append("b ");
                CapturedChess.append(b);
                CapturedChess.append("\n");
            }
            if (n != 0) {
                CapturedChess.append("n ");
                CapturedChess.append(n);
                CapturedChess.append("\n");
            }
            if (p != 0) {
                CapturedChess.append("p ");
                CapturedChess.append(p);
                CapturedChess.append("\n");
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K':
                            k--;
                            break;
                        case 'Q':
                            q--;
                            break;
                        case 'R':
                            r--;
                            break;
                        case 'B':
                            b--;
                            break;
                        case 'N':
                            n--;
                            break;
                        case 'P':
                            p--;
                            break;
                    }
                }
            }
            if (k != 0) {
                CapturedChess.append("K ");
                CapturedChess.append(k);
                CapturedChess.append("\n");
            }
            if (q != 0) {
                CapturedChess.append("Q ");
                CapturedChess.append(q);
                CapturedChess.append("\n");
            }
            if (r != 0) {
                CapturedChess.append("R ");
                CapturedChess.append(r);
                CapturedChess.append("\n");
            }
            if (b != 0) {
                CapturedChess.append("B ");
                CapturedChess.append(b);
                CapturedChess.append("\n");
            }
            if (n != 0) {
                CapturedChess.append("N ");
                CapturedChess.append(n);
                CapturedChess.append("\n");
            }
            if (p != 0) {
                CapturedChess.append("P ");
                CapturedChess.append(p);
                CapturedChess.append("\n");
            }
        }

        return CapturedChess.toString();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint a = new ChessboardPoint(targetX, targetY);
        List<ChessboardPoint> A;
        if (getChess(sourceX, sourceY).getChessColor() == ChessColor.NONE || currentPlayer != getChess(sourceX, sourceY).getChessColor()) {
            return false;
        }
        switch (getChess(sourceX, sourceY).name) {
            case 'k' | 'K':
                A = new KingChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
            case 'q' | 'Q':
                A = new QueenChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
            case 'r' | 'R':
                A = new RookChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
            case 'b' | 'B':
                A = new BishopChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
            case 'N' | 'n':
                A = new KnightChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
            case 'p' | 'P':
                A = new PawnChessComponent().canMoveTo();
                if (A.contains(a)) {
                    if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    chessComponents[sourceX][sourceY] = null;
                    chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                    return true;
                }
        }
        return false;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if (getChess(source.getX(), source.getY()).name == '_') {
            return new ArrayList<>();
        }
        return getChess(source.getX(), source.getY()).canMoveTo();

    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}



