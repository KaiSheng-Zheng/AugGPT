import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.NONE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'R': {
                        RookChessComponent a = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        a.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'r': {
                        RookChessComponent a = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'N': {
                        KnightChessComponent a = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        a.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'n': {
                        KnightChessComponent a = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'B': {
                        BishopChessComponent a = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        a.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'b': {
                        BishopChessComponent a = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'Q': {
                        QueenChessComponent a = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        a.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'q': {
                        QueenChessComponent a = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'K': {
                        KingChessComponent a = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        a.setChessColor(ChessColor.BLACK);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'k': {
                        KingChessComponent a = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case 'p': {
                        PawnChessComponent a = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        a.setChessColor(ChessColor.WHITE);
                        chessComponents[i][j] = a;
//                        a.setFirst1(true);
                        break;
                    }
                    case 'P': {
                        PawnChessComponent a = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        a.setChessColor(ChessColor.BLACK);
//                        a.setFirst1(true);
                        chessComponents[i][j] = a;
                        break;
                    }
                    case '_': {
                        EmptySlotComponent a = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                        chessComponents[i][j] = a;
                        break;
                    }
                    default: {
                        break;
                    }
                }
                this.chessComponents[i][j].setChessCompont(this.chessComponents);
            }
        }
        currentPlayer = chessboard.get(8).equals("w") ? ChessColor.WHITE : ChessColor.BLACK;

    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
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
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a.append(chessComponents[i][j]);
            }
            if (i != 7) {
                a.append("\n");
            }
        }
        return a.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder a = new StringBuilder();
        int r = 0, n = 0, b = 0, q = 0, k = 0, p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor().equals(player)) {
                    switch (chessComponents[i][j].getName()) {
                        case 'R':
                        case 'r': {
                            r++;
                            break;
                        }
                        case 'N':
                        case 'n': {
                            n++;
                            break;
                        }
                        case 'B':
                        case 'b': {
                            b++;
                            break;
                        }
                        case 'Q':
                        case 'q': {
                            q++;
                            break;
                        }
                        case 'k':
                        case 'K': {
                            k++;
                            break;
                        }
                        case 'p':
                        case 'P': {
                            p++;
                            break;
                        }
                        case '_':
                        default: {
                            break;
                        }
                    }
                }
            }
        }
        if (player.equals(ChessColor.BLACK)) {
            if (k != 1) {
                a.append("K ");
                a.append(String.valueOf(1 - k));
                a.append("\n");
            }
            if (q != 1) {
                a.append("Q ");
                a.append(String.valueOf(1 - q));
                a.append("\n");

            }
            if (r != 2) {
                a.append("R ");
                a.append(String.valueOf(2 - r));
                a.append("\n");

            }
            if (b != 2) {
                a.append("B ");
                a.append(String.valueOf(2 - b));
                a.append("\n");

            }
            if (n != 2) {
                a.append("N ");
                a.append(String.valueOf(2 - n));
                a.append("\n");

            }
            if (p != 8) {
                a.append("P ");
                a.append(String.valueOf(8 - p));
                a.append("\n");

            }

        } else if (player.equals(ChessColor.WHITE)) {
            if (k != 1) {
                a.append("k ");
                a.append(String.valueOf(1 - k));
                a.append("\n");
            }
            if (q != 1) {
                a.append("q ");
                a.append(String.valueOf(1 - q));
                a.append("\n");
            }
            if (r != 2) {
                a.append("r ");
                a.append(String.valueOf(2 - r));
                a.append("\n");
            }
            if (b != 2) {
                a.append("b ");
                a.append(String.valueOf(2 - b));
                a.append("\n");
            }
            if (n != 2) {
                a.append("n ");
                a.append(String.valueOf(2 - n));
                a.append("\n");
            }
            if (p != 8) {
                a.append("p ");
                a.append(String.valueOf(8 - p));
                a.append("\n");
            }
        }
        return a.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> a = chess.canMoveTo();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                if (a.get(i).getX() < a.get(j).getX()) {
                    ChessboardPoint l = a.get(j);
                    a.set(j, a.get(i));
                    a.set(i, l);
                } else if (a.get(i).getX() == a.get(j).getX()) {
                    if (a.get(i).getY() < a.get(j).getY()) {
                        ChessboardPoint l = a.get(j);
                        a.set(j, a.get(i));
                        a.set(i, l);
                    }
                }
            }
        }
        return a;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX < 0 || sourceX > 7 || sourceY < 0 || sourceY > 7 || targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        } else {
            if (currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor()) &&
                    !currentPlayer.equals(chessComponents[targetX][targetY].getChessColor())) {
                ChessComponent source = this.getChess(sourceX, sourceY);
                ChessComponent target = this.getChess(targetX, targetY);
                for (int i = 0; i < this.getCanMovePoints(source.getSource()).size(); i++) {
                    if (this.getCanMovePoints(source.getSource()).get(i).toString().equals(target.getSource().toString())) {
                        if (chessComponents[sourceX][sourceY].getName() == 'K') {
                            chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'K');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'k') {
                            chessComponents[targetX][targetY] = new KingChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'k');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'Q') {
                            chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'Q');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'q') {
                            chessComponents[targetX][targetY] = new QueenChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'q');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'N') {
                            chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'N');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'n') {
                            chessComponents[targetX][targetY] = new KnightChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'n');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'R') {
                            chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'R');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'r') {
                            chessComponents[targetX][targetY] = new RookChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'r');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'B') {
                            chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'B');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'b') {
                            chessComponents[targetX][targetY] = new BishopChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'b');
                        } else if (chessComponents[sourceX][sourceY].getName() == 'P') {
                            chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.BLACK, 'P');
                            chessComponents[targetX][targetY].setFirst1(false);
                        } else if (chessComponents[sourceX][sourceY].getName() == 'p') {
                            chessComponents[targetX][targetY] = new PawnChessComponent(new ChessboardPoint(targetX, targetY), ChessColor.WHITE, 'p');
                            chessComponents[targetX][targetY].setFirst1(false);
                        }
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');

                        if (currentPlayer.equals(ChessColor.WHITE)) {
                            currentPlayer = ChessColor.BLACK;
                        } else if (currentPlayer.equals(ChessColor.BLACK)) {
                            currentPlayer = ChessColor.WHITE;
                        }
                        for (int j = 0; j < 8; j++) {
                            for (int k = 0; k < 8; k++) {
                                this.chessComponents[j][k].setChessboard(this.chessComponents);
                            }
                        }
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        }
    }
}

