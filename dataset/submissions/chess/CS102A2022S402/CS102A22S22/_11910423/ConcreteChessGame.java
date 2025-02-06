import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public static ConcreteChessGame I;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
        I = this;
    }

    //I'm Son Tung M-TP, don't forget me

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent currentChess = getChess(source.getX(), source.getY());
        List<ChessboardPoint> sonTungMTP = currentChess.canMoveTo();
        List<ChessboardPoint> amee = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean co = false;
                for (int k = 0; k < sonTungMTP.size(); k++) {
                    if (sonTungMTP.get(k).getX() == i && sonTungMTP.get(k).getY() == j) {
                        co = true;
                        break;
                    }
                }
                if (co) {
                    amee.add(new ChessboardPoint(i, j));
                }
            }
        }
        return amee;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                stringBuilder.append(getChess(i, j).getName());
            }
            if (i != 7) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int KNum = 1;
        int QNum = 1;
        int RNum = 2;
        int NNum = 2;
        int BNum = 2;
        int PNum = 8;
        int kNum = 1;
        int qNum = 1;
        int rNum = 2;
        int nNum = 2;
        int bNum = 2;
        int pNum = 8;
        char currentChessName;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                currentChessName = getChess(i, j).getName();
                switch (currentChessName) {
                    case 'K':
                        KNum--;
                        break;
                    case 'Q':
                        QNum--;
                        break;
                    case 'R':
                        RNum--;
                        break;
                    case 'B':
                        BNum--;
                        break;
                    case 'N':
                        NNum--;
                        break;
                    case 'P':
                        PNum--;
                        break;
                    case 'k':
                        kNum--;
                        break;
                    case 'q':
                        qNum--;
                        break;
                    case 'r':
                        rNum--;
                        break;
                    case 'b':
                        bNum--;
                        break;
                    case 'n':
                        nNum--;
                        break;
                    case 'p':
                        pNum--;
                        break;
                }
            }
        }

        if (player == ChessColor.BLACK) {
            if (KNum != 0) {
                stringBuilder.append("K " + KNum + "\n");
            }
            if (QNum != 0) {
                stringBuilder.append("Q " + QNum + "\n");
            }
            if (RNum != 0) {
                stringBuilder.append("R " + RNum + "\n");
            }
            if (BNum != 0) {
                stringBuilder.append("B " + BNum + "\n");
            }
            if (NNum != 0) {
                stringBuilder.append("N " + NNum + "\n");
            }
            if (PNum != 0) {
                stringBuilder.append("P " + PNum + "\n");
            }
            return stringBuilder.toString();
        }

        if (kNum != 0) {
            stringBuilder.append("k " + kNum + "\n");
        }
        if (qNum != 0) {
            stringBuilder.append("q " + qNum + "\n");
        }
        if (rNum != 0) {
            stringBuilder.append("r " + rNum + "\n");
        }
        if (bNum != 0) {
            stringBuilder.append("b " + bNum + "\n");
        }
        if (nNum != 0) {
            stringBuilder.append("n " + nNum + "\n");
        }
        if (pNum != 0) {
            stringBuilder.append("p " + pNum + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent currentChess = getChess(sourceX, sourceY);
        if (currentChess.getChessColor() != currentPlayer) {
            return false;
        }
        List<ChessboardPoint> canMoveToList = getCanMovePoints(new ChessboardPoint(sourceX, sourceY)) ;
        for (int i = 0; i < canMoveToList.size(); i++) {
            System.out.println(canMoveToList.get(i));
            if ((canMoveToList.get(i).getX() == targetX) && (canMoveToList.get(i).getY() == targetY)) {
                move(currentChess, targetX, targetY);
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
                return true;
            }
        }
        return false;
    }

    private void move(ChessComponent chess, int x, int y) {
        chessComponents[chess.getSource().getX()][chess.getSource().getY()] = new EmptySlotComponent(chess.getSource());
        /*if (getChess(x, y).getChessColor() != ChessColor.NONE) {
            switch (getChess(x, y).getChessColor()) {
                case WHITE:
                    whiteDiedChess.add(String.valueOf(getChess(x, y).getName()));
                    break;
                case BLACK:
                    blackDiedChess.add(String.valueOf(getChess(x, y).getName()).toLowerCase());
                    break;
            }
        }*/
        chessComponents[x][y] = chess;
        chess.setSource(new ChessboardPoint(x, y));
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        String currentLine;
        ChessboardPoint currentPoint;
        for (int i = 0; i < 8; i++) {
            currentLine = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                currentPoint = new ChessboardPoint(i, j);
                switch (currentLine.charAt(j)) {
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(currentPoint, ChessColor.BLACK);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(currentPoint, ChessColor.WHITE);
                        break;
                    default:
                        chessComponents[i][j] = new EmptySlotComponent(currentPoint);
                        break;
                }
            }
        }
        currentLine = chessboard.get(8);
        if (currentLine.equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
    }
}
